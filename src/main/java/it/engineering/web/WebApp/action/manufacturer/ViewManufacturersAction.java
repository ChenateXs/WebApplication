package it.engineering.web.WebApp.action.manufacturer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.WebApp.action.AbstractAction;
import it.engineering.web.WebApp.constant.WebConstants;
import it.engineering.web.WebApp.service.impl.CityService;
import it.engineering.web.WebApp.service.impl.ManufacturerService;

public class ViewManufacturersAction extends AbstractAction {

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("manufacturers", new ManufacturerService().getAll());
		return WebConstants.PAGE_VIEW_MANUFACTURER;
	}

}
