package it.engineering.web.WebApp.context;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import it.engineering.web.WebApp.action.domain.User;

@WebListener("Configuration")
public class StartupContext implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		List<User> users = new ArrayList<User>();

		sce.getServletContext().setAttribute("logged_in_users", users);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}
	
}