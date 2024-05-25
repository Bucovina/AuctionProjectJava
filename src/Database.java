import classes.User;

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
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Angajati (CNP, Nume, Salariu) VALUES (?, ?, ?)")) {

            preparedStatement.setString(1, user.getName());
            //preparedStatement.setDouble(3, user.get());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
