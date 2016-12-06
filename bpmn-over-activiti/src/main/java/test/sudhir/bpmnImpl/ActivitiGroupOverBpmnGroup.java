package test.sudhir.bpmnImpl;

import org.activiti.engine.identity.Group;
import test.sudhir.BpmnGroup;

/**
 * @author sudhir
 *         Date:5/12/16
 *         Time:11:31 AM
 *         Project:bpmn-service
 */
class ActivitiGroupOverBpmnGroup implements Group {


    private BpmnGroup bpmnGroup;

    public ActivitiGroupOverBpmnGroup(BpmnGroup bpmnGroup) {
        this.bpmnGroup = bpmnGroup;
    }

    @Override
    public String getId() {
        return bpmnGroup.getId();
    }

    @Override
    public void setId(String s) {
        bpmnGroup.setId(s);
    }

    @Override
    public String getName() {
        return bpmnGroup.getName();
    }

    @Override
    public void setName(String s) {
        bpmnGroup.setName(s);
    }

    @Override
    public String getType() {
        return bpmnGroup.getType();
    }

    @Override
    public void setType(String s) {
        bpmnGroup.setName(s);
    }
}
