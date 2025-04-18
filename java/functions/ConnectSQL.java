package functions;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class ConnectSQL {
    // connnections issues with driver and database
    public void getConnection() {
        String url = "jdbc:mysql://localhost:5432/Dialga";
        String user = "k";
        String password = "changeit";

        String query = "SELECT * FROM users;";

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found: " + e.getMessage());
            return;
        }
        System.out.println("Driver loaded successfully.");

        try (Connection connection = DriverManager.getConnection(url, user, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();

        }

    }
}