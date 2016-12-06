package com.musigma.esp.muFlow.javaDelegateService;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.musigma.esp.muFlow.entity.Photo;
import com.musigma.esp.muFlow.service.PhotoService;

/**
 * @author sudhir
 *         Date:3/11/16
 *         Time:7:05 PM
 *         Project:demo
 */
@Component(value = "activitiDelegate")
public class ApprovedJavaTask implements JavaDelegate {

    @Autowired
    private PhotoService photoService;
    @Override
    public void execute(DelegateExecution execution) {
        System.out.println("*********************Photos got Received******************");

        Photo photo = (Photo) execution.getVariable("photo");
        Long photoId = photo.getId();
       // System.out.println("integration: handling execution " + headers.toString());
        System.out.println("integration: handling photo #" + photoId);

        photoService.dogifyPhoto(photo);
        System.out.println("Photo Dogified");

    }
}
