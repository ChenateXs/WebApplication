package it.engineering.web.WebApp.action.city;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.WebApp.action.AbstractAction;
import it.engineering.web.WebApp.constant.WebConstants;
import it.engineering.web.WebApp.domain.City;
import it.engineering.web.WebApp.service.CityService;

public class UpdateCityPostAction extends AbstractAction {
	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		String zipCode = request.getParameter("zipCode");
		String name = request.getParameter("name");
		String confirm = request.getParameter("confirm");
		
		try {
			if (confirm.equals("Confirm")) {
				new CityService().update(zipCode, new City(zipCode,name));

				request.setAttribute("message", "City has succesfully been updated.");
				request.setAttribute("cities", new CityService().getAll());
				return WebConstants.PAGE_VIEW_CITY;
			} else {
				request.setAttribute("message", "Cancelled.");
				request.setAttribute("cities", new CityService().getAll());
				return WebConstants.PAGE_VIEW_CITY;
			}
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			request.setAttribute("cities", new CityService().getAll());
			return WebConstants.PAGE_VIEW_CITY;
		}
	}

}
