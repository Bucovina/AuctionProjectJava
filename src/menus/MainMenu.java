package menus;

import java.util.Scanner;

public class MainMenu extends Menu {
    private static MainMenu menu = null;

    public static boolean inside = false;

    String name = Menu.getCurrentUser().getName();
    int roleid = Menu.getCurrentUser().getRole();

    private MainMenu() {

    }

    public static synchronized MainMenu getInstance() {
        if (menu == null) {
            menu = new MainMenu();
        }
        return menu;
    }

    public void printMenu() {
        System.out.println("\n----------------- Main Menu -----------------");
        String role = roleid == 1 ? "Auctioneer" : "Bidder";
        System.out.println("Hello, " + role + " " + name + "!!");
        System.out.println("1. Auctions");
        System.out.println("2. Items");
        System.out.println("0. Exit");
    }

    public void handleMenu(int option) {
        switch (option) {
            case 1:
                AuctionMenu auctionMenu = AuctionMenu.getInstance();
                Menu.handleSubmenu(auctionMenu);
                break;
            case 2:
                ItemsMenu itemsMenu = ItemsMenu.getInstance();
                Menu.handleSubmenu(itemsMenu);
                break;
            case 0:
                LoginRegister loginRegister = LoginRegister.getInstance();
                Menu.handleSubmenu(loginRegister);
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    @Override
    public void handleOption(int option) {

    }

}
