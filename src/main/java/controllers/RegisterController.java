package controllers;





import models.AppNavigation;
import services.UserService;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class RegisterController {

    private UserService userService;
    private AppNavigation appNavigation;
    private VBox registerContainer;

    public RegisterController(UserService userService, AppNavigation appNavigation) {
        this.userService = userService;
        this.appNavigation = appNavigation;

        registerContainer = new VBox();
        registerContainer.setSpacing(10);
        registerContainer.setPadding(new Insets(10));
        registerContainer.setAlignment(Pos.CENTER);

        loadRegisterPage();
    }

    private void loadRegisterPage() {
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        Button registerButton = new Button("Register");

        registerButton.setOnAction(event -> {
            // Placeholder for actual registration logic
            System.out.println("User registered with username: " + usernameField.getText());
            appNavigation.goToLoginPage();
        });

        registerContainer.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, registerButton);
    }

    public Scene getView() {
        return new Scene(registerContainer, 800, 600);
    }
}
