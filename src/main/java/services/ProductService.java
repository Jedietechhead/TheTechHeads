package services;

import models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private List<Product> products;

    public ProductService() {
        products = new ArrayList<>();
        // Add some sample products
        products.add(new Product("1", "Product 1", "Description of Product 1", 10.00));
        products.add(new Product("2", "Product 2", "Description of Product 2", 20.00));
        products.add(new Product("3", "Product 3", "Description of Product 3", 30.00));
        products.add(new Product("4", "Product 4", "Description of Product 4", 40.00));
        products.add(new Product("5", "Product 5", "Description of Product 5", 50.00));
        products.add(new Product("6", "Product 6", "Description of Product 6", 60.00));
        products.add(new Product("7", "Product 7", "Description of Product 7", 70.00));
        products.add(new Product("8", "Product 8", "Description of Product 8", 80.00));
        products.add(new Product("9", "Product 9", "Description of Product 9", 90.00));
        products.add(new Product("10", "Product 10", "Description of Product 10", 100.00));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }
}
