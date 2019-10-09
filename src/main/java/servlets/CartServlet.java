package servlets;

import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Product;
import mySQL.MySQLDAOFactory;
import mySQL.MySQLProductDAO;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/CartView.jsp");
		// request.setAttribute("productList", (List<Product>)
		// session.getAttribute("cart"));
		request.setAttribute("productMap", (Map<Product, Integer>) session.getAttribute("cart"));
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println(request.getParameter("submit"));
		HttpSession session = request.getSession();

		long productId;
		int numberGeneralProducts;
		Product product;

		if (request.getParameter("productToRemove") !=null) {
								
			productId = Integer.parseInt(request.getParameter("productToRemove"));
			product = new MySQLProductDAO().getProductById(productId);
			
			Map <Product, Integer> cartMap;
			cartMap = (Map<Product, Integer>) session.getAttribute("cart");
			long numberCurrentProduct=0;
			numberGeneralProducts = (int) (session.getAttribute("numberGeneralProducts"));
						
			if (cartMap.keySet().contains(product)) {
				numberCurrentProduct = cartMap.get(product);
				numberGeneralProducts -= numberCurrentProduct;
				session.setAttribute("numberGeneralProducts", numberGeneralProducts);
				cartMap.remove(product);
			}
			
		}
		
		if (request.getParameter("submit") != null && request.getParameter("submit").equals("+")) {

			productId = Integer.parseInt(request.getParameter("productToRemoveBuy"));
			product = new MySQLProductDAO().getProductById(productId);
			numberGeneralProducts = (int) (session.getAttribute("numberGeneralProducts"));
			System.out.println("Number General Before adding:" + numberGeneralProducts);
			numberGeneralProducts++;
			System.out.println("Number General After adding:" + numberGeneralProducts);
			session.setAttribute("numberGeneralProducts", numberGeneralProducts);

			Map<Product, Integer> cartMap;
			cartMap = (Map<Product, Integer>) session.getAttribute("cart");
			long numberCurrentProduct = 0;

			numberCurrentProduct = cartMap.get(product);
			System.out.println("Number of Current Product before increment: " + numberCurrentProduct);
			cartMap.put(product, (int) ++numberCurrentProduct);
			System.out.println("Product++");
			System.out.println("Number of Current Product after increment: " + numberCurrentProduct);
		}

		if (request.getParameter("submit") != null && request.getParameter("submit").equals("+")) {

			productId = Integer.parseInt(request.getParameter("productToBuy"));
			product = new MySQLProductDAO().getProductById(productId);

			numberGeneralProducts = (int) (session.getAttribute("numberGeneralProducts"));
			System.out.println("Number General Before deleting:" + numberGeneralProducts);
			numberGeneralProducts--;
			System.out.println("Number General After deleting:" + numberGeneralProducts);
			session.setAttribute("numberGeneralProducts", numberGeneralProducts);

			Map<Product, Integer> cartMap;
			cartMap = (Map<Product, Integer>) session.getAttribute("cart");

			long numberCurrentProduct = 0;

			numberCurrentProduct = cartMap.get(product);
			System.out.println("Number of Current Product before deleting: " + numberCurrentProduct);
			if (numberCurrentProduct > 1) {
				cartMap.put(product, (int) --numberCurrentProduct);
			} else {
				cartMap.remove(product);
			}

		}

		if (request.getParameter("ClearCart") != null && request.getParameter("submit") == null && request.getParameter("productToRemove") == null) {
			System.out.println(request.getParameter("ClearCart"));
			numberGeneralProducts = 0;
			session.setAttribute("cart", null);
			session.setAttribute("numberGeneralProducts", numberGeneralProducts);
		}

		if (request.getParameter("productToBuy") != null && request.getParameter("ClearCart") == null) {

			productId = Integer.parseInt(request.getParameter("productToBuy"));
			product = new MySQLProductDAO().getProductById(productId);

			Map<Product, Integer> cartMap;
			long numberCurrentProduct = 0;

			if (session.getAttribute("cart") != null) {
				System.out.println("Old cart");
				boolean isNewProduct = true;
				cartMap = (Map<Product, Integer>) session.getAttribute("cart");
				numberGeneralProducts = (int) (session.getAttribute("numberGeneralProducts"));
				System.out.println("Number General Before adding:" + numberGeneralProducts);
				numberGeneralProducts++;
				System.out.println("Number General After adding:" + numberGeneralProducts);

				System.out.println(cartMap.keySet().contains(product));

				if (cartMap.keySet().contains(product)) {
					System.out.println("This product has already is");
					System.out.println("It`s ProductId " + productId);
					numberCurrentProduct = cartMap.get(product);
					System.out.println("Number of Current Product is: " + numberCurrentProduct);
					cartMap.put(product, (int) ++numberCurrentProduct);
					System.out.println("Adding Product");
					System.out.println("Number of Current Product after adding is: " + numberCurrentProduct);
					isNewProduct = false;
				} else {
					System.out.println("This is new product");
					System.out.println("Number of Current Product is: " + numberCurrentProduct);
					cartMap.put(product, (int) ++numberCurrentProduct);
					System.out.println("Number of Current Product after adding is: " + numberCurrentProduct);
				}

			} else {
				System.out.println("New cart");
				cartMap = new HashMap<Product, Integer>();
				System.out.println("Number of Current Product is: " + numberCurrentProduct);
				cartMap.put(product, (int) ++numberCurrentProduct);
				System.out.println("Number of Current Product after adding is: " + numberCurrentProduct);
				numberGeneralProducts = 1;
				System.out.println("Number of General Products:" + numberGeneralProducts);
			}

			System.out.println("In the cart is: " + cartMap);
			session.setAttribute("numberCurrentProduct", numberCurrentProduct);
			session.setAttribute("cart", cartMap);
			session.setAttribute("numberGeneralProducts", numberGeneralProducts);

		}
		response.sendRedirect("./products");
	}

}
