package it.engineering.web.WebApp.action.city;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.WebApp.action.AbstractAction;
import it.engineering.web.WebApp.constant.WebConstants;
import it.engineering.web.WebApp.service.impl.CityService;

public class DeleteCityGetAction extends AbstractAction {

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response){
		try {
			String zipCode = request.getParameter("zipCode");
			request.setAttribute("city", new CityService().read(zipCode));
			return WebConstants.PAGE_DELETE_CITY;
		} catch (Exception e) {
			return WebConstants.PAGE_VIEW_CITY;
		}
	}

}
