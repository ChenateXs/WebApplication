package it.engineering.web.WebApp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.WebApp.action.AbstractAction;
import it.engineering.web.WebApp.action.factory.ActionFactory;

public class ApplicationController {

	public String processRequest(HttpServletRequest request, HttpServletResponse response) {
		
		AbstractAction action = ActionFactory.createAction(request.getMethod(),request.getPathInfo());
		
		String page = action.executeRequest(request, response);
		return page;
	}
}
