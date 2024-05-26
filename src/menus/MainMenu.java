package menus;

import java.util.Scanner;

public class MainMenu extends Menu {
    private static MainMenu menu = null;

    public static boolean inside = false;

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
        String role = Menu.getCurrentUser().getRole() == 1 ? "Auctioneer" : "Bidder";
        System.out.println("Hello, " + role + " " + Menu.getCurrentUser().getName() + "!!");
        System.out.println("1. Auctions");
        System.out.println("2. Items");
        System.out.println("3. Return to Login/Register");
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
            case 3:
                LoginRegister loginRegister = LoginRegister.getInstance();
                Menu.setCurrentUser(null);
                Menu.handleSubmenu(loginRegister);
                break;
            case 0:
                System.out.println("Goodbye!");
                System.exit(0);
            default:
                System.out.println("Invalid option");
        }
    }

    @Override
    public void handleOption(int option) {

    }

}
