package it.engineering.web.WebApp.action.logout;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.engineering.web.WebApp.action.AbstractAction;
import it.engineering.web.WebApp.constant.WebConstants;
import it.engineering.web.WebApp.dto.UserDto;

public class LogoutAction extends AbstractAction{

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String username = ((UserDto)session.getAttribute("login_user")).getUsername();
		
		@SuppressWarnings("unchecked")
		List<UserDto> loggedInUsers= (List<UserDto>)request.getServletContext().getAttribute("logged_in_users");
		
		for(UserDto current: loggedInUsers) {
			if(current.getUsername().equals(username)) {
				loggedInUsers.remove(current);
				break;
			}
		}
		
		session.removeAttribute("login_user");
		session.invalidate();
		session = request.getSession(false);
		return WebConstants.PAGE_LOGOUT;
	}

}
