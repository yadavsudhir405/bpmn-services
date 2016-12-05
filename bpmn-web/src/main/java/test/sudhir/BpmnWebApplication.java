package test.sudhir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import test.sudhir.bpmn.interfaces.BpmnDriverManager;

@SpringBootApplication(scanBasePackages = "test.sudhir.bpmn.config,test.sudhir.bpmnImpl,test.sudhir.config,test" +
        ".sudhir.*")
public class BpmnWebApplication {



	public static void main(String[] args) {
		ApplicationContext applicationContext=SpringApplication.run(BpmnWebApplication.class, args);
        BpmnDriverManager bpmnDriverManager=applicationContext.getBean("bpmnDriverManager",BpmnDriverManager.class);
        System.out.println("Process Engine Started");
		String processDefinationpath="/home/sudhir/yadavsudhir405/activiti-spring-boot-webinar/activiti-spring-boot" +
				"-webinar/target/classes/processes/Demo1JavaTask.bpmn20.xml";
		String processname="Demo1JavaTask";
		String deploymentId=bpmnDriverManager.getBpmnDeploymentService().deploy(processname,processDefinationpath);
		System.out.println("Deployemt Id= "+deploymentId);
	}
}
