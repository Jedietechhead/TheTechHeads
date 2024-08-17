package models;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartItem> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addItem(CartItem item) {
        items.add(item);
    }

    public void removeItem(CartItem item) {
        items.remove(item);
    }

    public List<CartItem> getItems() {
        return new ArrayList<>(items); // Return a copy of the list to prevent modification
    }

    public double getTotalAmount() {
        return items.stream()
                .mapToDouble(CartItem::getPrice)
                .sum();
    }

    public int getItemCount() {
        return items.size();
    }
}
