package com.musigma.esp.muFlow.config1;


import com.musigma.esp.muFlow.javaDelegateService.JavaService;
import doge.photo.DogePhotoManipulator;
/*import org.activiti.spring.integration.ActivitiInboundGateway;
import org.activiti.spring.integration.IntegrationActivityBehavior;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.support.GenericHandler;
import org.springframework.integration.support.MessageBuilder;*/
import com.musigma.esp.bpmn.interfaces.BpmnDriverManager;
import com.musigma.esp.bpmn.interfaces.BpmnGroup;
import com.musigma.esp.bpmn.interfaces.BpmnIdentityService;
import com.musigma.esp.bpmn.interfaces.BpmnUser;
import com.musigma.esp.muFlow.javaDelegateService.JavaDelegateService;

/**
 * @author sudhir
 *         Date:7/11/16
 *         Time:5:33 PM
 *         Project:demo
 */
//@EnableAutoConfiguration
@Configuration
//@ComponentScan(basePackages = {"demo.controller,demo.entity,demo.javaDelegateService,demo.service,demo.repository"})
/*@ComponentScan(basePackages = {"demo.controller","demo.entitiy","demo.javaDelegateService","demo.service","demo" +
        ".repository"})*/

//@Import({WebMvcConfiguration.class,WebSecurityConfiguration.class})
public class Appconfig {

    @Autowired
    private  BpmnDriverManager bpmnDriverManager;

    @Bean
    JavaDelegateService javaDelegateService(){
        return new JavaDelegateService();
    }
    @Bean
    JavaService javaService(){
        return new JavaService();
    }
    @Bean
    CommandLineRunner init() {
        return new CommandLineRunner( ) {
            @Override
            public void run(String... strings) throws Exception {
                // install groups & users
                BpmnIdentityService identityService=bpmnDriverManager.getBpmnIdentityService();
                BpmnGroup approvers = group("photoReviewers");
                BpmnGroup uploaders = group("photoUploaders");

                BpmnUser joram = user("sudhir", "Joram", "Barrez");
                bpmnDriverManager.getBpmnIdentityService().createMemberShip(joram.getId(),approvers.getId());
                bpmnDriverManager.getBpmnIdentityService().createMemberShip(joram.getId(), uploaders.getId());

                BpmnUser josh = user("jlong", "Josh", "Long");
                bpmnDriverManager.getBpmnIdentityService().createMemberShip(josh.getId(), uploaders.getId());

            }

            private BpmnUser user(String userName, String f, String l) {
                BpmnUser u = bpmnDriverManager.getBpmnIdentityService().newUser(userName);
                u.setFirstName(f);
                u.setLastName(l);
                u.setPassword("password");
                System.out.println("**************** Saving User*****************");
                bpmnDriverManager.getBpmnIdentityService().saveUser(u);
                return u;
            }

            private BpmnGroup group(String groupName) {
                BpmnGroup group = bpmnDriverManager.getBpmnIdentityService().newGroup(groupName);
                group.setName(groupName);
                group.setType("security-role");
                bpmnDriverManager.getBpmnIdentityService().saveGroup(group);
                return group;
            }
        };

    }
    @Bean
    DogePhotoManipulator dogePhotoManipulator() {
        DogePhotoManipulator dogePhotoManipulator = new DogePhotoManipulator();
        dogePhotoManipulator.addTextOverlay("pivotal", "abstractfactorybean", "java");
        dogePhotoManipulator.addTextOverlay("spring", "annotations", "boot");
        dogePhotoManipulator.addTextOverlay("code", "semicolonfree", "groovy");
        dogePhotoManipulator.addTextOverlay("clean", "juergenized", "spring");
        dogePhotoManipulator.addTextOverlay("workflow", "activiti", "BPM");
        return dogePhotoManipulator;
    }
   /* @Bean
    IntegrationActivityBehavior activitiDelegate(ActivitiInboundGateway activitiInboundGateway) {
        return new IntegrationActivityBehavior(activitiInboundGateway);
    }

    @Bean
    ActivitiInboundGateway inboundGateway(ProcessEngine processEngine) {
        return new ActivitiInboundGateway(processEngine, "processed", "userId", "photo", "photos");
    }

    @Bean
    IntegrationFlow inboundProcess(
            ActivitiInboundGateway activitiInboundGateway, PhotoService photoService) {
        return IntegrationFlows
                .from(activitiInboundGateway)
                .handle(
                        new GenericHandler<DelegateExecution>() {
                            @Override
                            public Object handle(DelegateExecution execution, Map<String, Object> headers) {
                                Photo photo = (Photo) execution.getVariable("photo");
                                Long photoId = photo.getId();
                                System.out.println("integration: handling execution " + headers.toString());
                                System.out.println("integration: handling photo #" + photoId);

                                photoService.dogifyPhoto(photo);

                                return MessageBuilder.withPayload(execution)
                                        .setHeader("processed", (Object) true)
                                        .copyHeaders(headers).build();
                            }
                        }
                )
                .get();
    }*/


}
