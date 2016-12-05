package test.sudhir.bpmnImpl;

import org.activiti.engine.identity.User;
import test.sudhir.bpmn.interfaces.BpmnUser;

/**
 * @author sudhir
 *         Date:5/12/16
 *         Time:11:10 AM
 *         Project:bpmn-service
 */
public class ActivitiBpmnUser implements BpmnUser {

    private User user;

    public ActivitiBpmnUser(User user){
        this.user=user;
    }
    @Override
    public String getId() {
        return user.getId();
    }

    @Override
    public void setId(String s) {
        user.setId(s);
    }

    @Override
    public String getFirstName() {
        return user.getFirstName();
    }

    @Override
    public void setFirstName(String s) {
        user.setFirstName(s);
    }

    @Override
    public void setLastName(String s) {
        user.setLastName(s);
    }

    @Override
    public String getLastName() {
        return user.getLastName();
    }

    @Override
    public void setEmail(String s) {
        user.setEmail(s);
    }

    @Override
    public String getEmail() {
        return user.getEmail();
    }

    @Override
    public String getPassword() {
        return user.getEmail();
    }

    @Override
    public void setPassword(String s) {
        user.setPassword(s);
    }

    @Override
    public boolean isPictureSet() {
        return user.isPictureSet();
    }

    User getUser(){
        return user;
    }
}
