package it.engineering.web.WebApp.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class MyDatabaseJpaConfiguration {

	@Bean
	public DataSource dataSource() {
		System.out.println("=============== dataSource: ApplicationConfiguration =======================");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/eng_2022_spring_g1");
		dataSource.setUsername("admin");
		dataSource.setPassword("admin");
		return dataSource;
	}
	
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		
		LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
		emfb.setDataSource(dataSource);
		
		emfb.setPackagesToScan(new String[] {"it.engineering.web.WebApp.entity"});
		
		//obezbediti odgovaraju implementaciju
		JpaVendorAdapter hibernate = new HibernateJpaVendorAdapter();
		emfb.setJpaVendorAdapter(hibernate);
		return emfb;
	}
	
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(emf);
		return jpaTransactionManager;
	}
	
}
