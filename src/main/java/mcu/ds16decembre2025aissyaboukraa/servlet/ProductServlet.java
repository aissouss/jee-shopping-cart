package mcu.ds16decembre2025aissyaboukraa.servlet;

import mcu.ds16decembre2025aissyaboukraa.dao.ProductDAO;
import mcu.ds16decembre2025aissyaboukraa.model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    private static ProductDAO productDAO = new ProductDAO();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String name = request.getParameter("name");
        String priceStr = request.getParameter("price");

        double price = Double.parseDouble(priceStr);


        Product product = new Product();
        product.setName(name);
        product.setPrice(price);


        productDAO.addProduct(product);


        response.sendRedirect("products");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String action = request.getParameter("action");


        if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            productDAO.deleteProduct(id);


            response.sendRedirect("products");
            return;
        }


        List<Product> products = productDAO.getAllProducts();
        request.setAttribute("products", products);
        request.getRequestDispatcher("list-products.jsp")
                .forward(request, response);
    }



}

