package classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

abstract public class User {
    static private int nrInstances = 0;
    private int Id;
    private String name;
    private List<Item> ownedItems = new ArrayList<Item>();

    public List<Item> getOwnedItems() {
        return ownedItems;
    }

    public void setOwnedItems(List<Item> ownedItems) {
        this.ownedItems = ownedItems;
    }

    public User(String name, Date birthDate) {
        Id = ++nrInstances;
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
