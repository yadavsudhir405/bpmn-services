package test.activiti.bpmnImpl;

import com.musigma.esp.bpmn.interfaces.*;

/**
 * @author sudhir
 *         Date:3/12/16
 *         Time:2:57 PM
 *         Project:bpmn-service
 */
//@Configuration
//@AutoConfigureAfter(name = {})
public class ActivitiDriverManager implements BpmnDriverManager {

    //@Autowired
    private BpmnDeploymentService bpmnDeploymentService;

    //@Autowired
    private BpmnRuntimeService bpmnRuntimeService;

    //@Autowired
    private BpmnRepositoryService bpmnRepositoryService;

    //@Autowired
    private BpmnIdentityService bpmnIdentityService;

    public ActivitiDriverManager(BpmnDeploymentService bpmnDeploymentService, BpmnRuntimeService bpmnRuntimeService, BpmnRepositoryService bpmnRepositoryService, BpmnIdentityService bpmnIdentityService) {
        this.bpmnDeploymentService = bpmnDeploymentService;
        this.bpmnRuntimeService = bpmnRuntimeService;
        this.bpmnRepositoryService = bpmnRepositoryService;
        this.bpmnIdentityService = bpmnIdentityService;
    }

    public BpmnDeploymentService getBpmnDeploymentService() {
        return  bpmnDeploymentService;
    }

    public BpmnRuntimeService getBpmnRuntimeService() {
        return bpmnRuntimeService;
    }

    public BpmnRepositoryService getBpmnRepositoryService() {
        return bpmnRepositoryService;
    }

    @Override
    public BpmnIdentityService getBpmnIdentityService() {
        return bpmnIdentityService;
    }

}
