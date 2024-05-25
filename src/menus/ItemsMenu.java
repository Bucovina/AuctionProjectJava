package menus;

import classes.Item;
import services.GenericService;
import services.ItemService;
import services.UserService;

import java.util.Scanner;

public class ItemsMenu extends Menu{
    private static ItemsMenu menu = null;

    ItemService itemService = GenericService.getInstance(ItemService.class);

    private ItemsMenu() {

    }

    public static synchronized ItemsMenu getInstance() {
        if (menu == null) {
            menu = new ItemsMenu();
        }
        return menu;
    }

    public void printMenu() {
        System.out.println("----------------- Items Menu -----------------");
        System.out.println("1. Add item");
        System.out.println("2. List items");
        System.out.println("0. Exit");
    }

    public void addItem(){
        System.out.println("----------------- Add Item Menu -----------------");
        Scanner in = new Scanner(System.in);
        System.out.println("Item name : ");
        String name = in.nextLine();
        System.out.println("Item description : ");
        String description = in.nextLine();
        itemService.addItem(new Item(name, description));
    }


    public void handleOption(int option) {
        switch (option) {
            case 1:
                addItem();
                break;
            case 2:
                //itemList();
                break;
            case 3:
                inside = false;
                MainMenu.inside = true;
                break;
            default:
                System.out.println("Invalid option");
        }
    }



}
