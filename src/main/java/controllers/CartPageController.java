package controllers;

import models.AppConstants;
import models.AppNavigation;
import models.Cart;
import models.CartItem;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class CartPageController {

    private Cart cart;
    private AppNavigation appNavigation;
    private Label totalAmountLabel; // Label to display total amount

    public CartPageController(Cart cart, AppNavigation appNavigation) {
        this.cart = cart;
        this.appNavigation = appNavigation;
    }

    public Scene getView() {
        BorderPane mainLayout = new BorderPane();

        // ListView with custom cells for cart items
        ListView<CartItem> cartItemsListView = new ListView<>();
        cartItemsListView.getItems().addAll(cart.getItems());

        // Custom cell factory to include remove button
        cartItemsListView.setCellFactory(new Callback<>() {
            @Override
            public ListCell<CartItem> call(ListView<CartItem> listView) {
                return new ListCell<>() {
                    private final Button removeButton = new Button("Remove");

                    @Override
                    protected void updateItem(CartItem item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null) {
                            setText(null);
                            setGraphic(null);
                        } else {
                            setText(item.getName() + " - $" + String.format("%.2f", item.getPrice()));
                            removeButton.setOnAction(event -> {
                                cart.removeItem(item);
                                cartItemsListView.getItems().remove(item);
                                updateTotalAmount();
                            });
                            setGraphic(removeButton);
                        }
                    }
                };
            }
        });

        VBox cartBox = new VBox(10);
        cartBox.setPadding(new Insets(10));
        cartBox.setAlignment(Pos.CENTER);

        // Calculate and update total amount
        totalAmountLabel = new Label("Total Amount: $" + String.format("%.2f", getTotalAmount()));

        Button proceedToPaymentButton = new Button("Proceed to Payment");
        proceedToPaymentButton.setOnAction(event -> appNavigation.goToCheckoutPage());

        Button backButton = new Button("Back");
        backButton.setOnAction(event -> appNavigation.goToProductListing());

        cartBox.getChildren().addAll(cartItemsListView, totalAmountLabel, proceedToPaymentButton, backButton);
        mainLayout.setCenter(cartBox);

        return new Scene(mainLayout, AppConstants.SCENE_WIDTH, AppConstants.SCENE_HEIGHT);
    }

    private double getTotalAmount() {
        return cart.getItems().stream()
                .mapToDouble(CartItem::getPrice)
                .sum();
    }

    private void updateTotalAmount() {
        totalAmountLabel.setText("Total Amount: $" + String.format("%.2f", getTotalAmount()));
    }
}
