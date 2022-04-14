package it.engineering.web.WebApp.action.city;

import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.WebApp.action.AbstractAction;
import it.engineering.web.WebApp.constant.WebConstants;
import it.engineering.web.WebApp.domain.City;
import it.engineering.web.WebApp.repository.CityRepository;

public class AddCityPostAction extends AbstractAction {

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		City city = new City(new BigInteger(request.getParameter("zip_code")),request.getParameter("name"));
		CityRepository cityRepository = new CityRepository();
		try {
			cityRepository.create(city);
			request.setAttribute("message", "A city has been created.");
			return WebConstants.PAGE_LOGIN;
		} catch (Exception e) {
			request.setAttribute("error_message", e.getMessage());
			return WebConstants.PAGE_ADD_CITY;
		}
		
	}
}
