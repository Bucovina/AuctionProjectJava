package classes;


import services.GenericService;
import services.ItemService;

public class Auction {
    private int Id;
    private String title;
    private String description;
    private Item item;
    private Auctioneer auctioneer;
    private int startPrice;
    private Bid highestBid = null;
    ItemService itemService = GenericService.getInstance(ItemService.class);


    public int getStartPrice() {
        return startPrice;
    }

    public int getId() {
        return Id;
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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Auction(String title, String description, Item item, Auctioneer auctioneer, int startPrice) {
        this.title = title;
        this.description = description;
        this.startPrice = startPrice;
        this.item = item;
        this.auctioneer = auctioneer;
    }

    public Auction(int Id,String title, String description, Item item, Auctioneer auctioneer, int startPrice, Bid highestBid) {
        this.Id = Id;
        this.title = title;
        this.description = description;
        this.item = item;
        this.auctioneer = auctioneer;
        this.startPrice = startPrice;
        this.highestBid = highestBid;
    }

    public Auctioneer getAuctioneer() {
        return auctioneer;
    }

    public void setAuctioneer(Auctioneer auctioneer) {
        this.auctioneer = auctioneer;
    }

    @Override
    public String toString() {
        int highestBidPrice = (highestBid != null) ? highestBid.getPrice() : 0;

        return "Auction {" +
                "Title='" + title + '\'' +
                ", Description='" + description + '\'' +
                ", Item=" +  getItem().getName() + '\'' +
                ", Auctioneer=" + getAuctioneer().getName() + '\'' +
                ", Start Price=" + startPrice +
                ", Highest Bid=" + highestBidPrice +
                '}';
    }
}
