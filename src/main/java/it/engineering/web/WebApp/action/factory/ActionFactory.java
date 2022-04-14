package it.engineering.web.WebApp.action.factory;

import it.engineering.web.WebApp.action.AbstractAction;
import it.engineering.web.WebApp.action.login.LoginAction;
import it.engineering.web.WebApp.constant.WebConstants;

public class ActionFactory {
	public static AbstractAction createAction(String method, String path) {
		
		AbstractAction action = null;
		
		switch (path) {
		case WebConstants.PATH_LOGIN:
			action = new LoginAction();
			break;
		default:
			break;
		}
		return action;
	}
}