package test.sudhir.bpmn.config;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Driver;

/**
 * @author sudhir
 *         Date:3/12/16
 *         Time:3:22 PM
 *         Project:bpmn-service
 */
@Configuration
public class BpmnActivitiConfig {

    //@Value("{$driverClass}")
    private String driverClass="org.postgresql.Driver";

    //@Value("{$url}")
    private String url="jdbc:postgresql://localhost:5432/muflow";

    //@Value("{$username}")
    private String username="postgres";

    //@Value("${password}")
    private String password="postgres";

    @Bean()
    public DataSource simpleDataSource(){
        SimpleDriverDataSource simpleDriverDataSource=new SimpleDriverDataSource();
        System.out.println("Loading Sql Driver "+driverClass);
        Class<? extends Driver> sqlDriverClass;
        try {
            sqlDriverClass=(Class<? extends Driver>) Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver not Found "+driverClass);
        }
        simpleDriverDataSource.setDriverClass(sqlDriverClass);
        simpleDriverDataSource.setUrl(url);
        simpleDriverDataSource.setUsername(username);
        simpleDriverDataSource.setPassword(password);
        return  simpleDriverDataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager(){
        return new DataSourceTransactionManager(simpleDataSource());
    }

    @Bean
    public SpringProcessEngineConfiguration springProcessEngineConfiguration(){
        SpringProcessEngineConfiguration springProcessEngineConfiguration
                =new SpringProcessEngineConfiguration();
        springProcessEngineConfiguration.setDataSource(simpleDataSource());
        //springProcessEngineConfiguration.setTransactionManager(transactionManager());
        springProcessEngineConfiguration.setDatabaseSchemaUpdate(Boolean.toString(true));
        return springProcessEngineConfiguration;
    }

    @Bean
    public ProcessEngineFactoryBean processEngine(){
        ProcessEngineFactoryBean processEngineFactoryBean
                =new ProcessEngineFactoryBean();
        processEngineFactoryBean.setProcessEngineConfiguration(springProcessEngineConfiguration());
        return   processEngineFactoryBean;
    }

    @Bean
    public RepositoryService repositoryService(){
        return processEngine().getProcessEngineConfiguration().getRepositoryService();
    }

    @Bean
    public RuntimeService runtimeService(){
        return processEngine().getProcessEngineConfiguration().getRuntimeService();
    }

    @Bean
    public TaskService taskService(){
        return processEngine().getProcessEngineConfiguration().getTaskService();
    }

    @Bean
    public HistoryService historyService(){
        return  processEngine().getProcessEngineConfiguration().getHistoryService();
    }
}
