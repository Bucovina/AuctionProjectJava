package services;

import classes.Bid;
import classes.Database;
import classes.User;
import menus.Menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BidService {
    public void addBid(Bid bid) {
        try (Connection connection = DriverManager.getConnection(Database.getURL(), Database.getUSER(), Database.getPASSWORD());
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Bids (price, bidderId) VALUES (?, ?)")) {

            preparedStatement.setInt(1, bid.getPrice());
            preparedStatement.setInt(2, Menu.getCurrentUser().getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //public bool validatePrice()
}
