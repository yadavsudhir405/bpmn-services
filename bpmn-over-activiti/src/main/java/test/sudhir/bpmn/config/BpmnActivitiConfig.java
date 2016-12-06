package test.sudhir.bpmn.config;


import org.activiti.engine.*;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.context.annotation.Bean;
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
//@Configuration
public class BpmnActivitiConfig {

    //@Value("{$driverClass}")
    private String driverClass="org.postgresql.Driver";

    //@Value("{$url}")
    private String url="jdbc:postgresql://localhost:5432/muflow_test";

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
    public ProcessEngineConfiguration processEngineConfiguration(){
        SpringProcessEngineConfiguration springProcessEngineConfiguration
                =new SpringProcessEngineConfiguration();
        springProcessEngineConfiguration.setDataSource(simpleDataSource());
        springProcessEngineConfiguration.setTransactionManager(transactionManager());
        springProcessEngineConfiguration.setDatabaseSchemaUpdate("true");
        return springProcessEngineConfiguration;
    }

    @Bean
    public ProcessEngineFactoryBean processEngineFactoryBean(){
        ProcessEngineFactoryBean processEngineFactoryBean
                =new ProcessEngineFactoryBean();
        processEngineFactoryBean.setProcessEngineConfiguration((ProcessEngineConfigurationImpl) processEngineConfiguration());

        return processEngineFactoryBean;
    }

    @Bean
    public ProcessEngine processEngine(){
        ProcessEngine processEngine=null;
        try {
            processEngine= processEngineFactoryBean().getObject();
        } catch (Exception e) {
            System.out.println("PrcessEngine is null");
        }
        return processEngine;
    }
    @Bean
    public RepositoryService repositoryService(){
        return processEngine().getRepositoryService();
    }

    @Bean
    public RuntimeService runtimeService(){
        return processEngine().getRuntimeService();
    }

    @Bean
    public TaskService taskService(){
        return processEngine().getTaskService();
    }

    @Bean
    public  IdentityService identityService(){
        return processEngine().getIdentityService();
    }

    @Bean
    public HistoryService historyService(){
        return  processEngine().getHistoryService();
    }
}
