package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
public class ProductBasket {
    private final Product[] products = new Product[10];
    private int productCount = 0;
    public boolean addProduct(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                productCount++;
                return true;
            }
        }
        return false;
    }
    public double getTotalPrice() {
        return 0;
    }

    public Product[] getProducts() {
        return new Product[] {};
    }

    public boolean hasProduct(Product product) {
        return false;
    }

    public void removeProduct(Product product) {

    }

    public void clear() {

    }
}