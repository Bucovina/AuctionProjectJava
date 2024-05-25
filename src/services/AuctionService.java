package services;

import classes.*;
import menus.Menu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AuctionService {
    BidService bidService = GenericService.getInstance(BidService.class);
    UserService userService = GenericService.getInstance(UserService.class);
    ItemService itemService = GenericService.getInstance(ItemService.class);


    public void addAuction(Auction auction) {
        try (Connection connection = DriverManager.getConnection(Database.getURL(), Database.getUSER(), Database.getPASSWORD());
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO auctions (title, description, itemId, auctioneerId, startPrice) VALUES (?, ?, ?, ?, ?)")) {

            preparedStatement.setString(1, auction.getTitle());
            preparedStatement.setString(2, auction.getDescription());
            preparedStatement.setInt(3, auction.getItem().getId());
            preparedStatement.setInt(4, auction.getAuctioneer().getId());
            preparedStatement.setInt(5, auction.getStartPrice());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Auction> getAuctions() {
        List<Auction> auctions = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(Database.getURL(), Database.getUSER(), Database.getPASSWORD());
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM auctions")) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String title = resultSet.getString("Title");
                String description = resultSet.getString("Description");
                int itemId = resultSet.getInt("ItemId");
                Item item = itemService.getItemById(itemId);
                int auctioneerId = resultSet.getInt("AuctioneerId");
                Auctioneer auctioneer = (Auctioneer) userService.getUserById(auctioneerId);
                int startPrice = resultSet.getInt("StartPrice");
                int highestBidId = resultSet.getInt("HighestBidId");
                Bid highestBid = bidService.getBid(highestBidId);

                auctions.add(new Auction(id, title, description, item, auctioneer, startPrice, highestBid));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return auctions;
    }

    public void startTimingAuction(Auction auction) {
        long currentTime = System.currentTimeMillis();
        long lastBidtime = System.currentTimeMillis();
        while (System.currentTimeMillis() - currentTime <= 300000) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\nEnter your bid price: ");
            int price = sc.nextInt();
            int highestBidPrice = auction.getHighestBid() != null ? auction.getHighestBid().getPrice() : auction.getStartPrice();
            if (price < highestBidPrice) {
                System.out.println("\nYour bid is lower than the current highest bid. Please enter a higher bid.");
                System.out.println("New bid price is " + auction.getHighestBid().getPrice());
                continue;
            }

            Bid bid = new Bid(price, Menu.getCurrentUser().getId());
            BidService bidService = GenericService.getInstance(BidService.class);
            bidService.addBid(bid);

            int bidId = auction.getHighestBid() != null ? auction.getHighestBid().getId() : -1;
            if (bidId == bid.getId()) {
                auction.setHighestBid(bid);
            }

            if (System.currentTimeMillis() - lastBidtime >= 7000) {
                lastBidtime = System.currentTimeMillis();
                int highprice = auction.getHighestBid() == null ? auction.getStartPrice() : auction.getHighestBid().getPrice();
                Bid util_bid = new Bid(highprice + 50, 1);
                if(util_bid.getPrice() > highprice) {
                    auction.setHighestBid(util_bid);
                    bidService.addBid(util_bid);
                }
            }
            System.out.println("New bid price is " + auction.getHighestBid().getPrice());
        }
        System.out.println("Auction timed out!");
    }

//    public void startAuction(int auctionId) {
//        Auction auction = getAuctionById(auctionId);
//        if (auction == null) {
//            System.out.println("\nAuction not found");
//            return;
//        }
//
//        System.out.println("\nStarting bid from price " + auction.getStartPrice());
//        startTimingAuction(auction);
//
//        System.out.println("\nAuction ended");
//        System.out.println("\nThe highest bid is " + auction.getHighestBid().getPrice() + " from user " + auction.getHighestBid().getBidderId());
//
//    }
}

