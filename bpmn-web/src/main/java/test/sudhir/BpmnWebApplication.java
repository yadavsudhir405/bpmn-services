package test.sudhir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import test.sudhir.bpmn.interfaces.BpmnDriverManager;

@SpringBootApplication(scanBasePackages = "test.sudhir.bpmn.config,test.sudhir.bpmnImpl")
public class BpmnWebApplication {



	public static void main(String[] args) {
		ApplicationContext applicationContext=SpringApplication.run(BpmnWebApplication.class, args);
        BpmnDriverManager bpmnDriverManager=applicationContext.getBean("bpmnDriverManager",BpmnDriverManager.class);
        System.out.println("Process Engine Started");

	}
}
