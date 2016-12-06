package test.activiti.bpmn.config;

import com.musigma.esp.bpmn.interfaces.*;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test.activiti.bpmnImpl.*;

/**
 * @author sudhir
 *         Date:6/12/16
 *         Time:2:55 PM
 *         Project:bpmn-service
 */
@Configuration
public class BpmnAutoActivitiConfig {

    @Autowired
    private  RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private IdentityService identityService;
    @Autowired
    private TaskService taskService;
    @Bean
    public BpmnRepositoryService bpmnRepositoryService(){
        return new ActivitiRepositoryService(repositoryService);
    }

    @Bean
    public BpmnRuntimeService bpmnRuntimeService(){
        return new ActivitiRuntimeService(runtimeService);
    }

    @Bean
    public BpmnDeploymentService bpmnDeploymentService(){
        return new ActivitiDeploymentService(repositoryService);
    }

    @Bean
    public BpmnIdentityService bpmnIdentityService(){
        return new ActivityBpmnIdentityService(identityService);
    }

    @Bean
    public BpmnTaskService bpmnTaskService(){
        return new ActivitiTaskService(taskService);
    }

    @Bean
    public BpmnDriverManager bpmnDriverManager(){
        return new ActivitiDriverManager(bpmnDeploymentService(),bpmnRuntimeService(),bpmnRepositoryService(),
                bpmnIdentityService());
    }
}
