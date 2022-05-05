package it.engineering.web.WebApp.context;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.engineering.web.WebApp.config.MyAppConfiguration;
import it.engineering.web.WebApp.entity.UserEntity;

@WebListener("Configuration")
public class StartupContext implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		List<UserEntity> users = new ArrayList<UserEntity>();

		sce.getServletContext().setAttribute("logged_in_users", users);
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyAppConfiguration.class);
    	sce.getServletContext().setAttribute("application-context", applicationContext);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}
	
}