package it.engineering.web.WebApp.action.manufacturer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.WebApp.action.AbstractAction;
import it.engineering.web.WebApp.constant.WebConstants;
import it.engineering.web.WebApp.domain.Manufacturer;
import it.engineering.web.WebApp.service.impl.ManufacturerService;

public class DeleteManufacturerGetAction extends AbstractAction{

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		try {
			Long id = Long.parseLong(request.getParameter("id"));
			Manufacturer manufacturer = new ManufacturerService().read(id);
			request.setAttribute("manufacturtr", manufacturer);
			return WebConstants.PAGE_DELETE_MANUFACTURER;
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			request.setAttribute("manufacturers", new ManufacturerService().getAll());
			return WebConstants.PAGE_VIEW_MANUFACTURER;
		}
	}

}
