package it.engineering.web.WebApp.action.manufacturer;

import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.WebApp.action.AbstractAction;
import it.engineering.web.WebApp.constant.WebConstants;
import it.engineering.web.WebApp.dto.CityDto;
import it.engineering.web.WebApp.dto.ManufacturerDto;
import it.engineering.web.WebApp.repository.impl.CityRepository;
import it.engineering.web.WebApp.service.impl.CityService;
import it.engineering.web.WebApp.service.impl.ManufacturerService;

public class AddManufacturerPostAction extends AbstractAction{

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			String manufactortrId = request.getParameter("manufactortr_id");
			String taxId = request.getParameter("tax_id");
			String address = request.getParameter("address");
			CityDto city = new CityService().read(request.getParameter("city"));
			
			if(manufactortrId.equals("") || taxId.equals("") || address.equals(""))
				throw new Exception("All fields are required to be filled!!!");
			
			ManufacturerDto manufacturer = new ManufacturerDto(manufactortrId,taxId,address,city);
							
			new ManufacturerService().create(manufacturer);
			
			request.setAttribute("message", "A manufacturer has been created.");
			return WebConstants.PAGE_LOGIN;
		} catch (Exception e) {
			request.setAttribute("error_message", e.getMessage());
			request.setAttribute("cities", new CityRepository().getAll());
			return WebConstants.PAGE_ADD_MANUFACTURER;
		}
	}

}
