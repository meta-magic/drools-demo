package com.driot;

import java.util.Properties;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JDOConfiguration {

	@Bean
	public PersistenceManagerFactory getPersistenceManagerFactory() {
		String user = "postgres";
		String password = "postgres";
		Properties prop = new Properties();
		prop.setProperty("datanucleus.ConnectionURL","jdbc:postgresql:postgres");
		prop.setProperty("javax.jdo.option.ConnectionDriverName","org.postgresql.Driver");
		prop.setProperty("javax.jdo.option.ConnectionUserName",user);
		prop.setProperty("javax.jdo.option.ConnectionPassword",password);
		prop.setProperty("javax.jdo.option.Mapping","postgres");
		prop.setProperty("datanucleus.schema.autoCreateAll", "true");
		prop.setProperty("datanucleus.schema.validateConstraints", "false");
		prop.setProperty("datanucleus.schema.validateTables", "false");
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory(prop);
		return pmf;
	}

}
