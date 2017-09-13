package trng.imcs.spring.hibernate.configuration;


import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import trng.imcs.spring.hibernate.util.HibernateUtils;

@Configuration
@ComponentScan(basePackages = "trng.imcs")
public class ApplicationConfig {
	
	@Bean
	public SessionFactory getSessionFactory() {
		return HibernateUtils.getSessionFactory();
	}


}