package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserService;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	
	public LoginController() {
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	     throws ServletException, IOException {
	     RequestDispatcher rd = request.getRequestDispatcher("login.jsp"); 
	     rd.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	     throws ServletException, IOException {
	     String username = request.getParameter("username"); 
	     String password = request.getParameter("password");
	     
	     User user = new User(username, password); 
	     UserService service = new UserService();
	     
	     if (service.checkLogin(user)) { 
	    	 response.sendRedirect("welcome.jsp");
	     }else{ 
	    	 response.sendRedirect("login.jsp?err=1");
	     } 
	}
	
	@Override
	public String getServletInfo() {
		return "Short description"; 
	}
}
