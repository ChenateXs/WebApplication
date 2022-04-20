package it.engineering.web.WebApp.action.manufacturer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.WebApp.action.AbstractAction;
import it.engineering.web.WebApp.constant.WebConstants;
import it.engineering.web.WebApp.domain.Manufacturer;
import it.engineering.web.WebApp.repository.impl.CityRepository;
import it.engineering.web.WebApp.service.impl.ManufacturerService;

public class UpdateManufacturerGetAction extends AbstractAction {

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		try {
			Manufacturer manufacturer= new ManufacturerService().read(Long.parseLong(request.getParameter("id")));
			request.setAttribute("manufacturer", manufacturer);
			request.setAttribute("cities", new CityRepository().getAll());
			return WebConstants.PAGE_UPDATE_MANUFACTURER;
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			request.setAttribute("manufacturers", new ManufacturerService().getAll());
			return WebConstants.PAGE_VIEW_MANUFACTURER;
		}
	}

}
