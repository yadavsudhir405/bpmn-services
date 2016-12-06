package test.activiti.bpmnImpl;

import com.musigma.esp.bpmn.interfaces.BpmnUser;
import org.activiti.engine.identity.User;

/**
 * @author sudhir
 *         Date:5/12/16
 *         Time:11:24 AM
 *         Project:bpmn-service
 */
class BpmnUserOverActivitiUser implements User {

    private BpmnUser bpmnUser;

    public BpmnUserOverActivitiUser(BpmnUser activitiBpmnUser) {
        this.bpmnUser = activitiBpmnUser;
    }

    @Override
    public String getId() {
        return bpmnUser.getId();
    }

    @Override
    public void setId(String s) {
        bpmnUser.setId(s);
    }

    @Override
    public String getFirstName() {
        return bpmnUser.getFirstName();
    }

    @Override
    public void setFirstName(String s) {
        bpmnUser.setFirstName(s);
    }

    @Override
    public void setLastName(String s) {
        bpmnUser.setLastName(s);
    }

    @Override
    public String getLastName() {
        return bpmnUser.getLastName();
    }

    @Override
    public void setEmail(String s) {
        bpmnUser.setEmail(s);
    }

    @Override
    public String getEmail() {
        return bpmnUser.getEmail();
    }

    @Override
    public String getPassword() {
        return bpmnUser.getPassword();
    }

    @Override
    public void setPassword(String s) {
        bpmnUser.setPassword(s);
    }

    @Override
    public boolean isPictureSet() {
        return bpmnUser.isPictureSet();
    }
}
