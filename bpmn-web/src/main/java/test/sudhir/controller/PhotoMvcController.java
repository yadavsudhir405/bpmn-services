package test.sudhir.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import test.sudhir.bpmn.interfaces.BpmnTaskService;
import test.sudhir.entity.Photo;
import test.sudhir.repository.PhotoRepository;
import test.sudhir.service.EmailService;
import test.sudhir.service.PhotoService;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sudhir
 *         Date:7/11/16
 *         Time:5:46 PM
 *         Project:demo
 */
@Controller
public class PhotoMvcController {

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private PhotoService photoService;
    @Autowired
    private EmailService emailService;

    @Autowired
    private BpmnTaskService taskService;


    @RequestMapping(method = RequestMethod.POST, value = "/upload")
    String upload(MultipartHttpServletRequest request /*Principal principal*/) {

        //System.out.println("uploading for " + principal.toString());
        Optional.ofNullable(request.getMultiFileMap()).ifPresent(m -> {

            // gather all the MFs in one collection
            List<MultipartFile> multipartFiles = new ArrayList<>();
            m.values().forEach((t) -> {
                multipartFiles.addAll(t);
            });
            // convert them all into `Photo`s
            List<Photo> photos = multipartFiles.stream().map(f -> {
                try {
                    return this.photoService.createPhoto("sudhir"/*principal.getName()*/, f.getInputStream());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).collect(Collectors.toList());

            System.out.println("started photo process w/ process instance ID: " +
                    this.photoService.launchPhotoProcess(photos));

        });
        return "redirect:/";
    }

    @RequestMapping(value = "/image/{id}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    Resource image(@PathVariable Long id) {
        return new InputStreamResource(this.photoService.readPhoto(this.photoRepository.findOne(id)));
    }

    @RequestMapping(value = "/approve", method = RequestMethod.POST)
    String approveTask(@RequestParam String taskId, @RequestParam String approved) {
        boolean isApproved = !(approved == null || approved.trim().equals("") || approved.toLowerCase().contains("f") || approved.contains("0"));
        this.taskService.complete(taskId, Collections.singletonMap("approved", true));
        return "redirect:approve";
    }

    @RequestMapping(value = "/approve", method = RequestMethod.GET)
    String setupApprovalPage(Model model) {
        List<String> outstandingTaskIds = taskService.getTasksGroupWise("photoReviewers");
        if (0 < outstandingTaskIds.size()) {
            String taskId = outstandingTaskIds.iterator().next();
            model.addAttribute("task", taskId);
            List<Photo> photos = (List<Photo>) taskService.getVariable(taskId, "photos");
            model.addAttribute("photos", photos);
        }
        return "approve";
    }
    @RequestMapping(value = "/triggerEmailService",method = RequestMethod.POST)
    String triggerEmail(@RequestParam String triggerEmail ){
        System.out.println("Triggering Email Task");
        emailService.sendEmail();
        return "success";

    }
}
