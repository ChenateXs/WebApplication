package it.engineering.web.WebApp.action.manufacturer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.WebApp.action.AbstractAction;
import it.engineering.web.WebApp.constant.WebConstants;
import it.engineering.web.WebApp.dto.CityDto;
import it.engineering.web.WebApp.dto.ManufacturerDto;
import it.engineering.web.WebApp.service.impl.CityService;
import it.engineering.web.WebApp.service.impl.ManufacturerService;

public class UpdateManufacturerPostAction extends AbstractAction {

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		try {
			Long id = Long.parseLong(request.getParameter("id"));
			String manufacturtrId = request.getParameter("manufacturerId");
			String taxId = request.getParameter("taxId");
			String address = request.getParameter("address");
			CityDto city = new CityService().read(request.getParameter("city"));
			String confirm = request.getParameter("confirm");
			
			if(manufacturtrId.equals("") || taxId.equals("") || address.equals(""))
				throw new Exception("All fields are required to be filled!!!");
			
			if (confirm.equals("Confirm")) {
				new ManufacturerService().update(id, new ManufacturerDto(id,manufacturtrId,taxId,address,city));

				request.setAttribute("message", "Manufacturer has succesfully been updated.");
				request.setAttribute("manufacturers", new ManufacturerService().getAll());
				return WebConstants.PAGE_VIEW_MANUFACTURER;
			} else {
				request.setAttribute("message", "Cancelled.");
				request.setAttribute("manufacturers", new ManufacturerService().getAll());
				return WebConstants.PAGE_VIEW_MANUFACTURER;
			}
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			request.setAttribute("manufacturers", new ManufacturerService().getAll());
			return WebConstants.PAGE_VIEW_MANUFACTURER;
		}
	
	}

}
