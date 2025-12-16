package mcu.ds16decembre2025aissyaboukraa.dao;

import mcu.ds16decembre2025aissyaboukraa.model.Product;

import java.util.ArrayList;
import java.util.List;


public class ProductDAO {

    private static List<Product> products = new ArrayList<>();
    private static int currentId = 1;


    public void addProduct(Product p) {
        p.setId(currentId);
        currentId++;
        products.add(p);
    }


    public List<Product> getAllProducts() {
        return products;
    }


    public void deleteProduct(int id) {
        products.removeIf(product -> product.getId() == id);
    }
}

