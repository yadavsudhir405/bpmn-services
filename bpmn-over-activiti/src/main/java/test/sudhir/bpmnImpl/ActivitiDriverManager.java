package test.sudhir.bpmnImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.sudhir.bpmn.interfaces.BpmnDeploymentService;
import test.sudhir.bpmn.interfaces.BpmnDriverManager;
import test.sudhir.bpmn.interfaces.BpmnRepositoryService;
import test.sudhir.bpmn.interfaces.BpmnRuntimeService;

/**
 * @author sudhir
 *         Date:3/12/16
 *         Time:2:57 PM
 *         Project:bpmn-service
 */
@Component(value = "bpmnDriverManager")
public class ActivitiDriverManager implements BpmnDriverManager{

    @Autowired
    private BpmnDeploymentService bpmnDeploymentService;

    @Autowired
    private BpmnRuntimeService bpmnRuntimeService;

    @Autowired
    private BpmnRepositoryService bpmnRepositoryService;

    public BpmnDeploymentService getBpmnDeploymentService() {
        return  bpmnDeploymentService;
    }

    public BpmnRuntimeService getBpmnRuntimeService() {
        return bpmnRuntimeService;
    }

    public BpmnRepositoryService getBpmnRepositoryService() {
        return bpmnRepositoryService;
    }
}
