package it.engineering.web.WebApp.action.factory;

import it.engineering.web.WebApp.action.AbstractAction;
import it.engineering.web.WebApp.action.HomeAction;
import it.engineering.web.WebApp.action.city.AddCityGetAction;
import it.engineering.web.WebApp.action.city.AddCityPostAction;
import it.engineering.web.WebApp.action.login.LoginAction;
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
		default:
			break;
		}
		return action;
	}
}