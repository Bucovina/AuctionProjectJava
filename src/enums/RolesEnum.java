package enums;

public enum RolesEnum {
    Auctioneer(1),
    Bidder(2);

    private final int value;

    private RolesEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
