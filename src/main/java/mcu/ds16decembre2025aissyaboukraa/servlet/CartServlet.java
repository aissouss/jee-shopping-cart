package mcu.ds16decembre2025aissyaboukraa.servlet;

import mcu.ds16decembre2025aissyaboukraa.dao.CartDAO;
import mcu.ds16decembre2025aissyaboukraa.dao.ProductDAO;
import mcu.ds16decembre2025aissyaboukraa.model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    private ProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        CartDAO cart = (CartDAO) session.getAttribute("cart");

        if (cart == null) {
            cart = new CartDAO();
            session.setAttribute("cart", cart);
        }

        String action = request.getParameter("action");

        if ("add".equals(action)) {
            int productId = Integer.parseInt(request.getParameter("id"));

            Product product = productDAO.getAllProducts()
                    .stream()
                    .filter(p -> p.getId() == productId)
                    .findFirst()
                    .orElse(null);


            if (product != null) {
                cart.addProduct(product);
            }


            response.sendRedirect("products");
            return;
        }


        request.setAttribute("items", cart.getItems());
        request.setAttribute("total", cart.getTotal());

        request.getRequestDispatcher("cart.jsp")
                .forward(request, response);
    }
}

