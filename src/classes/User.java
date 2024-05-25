package classes;

import java.util.ArrayList;
import java.util.List;

  abstract public class User {
    private int Id;
    private String name;
    private String password;
    private String username;
    private int Role;
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
        this.Role = role;
    }

    public List<Item> getOwnedItems() {
        return ownedItems;
    }

    public void setOwnedItems(List<Item> ownedItems) {
        this.ownedItems = ownedItems;
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
