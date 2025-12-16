package mcu.ds16decembre2025aissyaboukraa.servlet;

import mcu.ds16decembre2025aissyaboukraa.dao.CartDAO;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/remove-from-cart")
public class RemoveFromCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {


        HttpSession session = request.getSession(false);

        if (session != null) {

            CartDAO cart = (CartDAO) session.getAttribute("cart");

            if (cart != null) {

                int productId = Integer.parseInt(request.getParameter("id"));


                cart.removeProduct(productId);
            }
        }


        response.sendRedirect("cart");
    }
}

