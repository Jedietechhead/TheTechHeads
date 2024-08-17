package daos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private static final String FILE_NAME = "products.txt";

    public List<String> getAllProducts() {
        List<String> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                products.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    public void addToCart(int productId) {
        // Implementation for adding a product to cart (if required)
    }
}
