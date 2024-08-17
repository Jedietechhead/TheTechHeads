package models;

import controllers.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label; // Add this import
import services.ProductService;


public class AppNavigation {

    private Stage primaryStage;
    private ProductService productService;
    private Cart cart;
    private Label cartCounterLabel; // Make sure this is defined

    public AppNavigation(Stage primaryStage, ProductService productService, Cart cart) {
        this.primaryStage = primaryStage;
        this.productService = productService;
        this.cart = cart;
        // Initialize cartCounterLabel if needed
        this.cartCounterLabel = new Label("Cart (0)");
    }

    public void goToProductListing() {
        ProductsPageController productsPageController = new ProductsPageController(productService, cart, this);
        Scene scene = productsPageController.getView();
        primaryStage.setScene(scene);
    }

    public void goToProductDetailsPage(String productId) {
        ProductDetailsPageController productDetailsPageController = new ProductDetailsPageController(productService, cart, this, productId);
        Scene scene = productDetailsPageController.getView();
        primaryStage.setScene(scene);
    }

    public void goToCartPage() {
        CartPageController cartPageController = new CartPageController(cart, this);
        Scene scene = cartPageController.getView();
        primaryStage.setScene(scene);
    }

    public void goToLoginPage() {
        LoginPageController loginPageController = new LoginPageController(this);
        Scene scene = loginPageController.getView();
        primaryStage.setScene(scene);
    }

    public void goToRegisterPage() {
        RegisterPageController registerPageController = new RegisterPageController(this);
        Scene scene = registerPageController.getView();
        primaryStage.setScene(scene);
    }

    public void goToCheckoutPage() {
        CheckoutPageController checkoutPageController = new CheckoutPageController(cart, this);
        Scene scene = checkoutPageController.getView();
        primaryStage.setScene(scene);
    }

    public void goToPaymentPage() {
        PaymentPageController paymentPageController = new PaymentPageController(cart, this);
        Scene scene = paymentPageController.getView();
        primaryStage.setScene(scene);
    }

    public void goToPaymentSuccessPage() {
        PaymentSuccessPageController paymentSuccessPageController = new PaymentSuccessPageController(this);
        Scene scene = paymentSuccessPageController.getView();
        primaryStage.setScene(scene);
    }

    public void goToMainPage() {
        goToProductListing(); // Assuming the main page is the product listing
    }

    public void updateCartCounter(int itemCount) {
        if (cartCounterLabel != null) {
            cartCounterLabel.setText("Cart (" + itemCount + ")");
        }
    }
}
