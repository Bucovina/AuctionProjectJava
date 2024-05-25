package classes;

import java.util.HashMap;
import java.util.Map;

public class Auction {
    static private int nrInstances = 0;
    private int Id;
    private String Title;
    private String Description;
    private int itemId;
    private int auctioneerId;
    private int startPrice;
    private Bid highestBid = null;
    private Map<Integer, Integer> topPrices = new HashMap<>();

    public Map<Integer, Integer> getTopPrices() {
        return topPrices;
    }

    public void setTopPrices(Map<Integer, Integer> topPrices) {
        this.topPrices = topPrices;
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
        this.Id = ++nrInstances;
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

    public Bid getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(Bid highestBid) {
        this.highestBid = highestBid;
    }
}
