package test.sudhir.bpmn.interfaces;

/**
 * @author sudhir
 *         Date:3/12/16
 *         Time:2:35 PM
 *         Project:bpmn
 */
public interface BpmnDeploymentService {

    void deploy(String processDefination);

    public String deploy(String resourceName,String resourcePath);
}
