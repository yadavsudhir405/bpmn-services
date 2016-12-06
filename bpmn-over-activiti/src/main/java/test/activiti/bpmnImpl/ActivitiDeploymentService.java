package test.activiti.bpmnImpl;

import com.musigma.esp.bpmn.interfaces.BpmnDeploymentService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;

import java.io.InputStream;

/**
 * @author sudhir
 *         Date:3/12/16
 *         Time:3:16 PM
 *         Project:bpmn-service
 */

public class ActivitiDeploymentService implements BpmnDeploymentService {

    private RepositoryService repositoryService;

    public ActivitiDeploymentService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    public void deploy(String processDefination) {
        System.out.println("Deploying ProcessDefination "+processDefination);
    }

    @Override
    public String deploy(String resourceName, String resourcePath) {
       return repositoryService.createDeployment().addClasspathResource("upload.bpmn20.xml").deploy().getId();

        /*try(InputStream inputStream1=new FileInputStream(resourcePath)){
            return deploy(resourceName,inputStream1);
        }catch (FileNotFoundException e){
            e.printStackTrace();
            throw new RuntimeException("Bpmn File Not Found");
        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }*/
    }
    private String deploy(String resourceName,InputStream inputStream){
        DeploymentBuilder deploymentBuilder=repositoryService.createDeployment();
        deploymentBuilder.addInputStream(resourceName,inputStream);
        Deployment deployment=deploymentBuilder.deploy();
        return deployment.getId();
    }
}
