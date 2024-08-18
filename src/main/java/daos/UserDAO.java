package daos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static final String FILE_NAME = "users.txt";

    public List<String> getAllUsers() {
        List<String> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                users.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}
