package services;

import classes.Bid;
import classes.Database;
import classes.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BidService {
    public void addBid(Bid bid) {
        try (Connection connection = DriverManager.getConnection(Database.getURL(), Database.getUSER(), Database.getPASSWORD());
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Bids (price, bidderId) VALUES (?, ?)")) {

            preparedStatement.setInt(1, bid.getPrice());
//            preparedStatement.setString(2, );
//            preparedStatement.setString(3, user.getPassword());
//            preparedStatement.setInt(4, user.getRole());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
