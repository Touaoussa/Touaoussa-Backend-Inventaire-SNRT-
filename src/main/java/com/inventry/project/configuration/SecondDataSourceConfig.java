package com.inventry.project.configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "db2EntityMgrFactory",
        transactionManagerRef = "db2TransactionMgr",
        basePackages = {
                "com.inventry.project.datasource2.repo"
        })
@EnableTransactionManagement
public class SecondDataSourceConfig {

	
	 @Bean(name = "datasource2")
	    @ConfigurationProperties(prefix = "spring.db2.datasource")
	  @Primary  
	 // setting up the data source for the beer database.
	    public DataSource dataSource() {
	        return DataSourceBuilder.create().build();
	    }
	 
	 @Bean(name = "db2EntityMgrFactory")
	 @Primary
	    public LocalContainerEntityManagerFactoryBean db1EntityMgrFactory(
	            final EntityManagerFactoryBuilder builder,
	            @Qualifier("datasource2") final DataSource dataSource) {
	        // dynamically setting up the hibernate properties for each of the datasource.
	        final Map<String, String> properties = new HashMap<>();
	        properties.put("spring.jpa.hibernate.ddl-auto", "create-update");
	        // in springboot2 the dialect can be automatically detected.
	        // we are setting up here just to avoid any incident.
	        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	        return 	builder
	        		.dataSource(dataSource)
	                .properties(properties)
	                .packages("com.inventry.project.model")
	               // .persistenceUnit("Supportacquistion","Site")
	                .build();
	    }
	 
	 	@Bean(name = "db2TransactionMgr")
	    @Primary
	    public PlatformTransactionManager db1TransactionMgr(
	            @Qualifier("db2EntityMgrFactory") final EntityManagerFactory entityManagerFactory) {
	        return new JpaTransactionManager(entityManagerFactory);
	    }
	 
	 	@Bean
	    public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	        sessionFactory.setDataSource(dataSource());
	        sessionFactory.setPackagesToScan(
	          "com.inventry.project.model") ;
	        sessionFactory.setHibernateProperties(hibernateProperties());
	        return sessionFactory;
	    }
	 	
	 	private final Properties hibernateProperties() {
	        Properties hibernateProperties = new Properties();
	        hibernateProperties.setProperty(
	          "spring.jpa.hibernate.ddl-auto", "create-update");
	        hibernateProperties.setProperty(
	          "hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

	        return hibernateProperties;
	    }
}
