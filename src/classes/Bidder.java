package classes;

import Exceptions.InvalidPrice;

public class Bidder extends User {

    public Bidder(String name, String password, String username, int role) {
        super(name, password, username, role);
    }

    public void createNewBid(Auction auction, int price) {
        Bid newBid = new Bid(price, this.getId());
        try {
            if (auction.getHighestBid() == null) {
                if (auction.getStartPrice() > price) {
                    throw new InvalidPrice("The price is too low!");
                }
                auction.setHighestBid(newBid);
            } else if (auction.getHighestBid().getPrice() > price) {
                throw new InvalidPrice("The price is too low!");
            }
            auction.setHighestBid(newBid);
        } catch (InvalidPrice e) {
            System.out.println(e.getMessage());
        }
    }
}
