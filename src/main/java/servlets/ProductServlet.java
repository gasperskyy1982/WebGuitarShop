package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Product;
import mySQL.MySQLProductDAO;

/**
 * Servlet implementation class Products
 */
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int category;
		int id;
		List<Product> products;
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/ProductsView.jsp");
		if (request.getParameter("category") != null) {
			category = Integer.parseInt(request.getParameter("category"));
			products = new MySQLProductDAO().getProductByCategory(category);
		} else {
			products = new MySQLProductDAO().getProductList();
		}
		request.setAttribute("productList", products);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
