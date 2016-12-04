package test.sudhir.bpmn.interfaces;

/**
 * @author sudhir
 *         Date:3/12/16
 *         Time:2:33 PM
 *         Project:bpmn
 */
public interface BpmnDriverManager {

    public BpmnDeploymentService getBpmnDeploymentService();

    public BpmnRuntimeService getBpmnRuntimeService();

    public BpmnRepositoryService getBpmnRepositoryService();
}
