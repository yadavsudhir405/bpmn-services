package test.sudhir.bpmnImpl;

import test.sudhir.BpmnGroup;
import test.sudhir.BpmnIdentityService;
import test.sudhir.BpmnUser;
import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sudhir
 *         Date:4/12/16
 *         Time:6:01 PM
 *         Project:bpmn-service
 */
@Component
public class ActivityBpmnIdentityService implements BpmnIdentityService {

    @Autowired
    private IdentityService identityService;


    @Override
    public void createMemberShip(String s1, String s2) {
        identityService.createMembership(s1,s2);
    }

    @Override
    public BpmnUser newUser(String user) {
        User activitiUser=identityService.newUser(user);
        return new ActivitiBpmnUser(activitiUser);

    }

    @Override
    public BpmnGroup newGroup(String group) {
        return new ActivitiBpmnGroup(identityService.newGroup(group));
    }

    @Override
    public void saveUser(BpmnUser bpmnUser) {

        //BpmnUserOverActivitiUser bpmnUserOverActivitiUser=new BpmnUserOverActivitiUser(bpmnUser);
        identityService.saveUser(((ActivitiBpmnUser)bpmnUser).getUser());
    }

    @Override
    public void saveGroup(BpmnGroup bpmnGroup) {
        //ActivitiGroupOverBpmnGroup activitiGroupOverBpmnGroup=new ActivitiGroupOverBpmnGroup(bpmnGroup);
        identityService.saveGroup(((ActivitiBpmnGroup)bpmnGroup).getGroup());
    }
}
