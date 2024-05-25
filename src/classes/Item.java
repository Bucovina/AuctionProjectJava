package classes;

public class Item {
    private int Id;
    private String name;
    private String description;

    public int getId() {
        return Id;
    }

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Item(int Id,String name, String description) {
        this.Id = Id;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return name + " " + description;
    }
}
