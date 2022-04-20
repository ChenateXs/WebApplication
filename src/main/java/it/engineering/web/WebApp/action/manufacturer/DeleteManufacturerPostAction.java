package it.engineering.web.WebApp.action.manufacturer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.WebApp.action.AbstractAction;
import it.engineering.web.WebApp.constant.WebConstants;
import it.engineering.web.WebApp.service.impl.CityService;
import it.engineering.web.WebApp.service.impl.ManufacturerService;

public class DeleteManufacturerPostAction extends AbstractAction {

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		Long id = Long.parseLong(request.getParameter("id"));
		String confirm = request.getParameter("confirm");
		
		try {
			if (confirm.equals("Yes")) {
				new ManufacturerService().delete(id);

				request.setAttribute("message", "Manufacturer has succesfully been deleted.");
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
