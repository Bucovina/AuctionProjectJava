package classes;

import java.util.ArrayList;
import java.util.List;

abstract public class User {
    private int Id;
    private String name;
    private String password;
    private String username;
    private int role;
    private List<Item> ownedItems = new ArrayList<Item>();



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User(String name, String password, String username, int role) {
        this.name = name;
        this.password = password;
        this.username = username;
        this.role = role;
    }

    public User(int Id, String name, String password, String username, int role) {
        this.Id = Id;
        this.name = name;
        this.password = password;
        this.username = username;
        this.role = role;
    }

    public int getRole() {
        return role;
    }

    public List<Item> getOwnedItems() {
        return ownedItems;
    }

    public void setOwnedItems(List<Item> ownedItems) {
        this.ownedItems = ownedItems;
    }

    public final int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder("Users: " + "Name: " + name + " Username: " + username + " Role: " + role + " Owned items: ");
        for (Item item : ownedItems) {
            print.append(" ").append(item.toString());
        }
        return print.toString();
    }
}
