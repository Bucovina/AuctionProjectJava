package classes;

import java.sql.*;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/auctionproject";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static Database instance;

    private Database() {
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public void addUser(User user) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (name, username, password) VALUES (?, ?, ?)")) {

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getUsername());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
