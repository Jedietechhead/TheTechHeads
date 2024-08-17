package controllers;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import models.*;
import services.ProductService;

public class ProductsPageController {

    private ProductService productService;
    private Cart cart;
    private AppNavigation appNavigation;
    private Label cartCounterLabel; // Cart counter label

    public ProductsPageController(ProductService productService, Cart cart, AppNavigation appNavigation) {
        this.productService = productService;
        this.cart = cart;
        this.appNavigation = appNavigation;
    }

    public Scene getView() {
        BorderPane mainLayout = new BorderPane();

        // Top menu with buttons and cart counter
        HBox menuBox = new HBox(10); // Create an HBox with spacing
        menuBox.setPadding(new Insets(10));
        menuBox.setAlignment(Pos.CENTER_RIGHT);

        Button loginButton = new Button("Login");
        loginButton.setOnAction(event -> appNavigation.goToLoginPage());

        Button registerButton = new Button("Register");
        registerButton.setOnAction(event -> appNavigation.goToRegisterPage());

        cartCounterLabel = new Label("Cart (" + cart.getItemCount() + ")");
        Button cartButton = new Button("Cart");
        cartButton.setOnAction(event -> appNavigation.goToCartPage());

        menuBox.getChildren().addAll(loginButton, registerButton, cartButton, cartCounterLabel);
        mainLayout.setTop(menuBox);

        // Product grid
        GridPane productGrid = new GridPane();
        productGrid.setHgap(10);
        productGrid.setVgap(10);
        productGrid.setPadding(new Insets(10));

        int row = 0;
        int col = 0;
        for (Product product : productService.getAllProducts()) {
            VBox productBox = new VBox(5);
            productBox.setPadding(new Insets(10));

            Label nameLabel = new Label(product.getName());
            Label priceLabel = new Label("Price: $" + String.format("%.2f", product.getPrice()));

            Button viewDetailsButton = new Button("View Details");
            viewDetailsButton.setOnAction(event -> appNavigation.goToProductDetailsPage(product.getId()));

            Button addToCartButton = new Button("Add to Cart");
            addToCartButton.setOnAction(event -> {
                cart.addItem(new CartItem(product.getName(), product.getPrice()));
                updateCartCounter(); // Update the cart counter label
            });

            productBox.getChildren().addAll(nameLabel, priceLabel, viewDetailsButton, addToCartButton);
            productGrid.add(productBox, col, row);

            col++;
            if (col > 2) {
                col = 0;
                row++;
            }
        }

        mainLayout.setCenter(productGrid);

        return new Scene(mainLayout, AppConstants.SCENE_WIDTH, AppConstants.SCENE_HEIGHT);
    }

    private void updateCartCounter() {
        cartCounterLabel.setText("Cart (" + cart.getItemCount() + ")");
    }


}
