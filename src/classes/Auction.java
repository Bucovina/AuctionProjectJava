package classes;


public class Auction {
    private int Id;
    private String title;
    private String description;
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
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public Auction(String title, String description, int itemId, int auctioneerId, int startPrice) {
        this.title = title;
        this.description = description;
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
