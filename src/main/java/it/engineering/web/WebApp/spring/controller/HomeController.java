package it.engineering.web.WebApp.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/home")
public class HomeController {
	
	
	//@RequestMapping(path = "/home", method = RequestMethod.GET)
	@RequestMapping(method = RequestMethod.GET)
	public String home() {
		return "home";
	}

}
