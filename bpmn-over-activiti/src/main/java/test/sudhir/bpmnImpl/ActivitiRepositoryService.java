package test.sudhir.bpmnImpl;

import org.activiti.engine.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.sudhir.BpmnRepositoryService;

/**
 * @author sudhir
 *         Date:3/12/16
 *         Time:3:01 PM
 *         Project:bpmn-service
 */
@Component
class ActivitiRepositoryService implements BpmnRepositoryService {

    @Autowired
    private RepositoryService repositoryService;

    public void deleteDeployment(String deploymentId) {
        repositoryService.deleteDeployment(deploymentId);
    }
}
