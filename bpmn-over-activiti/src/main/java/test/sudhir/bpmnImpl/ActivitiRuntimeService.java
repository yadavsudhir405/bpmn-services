package test.sudhir.bpmnImpl;

import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.sudhir.bpmn.interfaces.BpmnRuntimeService;

/**
 * @author sudhir
 *         Date:3/12/16
 *         Time:3:14 PM
 *         Project:bpmn-service
 */
@Component
class ActivitiRuntimeService implements BpmnRuntimeService {

    @Autowired
    private RuntimeService runtimeService;

    public void activateProcessInstanceById(String processInstanceId) {
        runtimeService.activateProcessInstanceById(processInstanceId);
    }
}
