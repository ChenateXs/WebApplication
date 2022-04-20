package it.engineering.web.WebApp.storage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;

import it.engineering.web.WebApp.domain.User;
import it.engineering.web.WebApp.service.IcrudService;

public class UserSpringStorage{
	private List<User> users;
	private static UserSpringStorage instance;
	
	@Autowired
	@Qualifier(value = "userSpringService")
	private IcrudService icrudService;
	
	public UserSpringStorage(HttpServletRequest request){
		
		ApplicationContext applicationContext = 
				(ApplicationContext) request.getServletContext().getAttribute("application-context");
		
		AutowireCapableBeanFactory acbf = applicationContext.getAutowireCapableBeanFactory();
		acbf.autowireBean(this);
		
		users = icrudService.getAll();
	}
	
	public static UserSpringStorage getInstance(HttpServletRequest request) {
		if(instance == null) instance = new UserSpringStorage(request);
		return instance;
	}
	
	public void add(User user) {
		users.add(user);
	}
	
	public List<User> getUsers() {
		return users;
	}
}
