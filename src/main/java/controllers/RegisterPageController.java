package controllers;

import models.AppConstants;
import models.AppNavigation;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class RegisterPageController {

    private AppNavigation appNavigation;

    public RegisterPageController(AppNavigation appNavigation) {
        this.appNavigation = appNavigation;
    }

    public Scene getView() {
        BorderPane mainLayout = new BorderPane();
        VBox formLayout = new VBox(10);
        formLayout.setPadding(new Insets(10));
        formLayout.setAlignment(Pos.CENTER);

        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Password:");
        TextField passwordField = new TextField(); // Consider using PasswordField for actual password entry

        Button registerButton = new Button("Register");
        Button backButton = new Button("Back to Products");

        registerButton.setOnAction(event -> {
            // Implement registration logic here
            System.out.println("Register clicked");
        });

        backButton.setOnAction(event -> appNavigation.goToMainPage());

        formLayout.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, registerButton, backButton);
        mainLayout.setCenter(formLayout);

        return new Scene(mainLayout, AppConstants.SCENE_WIDTH,AppConstants.SCENE_HEIGHT);
    }
}
