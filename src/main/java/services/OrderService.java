package services;



import daos.OrderDAO;

import java.util.List;

public class OrderService {
    private OrderDAO orderDAO;

    public OrderService() {
        this.orderDAO = new OrderDAO();
    }

    public List<String> getAllOrders() {
        return orderDAO.getAllOrders();
    }
}
