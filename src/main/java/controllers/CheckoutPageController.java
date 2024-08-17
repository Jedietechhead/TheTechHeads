package controllers;

import models.AppConstants;
import models.AppNavigation;
import models.Cart;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class CheckoutPageController {

    private Cart cart;
    private AppNavigation appNavigation;

    public CheckoutPageController(Cart cart, AppNavigation appNavigation) {
        this.cart = cart;
        this.appNavigation = appNavigation;
    }

    public Scene getView() {
        BorderPane mainLayout = new BorderPane();
        VBox checkoutLayout = new VBox(10);
        checkoutLayout.setPadding(new Insets(10));
        checkoutLayout.setAlignment(Pos.CENTER);

        // Payment details fields
        TextField nameField = new TextField();
        nameField.setPromptText("Name");

        TextField cardNumberField = new TextField();
        cardNumberField.setPromptText("Card Number");

        TextField expDateField = new TextField();
        expDateField.setPromptText("Expiration Date");

        TextField cvvField = new TextField();
        cvvField.setPromptText("CVV");

        Label totalLabel = new Label("Total Amount: $" + String.format("%.2f", cart.getTotalAmount()));

        Button confirmPaymentButton = new Button("Confirm Payment");
        confirmPaymentButton.setOnAction(event -> {
            // Process payment here
            appNavigation.goToPaymentSuccessPage();
        });

        checkoutLayout.getChildren().addAll(nameField, cardNumberField, expDateField, cvvField, totalLabel, confirmPaymentButton);
        mainLayout.setCenter(checkoutLayout);

        return new Scene(mainLayout, AppConstants.SCENE_WIDTH,AppConstants.SCENE_HEIGHT);
    }
}
