package test.sudhir.bpmnImpl;

import test.sudhir.BpmnGroup;
import org.activiti.engine.identity.Group;

/**
 * @author sudhir
 *         Date:5/12/16
 *         Time:11:15 AM
 *         Project:bpmn-service
 */
public class ActivitiBpmnGroup implements BpmnGroup {

    private Group group;

    public ActivitiBpmnGroup(Group group) {
        this.group = group;
    }

    @Override
    public String getId() {
        return group.getId();
    }

    @Override
    public void setId(String var1) {
        group.setId(var1);
    }

    @Override
    public String getName() {
        return group.getName();
    }

    @Override
    public void setName(String var1) {
        group.setName(var1);
    }

    @Override
    public String getType() {
        return group.getType();
    }

    @Override
    public void setType(String var1) {
        group.setType(var1);
    }
    Group getGroup(){
        return group;
    }
}
