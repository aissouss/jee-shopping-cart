package mcu.ds16decembre2025aissyaboukraa.dao;

import mcu.ds16decembre2025aissyaboukraa.model.CartItem;
import mcu.ds16decembre2025aissyaboukraa.model.Product;

import java.util.ArrayList;
import java.util.List;


public class CartDAO {

    private List<CartItem> items = new ArrayList<>();


    public List<CartItem> getItems() {
        return items;
    }


    public void addProduct(Product product) {


        for (CartItem item : items) {
            if (item.getProduct().getId() == product.getId()) {
                item.setQuantity(item.getQuantity() + 1);
                return;
            }
        }


        CartItem newItem = new CartItem(product, 1);
        items.add(newItem);
    }


    public void removeProduct(int productId) {
        for (CartItem item : items) {
            if (item.getProduct().getId() == productId) {
                if (item.getQuantity() > 1) {
                    item.setQuantity(item.getQuantity() - 1);
                } else {
                    items.remove(item);
                }
                break;
            }
        }
    }



    public double getTotal() {
        double total = 0;

        for (CartItem item : items) {
            total += item.getSubTotal();
        }

        return total;
    }
}
