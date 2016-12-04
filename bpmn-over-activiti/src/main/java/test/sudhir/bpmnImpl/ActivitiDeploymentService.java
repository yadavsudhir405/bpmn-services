package test.sudhir.bpmnImpl;

import org.springframework.stereotype.Component;
import test.sudhir.bpmn.interfaces.BpmnDeploymentService;

/**
 * @author sudhir
 *         Date:3/12/16
 *         Time:3:16 PM
 *         Project:bpmn-service
 */
@Component
public class ActivitiDeploymentService implements BpmnDeploymentService {

    public void deploy(String processDefination) {
        System.out.println("Deploying ProcessDefination "+processDefination);
    }
}
