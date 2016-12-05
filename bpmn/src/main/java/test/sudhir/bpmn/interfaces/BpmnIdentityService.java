package test.sudhir.bpmn.interfaces;

/**
 * @author sudhir
 *         Date:4/12/16
 *         Time:5:25 PM
 *         Project:bpmn-service
 */
public interface BpmnIdentityService {

    public void createMemberShip(String s1,String s2);

    public BpmnUser newUser(String user);

    public BpmnGroup newGroup(String group);

    public void saveUser(BpmnUser  bpmnUser);

    public void saveGroup(BpmnGroup bpmnGroup);
}
