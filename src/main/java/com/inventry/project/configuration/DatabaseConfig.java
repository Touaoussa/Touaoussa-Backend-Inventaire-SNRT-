package com.inventry.project.configuration;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DatabaseConfig {
	
	/*@Bean("datasource1")
	@Primary
	@ConfigurationProperties(prefix="app.datasource")
	public DataSource dataSource() {
	    return DataSourceBuilder.create().build();
	}

	@Bean("datasource2")
	@ConfigurationProperties(prefix="app.datasource2")
	public DataSource dataSource2() {
	    return DataSourceBuilder.create().build();
	}
*/
}
