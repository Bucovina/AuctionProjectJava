package services;

import classes.*;
import enums.RolesEnum;
import menus.Menu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemService {
    public void addItem(Item item) {
        try (Connection connection = DriverManager.getConnection(Database.getURL(), Database.getUSER(), Database.getPASSWORD());
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO items (name, description, userid) VALUES (?, ?, ?)")) {

            preparedStatement.setString(1, item.getName());
            preparedStatement.setString(2, item.getDescription());
            preparedStatement.setInt(3, Menu.getCurrentUser().getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Item> getUserItems() {
        List<Item> items = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(Database.getURL(), Database.getUSER(), Database.getPASSWORD());
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Items WHERE Userid = ?")) {

            preparedStatement.setInt(1, Menu.getCurrentUser().getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String name = resultSet.getString("Name");
                String description = resultSet.getString("Description");
                items.add(new Item(id,name,description));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return items;
    }

}
