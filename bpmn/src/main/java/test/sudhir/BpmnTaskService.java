package test.sudhir;

import java.util.List;
import java.util.Map;

/**
 * @author sudhir
 *         Date:5/12/16
 *         Time:1:36 PM
 *         Project:bpmn-service
 */
public interface BpmnTaskService {

    void complete(String taskId, Map<String,Object> variables);

    Object getVariable(String taskId,String varibleName);

    List<String> getTasksGroupWise(String groupName);

}
