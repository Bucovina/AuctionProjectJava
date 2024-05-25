package classes;

import java.util.ArrayList;
import java.util.List;


public class Auction {
    private int Id;
    private String Title;
    private String Description;
    private int itemId;
    private int auctioneerId;
    private int startPrice;
    private Bid highestBid = null;

    public int getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(int startPrice) {
        this.startPrice = startPrice;
    }

    public Bid getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(Bid highestBid) {
        this.highestBid = highestBid;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public Auction(String title, String description, int itemId, int auctioneerId, int startPrice) {
        this.Title = title;
        this.Description = description;
        this.startPrice = startPrice;
        this.itemId = itemId;
        this.auctioneerId = auctioneerId;
    }

    public int getAuctioneerId() {
        return auctioneerId;
    }

    public void setAuctioneerId(int auctioneerId) {
        this.auctioneerId = auctioneerId;
    }
}
