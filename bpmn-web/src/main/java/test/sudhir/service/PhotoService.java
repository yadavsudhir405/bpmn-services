package test.sudhir.service;


import doge.photo.PhotoManipulator;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import test.sudhir.bpmn.interfaces.BpmnDriverManager;
import test.sudhir.bpmn.interfaces.BpmnRuntimeService;
import test.sudhir.entity.Photo;
import test.sudhir.repository.PhotoRepository;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.Collections;
import java.util.List;

/**
 * @author sudhir
 *         Date:7/11/16
 *         Time:5:43 PM
 *         Project:demo
 */
@Service
@Transactional
public class PhotoService {

    @Autowired
    private BpmnDriverManager bpmnDriverManager;

    @Autowired
    private PhotoManipulator photoManipulator;

    /*@Autowired
    private TaskService taskService;
*/
    @Value("file://#{ systemProperties['user.home'] }/Desktop/uploads")
    private Resource uploadDirectory;

    @Autowired
    private BpmnRuntimeService runtimeService;

    @Autowired
    private PhotoRepository photoRepository;

    @PostConstruct
    public void beforeService() throws Exception {
        File uploadDir = this.uploadDirectory.getFile();
        Assert.isTrue(uploadDir.exists() || uploadDir.mkdirs(), "the " + uploadDir.getAbsolutePath() + " folder must exist!");
    }

    protected void writePhoto(Photo photo, InputStream inputStream) {
        try {
            try (InputStream input = inputStream;
                 FileOutputStream output = new FileOutputStream(new File(this.uploadDirectory.getFile(), Long.toString(photo.getId())))) {
                IOUtils.copy(input, output);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public InputStream readPhoto(Photo photo) {
        try {
            return new FileInputStream(new File(this.uploadDirectory.getFile(), Long.toString(photo.getId())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public Photo createPhoto(String userId, InputStream bytesForImage) {
        Photo photo = this.photoRepository.save(new Photo((userId), false));
        writePhoto(photo, bytesForImage);
        return photo;
    }

    public String launchPhotoProcess(List<Photo> photos) {
        System.out.println("Deploying ProcessDefination");
        String deploymentId=bpmnDriverManager.getBpmnDeploymentService().deploy("photoProcess",
                "/home/sudhir/yadavsudhir405/activiti-spring-boot-webinar/activiti-spring-boot-webinar/src/main/resources/processes/upload.bpmn20.xml");
        System.out.println("Uplaod Process Defination is deployed with Id "+deploymentId);
       return runtimeService.startProcessInstanceById("photoProcess", Collections.singletonMap("photos", photos));

    }

    public void dogifyPhoto(Photo photo) {
        try {
            InputStream inputStream = this.photoManipulator.manipulate(() -> this.readPhoto(photo)).getInputStream();
            writePhoto(photo, inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
