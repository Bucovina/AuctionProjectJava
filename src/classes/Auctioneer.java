package classes;

import java.security.InvalidParameterException;
import java.time.LocalDate;

public class Auctioneer extends User {

    public Auctioneer(String name, String password, String username, int role) {
        super(name, password, username, role);
    }

    public void createAuction(String title, String description, Item item, int startPrice){
        if(!this.getOwnedItems().contains(item))
            throw new InvalidParameterException("You can't auction an item that you don't own!");
        Auction newAuction = new Auction(title,description,item.getId(),this.getId(),startPrice);
    }
}
