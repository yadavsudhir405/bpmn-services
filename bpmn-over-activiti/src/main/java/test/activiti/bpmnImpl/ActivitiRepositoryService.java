package test.activiti.bpmnImpl;

import com.musigma.esp.bpmn.interfaces.BpmnRepositoryService;
import org.activiti.engine.RepositoryService;

/**
 * @author sudhir
 *         Date:3/12/16
 *         Time:3:01 PM
 *         Project:bpmn-service
 */
//@Component
 public class ActivitiRepositoryService implements BpmnRepositoryService {

    //@Autowired
    private RepositoryService repositoryService;

    public ActivitiRepositoryService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    public void deleteDeployment(String deploymentId) {
        repositoryService.deleteDeployment(deploymentId);
    }
}
