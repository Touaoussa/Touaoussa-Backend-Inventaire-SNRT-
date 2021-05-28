package com.inventry.project.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

public class DatabaseTransactionConfig {

	@Bean(name="tm1")
	@Autowired
	@Primary
	DataSourceTransactionManager tm1(@Qualifier ("datasource1") DataSource datasource) {
	    DataSourceTransactionManager txm  = new DataSourceTransactionManager(datasource);
	    return txm;
	}

	@Bean(name="tm2")
	@Autowired
	DataSourceTransactionManager tm2(@Qualifier ("datasource2") DataSource datasource) {
	    DataSourceTransactionManager txm  = new DataSourceTransactionManager(datasource);
	    return txm;
	}
	
}
