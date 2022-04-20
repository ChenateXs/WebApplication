package it.engineering.web.WebApp.action.city;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.WebApp.action.AbstractAction;
import it.engineering.web.WebApp.constant.WebConstants;
import it.engineering.web.WebApp.service.impl.CityService;

public class ViewCityAction extends AbstractAction{

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("cities", new CityService().getAll());
		return WebConstants.PAGE_VIEW_CITY;
	}

}
