package enums;

public enum GendersEnum {
    Male(1),
    Female(2);

    private final int value;

    private GendersEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
