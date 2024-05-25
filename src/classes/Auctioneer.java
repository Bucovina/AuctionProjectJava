package classes;

import java.util.Date;

public class Auctioneer extends User {

    public Auctioneer(int id, String name, Date birthDate) {
        super(name, birthDate);
    }

    public void createAuction(String title, String description, Item item, int startPrice){
        Auction newAuction = new Auction(title,description,item.getId(),this.getId(),startPrice);
    }
}
