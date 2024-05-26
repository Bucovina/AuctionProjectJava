package services;

import classes.*;
import enums.RolesEnum;
import menus.Menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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



    public List<User> getUsers() {
        List<User> users = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(Database.getURL(), Database.getUSER(), Database.getPASSWORD());
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Users");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                String username = resultSet.getString("Username");
                String password = resultSet.getString("Password");
                int role = resultSet.getInt("RoleId");
                User user;
                if (role == RolesEnum.Auctioneer.getValue())
                    user = new Auctioneer(name, username, password);
                else
                    user = new Bidder(name, username, password);
                users.add(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

    public User Auth(String username, String password) {
        try (Connection connection = DriverManager.getConnection(Database.getURL(), Database.getUSER(), Database.getPASSWORD());
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Users WHERE Username = ? AND Password = ?")) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int id=resultSet.getInt("Id");
                String name = resultSet.getString("Name");
                int role = resultSet.getInt("RoleId");
                if(role==RolesEnum.Auctioneer.getValue())
                    return new Auctioneer(id,name, username, password);
                else
                    return new Bidder(id,name, username, password);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public User getUserById(int id) {
        try (Connection connection = DriverManager.getConnection(Database.getURL(), Database.getUSER(), Database.getPASSWORD());
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE Id = ?")) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("Name");
                String username = resultSet.getString("Username");
                String password = resultSet.getString("Password");
                int role = resultSet.getInt("RoleId");
                if(role==RolesEnum.Auctioneer.getValue())
                    return new Auctioneer(id,name, username, password);
                else
                    return new Bidder(id,name, username, password);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }



    public User getSuperBidder() {
        try (Connection connection = DriverManager.getConnection(Database.getURL(), Database.getUSER(), Database.getPASSWORD());
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE RoleId = ? AND Id != ?")) {

            preparedStatement.setInt(1, RolesEnum.Bidder.getValue());
            preparedStatement.setInt(2, Menu.getCurrentUser().getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("Name");
                String username = resultSet.getString("Username");
                String password = resultSet.getString("Password");
                int id = resultSet.getInt("Id");
                return new Bidder(id,name, username, password);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
