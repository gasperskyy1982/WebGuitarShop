package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controllers.DBUtils;
import dao.UserDAO;
import models.User;
import mySQL.MySQLUserDAO;

/**
 * Servlet implementation class AuthServlet
 */
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String logOut = request.getParameter("logOut");
		
		if (logOut != null) {
			session.invalidate();
			session = request.getSession(true);
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/AuthDB.jsp");
		rd.forward(request, response);

				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Logout: " + request.getParameter("logOut"));
		
		UserDAO userDAO = new MySQLUserDAO();
		
		boolean showForm = true;
		boolean isError = false;
		String logOut = request.getParameter("logOut");
		String login = request.getParameter("Login");
		String password = request.getParameter("Password");
		HttpSession session = request.getSession();
			
		if (logOut != null) {
			session.invalidate();
			session = request.getSession(true);
			showForm = true;
		} else {
			if (login != null && password != null) {
				if (userDAO.getAuth(login, password)) {
					showForm = false;
					
					User user = userDAO.createUser(MySQLUserDAO.userLogin, MySQLUserDAO.userPassword, MySQLUserDAO.userName, 
							MySQLUserDAO.userRegion, MySQLUserDAO.userGender, MySQLUserDAO.userComment);
					session.setAttribute("user", user);
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/AuthedDB.jsp");
					request.setAttribute("authUser", user);
					request.setAttribute("auth", "Autorized");
					rd.forward(request, response);
				} else {
					isError = true;
					request.setAttribute("isError", isError);
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/AuthDB.jsp");
					rd.forward(request, response);
				}
			}

			if (showForm) {
				doGet(request, response);
			}
		}
	}

}
