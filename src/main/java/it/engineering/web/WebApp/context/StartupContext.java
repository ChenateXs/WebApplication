package it.engineering.web.WebApp.context;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.engineering.web.WebApp.config.ApplicationConfiguration;
import it.engineering.web.WebApp.entity.User;

@WebListener("Configuration")
public class StartupContext implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		List<User> users = new ArrayList<User>();

		sce.getServletContext().setAttribute("logged_in_users", users);
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
    	sce.getServletContext().setAttribute("application-context", applicationContext);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}
	
}