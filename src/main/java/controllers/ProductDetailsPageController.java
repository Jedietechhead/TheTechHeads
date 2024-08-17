package controllers;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import models.*;
import services.ProductService;

public class ProductDetailsPageController {

    private ProductService productService;
    private Cart cart;
    private AppNavigation appNavigation;
    private String productId;

    public ProductDetailsPageController(ProductService productService, Cart cart, AppNavigation appNavigation, String productId) {
        this.productService = productService;
        this.cart = cart;
        this.appNavigation = appNavigation;
        this.productId = productId;
    }

    public Scene getView() {
        BorderPane mainLayout = new BorderPane();
        VBox detailsLayout = new VBox(10);
        detailsLayout.setPadding(new Insets(10));
        detailsLayout.setAlignment(Pos.CENTER);

        // Fetch product details
        Product product = productService.getProductById(productId);

        Label nameLabel = new Label("Name: " + product.getName());
        Label descriptionLabel = new Label("Description: " + product.getDescription());
        Label priceLabel = new Label("Price: $" + String.format("%.2f", product.getPrice()));

        Button addToCartButton = new Button("Add to Cart");
        addToCartButton.setOnAction(event -> {
            cart.addItem(new CartItem(product.getName(), product.getPrice()));
            appNavigation.updateCartCounter(cart.getItemCount());
        });

        Button backButton = new Button("Back to Products");
        backButton.setOnAction(event -> appNavigation.goToMainPage()); // Navigate to main page

        detailsLayout.getChildren().addAll(nameLabel, descriptionLabel, priceLabel, addToCartButton, backButton);
        mainLayout.setCenter(detailsLayout);

        return new Scene(mainLayout, AppConstants.SCENE_WIDTH,AppConstants.SCENE_HEIGHT);
    }
}
