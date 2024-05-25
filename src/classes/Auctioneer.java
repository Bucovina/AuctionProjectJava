package classes;

import java.security.InvalidParameterException;
import java.util.Date;

public class Auctioneer extends User {

    public Auctioneer(int id, String name, Date birthDate) {
        super(name, birthDate);
    }

    public void createAuction(String title, String description, Item item, int startPrice){
        if(!this.getOwnedItems().contains(item))
            throw new InvalidParameterException("You can't auction an item that you don't own!");
        Auction newAuction = new Auction(title,description,item.getId(),this.getId(),startPrice);
    }
}
