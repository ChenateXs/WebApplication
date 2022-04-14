package it.engineering.web.WebApp.action.login;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.engineering.web.WebApp.action.AbstractAction;
import it.engineering.web.WebApp.action.domain.User;
import it.engineering.web.WebApp.constant.WebConstants;
import it.engineering.web.WebApp.storage.UserStorage;

public class LoginAction extends AbstractAction{

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		User user = login(request);
		System.out.println(user);
		if(user != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("login_user", user.clone());
			return WebConstants.PAGE_LOGIN;
		} else {
			request.setAttribute("error_message", "User does not exist!!!");
			return WebConstants.PAGE_INDEX;
		}

	}

	private User login(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		List<User> users = UserStorage.getInstance().getUsers(); 
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		for(User current: users) {
			if(current.equals(user)) {
				return current;
			}
		}
		return null;
	}
	

}
