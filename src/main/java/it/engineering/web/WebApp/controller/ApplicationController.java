package it.engineering.web.WebApp.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.engineering.web.WebApp.action.AbstractAction;
import it.engineering.web.WebApp.action.factory.ActionFactory;
import it.engineering.web.WebApp.constant.WebConstants;
import it.engineering.web.WebApp.domain.User;

public class ApplicationController {

	public String processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		String path = request.getPathInfo();
		String method = request.getMethod();
		User user = (User)session.getAttribute("login_user");
		if(path.equals(WebConstants.PATH_LOGIN) || user != null) {
			AbstractAction action = ActionFactory.createAction(method,path);
		
			String page = action.executeRequest(request, response);
			return page;
		}	else {
			throw new IOException("Rectricted path!!!");
		}
	}
}
