package classes;

import java.util.ArrayList;
import java.util.List;

abstract public class User {
    private int Id;
    private String name;
    private String password;
    private String username;
    private int role;
    private int gender;
    private List<Item> ownedItems = new ArrayList<>();

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

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

    public User(String name, String password, String username, int role, int gender) {
        this.name = name;
        this.password = password;
        this.username = username;
        this.role = role;
        this.gender = gender;
    }

    public User(int Id, String name, String password, String username, int role, int gender) {
        this.Id = Id;
        this.name = name;
        this.password = password;
        this.username = username;
        this.role = role;
        this.gender = gender;
    }

    public int getRole() {
        return role;
    }

    public List<Item> getOwnedItems() {
        return ownedItems;
    }

    public void addItem(Item item) {
        this.ownedItems.add(item);
    }

    public void eraseItem(Item item) {
        this.ownedItems.remove(item);
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
