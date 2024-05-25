package services;

import classes.Auction;
import classes.Database;
import menus.Menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuctionService {
    public void addAuction(Auction auction) {
        try (Connection connection = DriverManager.getConnection(Database.getURL(), Database.getUSER(), Database.getPASSWORD());
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO auction (title, description, itemId, auctioneerId, startPrice) VALUES (?, ?, ?, ?, ?)")) {

            preparedStatement.setString(1, auction.getTitle());
            preparedStatement.setString(2, auction.getDescription());
            preparedStatement.setInt(3, auction.getItemId());
            preparedStatement.setInt(4, Menu.getCurrentUser().getId());
            preparedStatement.setInt(5, auction.getStartPrice());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
