package it.engineering.web.WebApp.action.city;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.WebApp.action.AbstractAction;
import it.engineering.web.WebApp.constant.WebConstants;

public class UpdateCityGetAction extends AbstractAction{

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("zipCode", request.getParameter("zipCode")); 
		request.setAttribute("name", request.getParameter("name")); 
		
		return 	WebConstants.PAGE_UPDATE_CITY;
	}

}
