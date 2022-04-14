package it.engineering.web.WebApp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.WebApp.controller.ApplicationController;

@WebServlet("/application/*")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ApplicationController applicationController;
	
    public FrontController() {
        super();
    }

    @Override
    public void init() throws ServletException {
    	super.init();
    	applicationController = new ApplicationController();
    	System.out.println("Application Controller created...");
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = applicationController.processRequest(request, response);
		request.getRequestDispatcher(page).forward(request, response);
	}
}
