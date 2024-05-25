package classes;

public class Item {
    private static int nrInstances = 0;
    private int Id;
    private String name;
    private String description;

    public int getId() {
        return Id;
    }

    public Item(String name, String description) {
        this.Id = ++nrInstances;
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
}
