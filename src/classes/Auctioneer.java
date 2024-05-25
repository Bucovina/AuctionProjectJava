package classes;

import enums.RolesEnum;

import java.security.InvalidParameterException;

public class Auctioneer extends User {

    public Auctioneer(String name, String password, String username) {
        super(name, password, username, RolesEnum.Auctioneer.getValue());
    }

    public void createAuction(String title, String description, Item item, int startPrice){
        if(!this.getOwnedItems().contains(item))
            throw new InvalidParameterException("You can't auction an item that you don't own!");
        Auction newAuction = new Auction(title,description,item.getId(),this.getId(),startPrice);
    }
}
