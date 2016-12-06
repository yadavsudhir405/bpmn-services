package test.activiti.bpmnImpl;

import com.musigma.esp.bpmn.interfaces.BpmnRuntimeService;
import org.activiti.engine.RuntimeService;

import java.util.Map;

/**
 * @author sudhir
 *         Date:3/12/16
 *         Time:3:14 PM
 *         Project:bpmn-service
 */
//@Component
public class ActivitiRuntimeService implements BpmnRuntimeService {

    //@Autowired
    private RuntimeService runtimeService;

    public ActivitiRuntimeService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    public void activateProcessInstanceById(String processInstanceId) {
        runtimeService.activateProcessInstanceById(processInstanceId);
    }

    @Override
    public String startProcessInstanceByKey(String processDefinationId, Map<String, Object> variables) {

        return runtimeService.startProcessInstanceByKey(processDefinationId,variables).getId();

    }
}
