package test.sudhir.bpmnImpl;

import test.sudhir.BpmnRuntimeService;
import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

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

    @Override
    public String startProcessInstanceByKey(String processDefinationId, Map<String, Object> variables) {

        return runtimeService.startProcessInstanceByKey(processDefinationId,variables).getId();

    }
}
