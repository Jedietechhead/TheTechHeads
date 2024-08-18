package controllers;

import models.AppConstants;
import models.AppNavigation;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class PaymentSuccessPageController {

    private AppNavigation appNavigation;

    public PaymentSuccessPageController(AppNavigation appNavigation) {
        this.appNavigation = appNavigation;
    }

    public Scene getView() {
        BorderPane mainLayout = new BorderPane();
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.CENTER);

        Label successLabel = new Label("Payment Successful!");
        successLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: green;");

        Button backToProductPageButton = new Button("Back to Products");
        backToProductPageButton.setOnAction(event -> appNavigation.goToProductListing());

        vbox.getChildren().addAll(successLabel, backToProductPageButton);
        mainLayout.setCenter(vbox);

        return new Scene(mainLayout, AppConstants.SCENE_WIDTH,AppConstants.SCENE_HEIGHT);

    }
}
