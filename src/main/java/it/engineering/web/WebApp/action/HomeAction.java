package it.engineering.web.WebApp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.WebApp.constant.WebConstants;

public class HomeAction extends AbstractAction{

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		return WebConstants.PAGE_LOGIN;
	}

}
