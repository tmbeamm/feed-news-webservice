package com.example.configuration;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
public class AppConfiguration {

	@Bean
	public DataSource dataSource() throws NamingException {

	  EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//	  return (DataSource) new JndiTemplate().lookup(env.getProperty("jdbc.url"));
	  return builder.setType(EmbeddedDatabaseType.HSQL).build();
	}
	@Bean
	public EntityManagerFactory entityManagerFactory() throws NamingException {

	   HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	   vendorAdapter.setGenerateDdl(true);

	   LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	   factory.setJpaVendorAdapter(vendorAdapter);
	   factory.setPackagesToScan("com.example");
	   factory.setDataSource(dataSource());
	   factory.afterPropertiesSet();

	   return factory.getObject();
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() throws NamingException {

	   JpaTransactionManager txManager = new JpaTransactionManager();
	   txManager.setEntityManagerFactory(entityManagerFactory());
	   return txManager;
	}
}
