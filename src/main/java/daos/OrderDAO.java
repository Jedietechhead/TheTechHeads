package daos;



import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    private static final String FILE_NAME = "orders.txt";

    public List<String> getAllOrders() {
        List<String> orders = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                orders.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
