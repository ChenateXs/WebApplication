package it.engineering.web.WebApp.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.engineering.web.WebApp.dto.UserDto;
import it.engineering.web.WebApp.service.impl.UserService;
import it.engineering.web.WebApp.spring.service.LoginService;

@Controller
@RequestMapping(path = "/login")
public class LoginController {
	@Autowired
	private LoginService loginService;

	@RequestMapping(method = RequestMethod.GET)
	public String login() {
		// vratiti stranicu za prijavu na sistem
		// login.jsp se nalazi u folderu login
		return "login/login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String executeLogin(HttpServletRequest request, @RequestParam(name = "username") String usrname,
			@RequestParam String password) {

		UserDto userDto = loginService.login(new UserDto(usrname, password,null,null));
		if (userDto != null) {
			return "redirect:/home";

		} else {
			request.setAttribute("exception", "Greska kod unosa, korisnik ne postoji!");
			return "login/login";
		}
	}

}
