package com.crmps;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class CrmpsApplication { //extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CrmpsApplication.class, args);
	}
	
	@Bean(name = "jdbcMySql")
    @Autowired
    public JdbcTemplate mySqlJdbcTemplate() {
        return new JdbcTemplate(mySqlDataSource());
    }
	
	 @Bean(name = "dsMySql")
	    @ConfigurationProperties(prefix="spring.h2.datasource")
	    public DataSource mySqlDataSource() {
	        return DataSourceBuilder.create().build();
	    }
}
