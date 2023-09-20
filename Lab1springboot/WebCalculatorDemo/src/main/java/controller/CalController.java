package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CalculatorModel;

/**
 * Servlet implementation class CalController
 */
@WebServlet("/CalController")
public class CalController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("cal.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		String action = request.getParameter("action");
		CalculatorModel model = new CalculatorModel(Float.parseFloat(num1), Float.parseFloat(num2), action);
		// We set the model as the name RS
		// Send this RS to the file result.jsp to display
		request.setAttribute("RS", model);
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}

}
