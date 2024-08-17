package models;

import javafx.application.Application;
import javafx.stage.Stage;
import services.ProductService;

public class EcommerceApp extends Application {

    private ProductService productService;
    private Cart cart;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("eCommerce Application");

        // Initialize the ProductService and Cart
        productService = new ProductService(); // Replace with actual initialization if needed
        cart = new Cart(); // Replace with actual initialization if needed

        // Pass all required arguments to AppNavigation
        AppNavigation appNavigation = new AppNavigation(primaryStage, productService, cart);

        // Start with the main page
        appNavigation.goToMainPage();

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
