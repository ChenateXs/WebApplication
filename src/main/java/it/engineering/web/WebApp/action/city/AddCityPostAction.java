package it.engineering.web.WebApp.action.city;

import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.WebApp.action.AbstractAction;
import it.engineering.web.WebApp.constant.WebConstants;
import it.engineering.web.WebApp.entity.City;
import it.engineering.web.WebApp.repository.impl.CityRepository;

public class AddCityPostAction extends AbstractAction {

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		try {
			String zipCode = request.getParameter("zip_code");
			String name = request.getParameter("name");
			
			if(zipCode.equals("") || name.equals(""))
				throw new Exception("All fields are required to be filled!!!");
			
			City city = new City(zipCode,name);
			CityRepository cityRepository = new CityRepository();
		
			cityRepository.create(city);
			request.setAttribute("message", "A city has been created.");
			return WebConstants.PAGE_LOGIN;
		} catch (Exception e) {
			request.setAttribute("error_message", e.getMessage());
			return WebConstants.PAGE_ADD_CITY;
		}
		
	}
}
