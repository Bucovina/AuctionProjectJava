package classes;

public class Bid {
    static private int nrInstances = 0;
    private int Id;
    private int price;
    private int bidderId;

    public Bid(int price, int bidderId) {
        this.Id = ++nrInstances;
        this.price = price;
        this.bidderId = bidderId;
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
