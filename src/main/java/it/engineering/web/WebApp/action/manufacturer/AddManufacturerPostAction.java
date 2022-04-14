package it.engineering.web.WebApp.action.manufacturer;

import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.WebApp.action.AbstractAction;
import it.engineering.web.WebApp.constant.WebConstants;
import it.engineering.web.WebApp.domain.City;
import it.engineering.web.WebApp.domain.Manufacturer;
import it.engineering.web.WebApp.repository.CityRepository;
import it.engineering.web.WebApp.repository.ManufacturerRepository;

public class AddManufacturerPostAction extends AbstractAction{

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			String manufactortrId = request.getParameter("manufactortr_id");
			String taxId = request.getParameter("tax_id");
			String address = request.getParameter("address");
			City city = new CityRepository().read(new BigInteger(request.getParameter("city")));
			
			Manufacturer manufacturer = 
					new Manufacturer(
							new BigInteger(manufactortrId),
							new BigInteger(taxId),
							address,
							city);
							
			ManufacturerRepository manufacturerRepository = new ManufacturerRepository();
			
			manufacturerRepository.create(manufacturer);
			request.setAttribute("message", "A manufacturer has been created.");
			return WebConstants.PAGE_LOGIN;
		} catch (Exception e) {
			request.setAttribute("error_message", e.getMessage());
			return WebConstants.PAGE_ADD_MANUFACTURER;
		}
	}

}
