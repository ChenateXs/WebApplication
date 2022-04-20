package it.engineering.web.WebApp.action.login;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.engineering.web.WebApp.action.AbstractAction;
import it.engineering.web.WebApp.constant.WebConstants;
import it.engineering.web.WebApp.domain.User;
import it.engineering.web.WebApp.storage.UserSpringStorage;
import it.engineering.web.WebApp.storage.UserStorage;

public class LoginAction extends AbstractAction{

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		User user;
		try {
			user = login(request);
			if(user != null) {
				HttpSession session = request.getSession(true);
				session.setAttribute("login_user", user.clone());
				return WebConstants.PAGE_LOGIN;
			} else {
				request.setAttribute("error_message", "User does not exist!!!");
				return WebConstants.PAGE_INDEX;
			}
		} catch (Exception e) {
			request.setAttribute("error_message", e.getMessage());
			return WebConstants.PAGE_INDEX;
		}
		

	}

	private User login(HttpServletRequest request) throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if(username.equals("") || password.equals("")) {
			throw new Exception("Username and password need to be felled!!!");
		}
		
		List<User> users = UserSpringStorage.getInstance(request).getUsers(); 
		@SuppressWarnings("unchecked")
		List<User> loggedInUsers = (List<User>)request.getServletContext().getAttribute("logged_in_users");
		
		
		for(User current: loggedInUsers) {
			if(current.getUsername().equals(username)) {
				throw new Exception("User already logged in!!!");
			}
		}
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		for(User current: users) {
			if(current.equals(user)) {
				loggedInUsers.add(current.clone());
				request.getServletContext().setAttribute("logged_in_users", loggedInUsers);
				return current;
			}
		}
		return null;
	}
	

}
