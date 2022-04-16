package it.engineering.web.WebApp.action.factory;

import it.engineering.web.WebApp.action.AbstractAction;
import it.engineering.web.WebApp.action.HomeAction;
import it.engineering.web.WebApp.action.city.AddCityGetAction;
import it.engineering.web.WebApp.action.city.AddCityPostAction;
import it.engineering.web.WebApp.action.city.ViewCityAction;
import it.engineering.web.WebApp.action.login.LoginAction;
import it.engineering.web.WebApp.action.manufacturer.AddManufacturerGetAction;
import it.engineering.web.WebApp.action.manufacturer.AddManufacturerPostAction;
import it.engineering.web.WebApp.action.manufacturer.ViewManufacturersAction;
import it.engineering.web.WebApp.constant.WebConstants;

public class ActionFactory {
	public static AbstractAction createAction(String method, String path) {
		
		AbstractAction action = null;
		
		switch (path) {
		case WebConstants.PATH_HOME:
			action = new HomeAction();
			break;
		case WebConstants.PATH_LOGIN:
			action = new LoginAction();
			break;
		case WebConstants.PATH_ADD_CITY:
			if(method.equalsIgnoreCase("GET"))
				action = new AddCityGetAction();
			else if(method.equalsIgnoreCase("POST"))
				action = new AddCityPostAction();
			break;
		case WebConstants.PATH_VIEW_CITY:
			action = new ViewCityAction();
			break;
		case WebConstants.PATH_ADD_MANUFACTURER:
			if(method.equalsIgnoreCase("GET"))
				action = new AddManufacturerGetAction();
			else if(method.equalsIgnoreCase("POST"))
				action = new AddManufacturerPostAction();
			break;
		case WebConstants.PATH_VIEW_MANUFACTURER:
			action = new ViewManufacturersAction();
		default:
			break;
		}
		return action;
	}
}