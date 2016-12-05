package test.sudhir.bpmnImpl;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.sudhir.bpmn.interfaces.BpmnTaskService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author sudhir
 *         Date:5/12/16
 *         Time:2:15 PM
 *         Project:bpmn-service
 */
@Component
public class ActivitiTaskService implements BpmnTaskService {

    @Autowired
    private TaskService taskService;

    @Override
    public void complete(String taskId, Map<String, Object> variables) {
        taskService.complete(taskId,variables);
    }

    @Override
    public Object getVariable(String taskId, String varibleName) {
        return taskService.getVariable(taskId,varibleName);
    }

    @Override
    public List<String> getTasksGroupWise(String groupName) {
        TaskQuery taskQuery=taskService.createTaskQuery();
        return taskQuery.taskCandidateGroup(groupName).list().parallelStream().map(task -> task.getId()).collect(Collectors
                .toList());
    }
}
