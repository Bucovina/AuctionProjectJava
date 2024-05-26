package services;

import classes.*;
import enums.RolesEnum;
import menus.Menu;

import java.sql.*;

public class BidService {
    public void addBid(Bid bid) {
        try (Connection connection = DriverManager.getConnection(Database.getURL(), Database.getUSER(), Database.getPASSWORD());
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Bids (price, bidderId) VALUES (?, ?)")) {

            preparedStatement.setInt(1, bid.getPrice());
            preparedStatement.setInt(2, bid.getBidderId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Bid getBid(int id) {
        try (Connection connection = DriverManager.getConnection(Database.getURL(), Database.getUSER(), Database.getPASSWORD());
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM bids WHERE Id = ?")) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int price = resultSet.getInt("Price");
                int bidderId = resultSet.getInt("BidderID");
                return new Bid(id,price, bidderId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
