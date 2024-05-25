package services;

import classes.Database;
import classes.User;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserService {

    public void addUser(User user) {
        try (Connection connection = DriverManager.getConnection(Database.getURL(), Database.getUSER(), Database.getPASSWORD());
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (name, username, password, roleId) VALUES (?, ?, ?, ?)")) {

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setInt(4, user.getRole());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
