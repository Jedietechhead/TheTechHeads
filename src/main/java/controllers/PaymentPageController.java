package controllers;

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

public class PaymentPageController {

    private Cart cart;
    private AppNavigation appNavigation;

    public PaymentPageController(Cart cart, AppNavigation appNavigation) {
        this.cart = cart;
        this.appNavigation = appNavigation;
    }

    public Scene getView() {
        BorderPane mainLayout = new BorderPane();
        VBox paymentLayout = new VBox(10);
        paymentLayout.setPadding(new Insets(10));
        paymentLayout.setAlignment(Pos.CENTER);

        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();

        Label cardNumberLabel = new Label("Credit Card Number:");
        TextField cardNumberField = new TextField();

        Label expDateLabel = new Label("Expiration Date (MM/YY):");
        TextField expDateField = new TextField();

        Label cvvLabel = new Label("CVV:");
        TextField cvvField = new TextField();

        Button confirmButton = new Button("Confirm Payment");
        confirmButton.setOnAction(event -> {
            // Process payment here (e.g., validation, charging, etc.)
            appNavigation.goToPaymentSuccessPage();
        });

        paymentLayout.getChildren().addAll(nameLabel, nameField, cardNumberLabel, cardNumberField, expDateLabel, expDateField, cvvLabel, cvvField, confirmButton);
        mainLayout.setCenter(paymentLayout);

        return new Scene(mainLayout, 400, 300);
    }
}
