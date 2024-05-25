package classes;

public class Bid {
    private int Id;
    private int price;
    private int bidderId;

    public Bid(int price, int bidderId) {
        this.price = price;
        this.bidderId = bidderId;
    }

    public Bid(int Id, int price, int bidderId) {
        this.Id = Id;
        this.price = price;
        this.bidderId = bidderId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBidderId() {
        return bidderId;
    }

    public void setBidderId(int bidderId) {
        this.bidderId = bidderId;
    }
}
