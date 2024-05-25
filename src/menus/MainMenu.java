package menus;

import java.util.Scanner;

public class MainMenu implements IMenu {
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
        System.out.println("Hello, " + role + " " + name);
        System.out.println("1. Auctions");
        System.out.println("2. Items");
        System.out.println("0. Exit");
    }

    public void handleSubmenu(Menu menu) {
        menu.printMenu();
        inside = false;
        Menu.inside = true;
        while (Menu.inside) {
            Scanner scanner = new Scanner(System.in);
            menu.handleMenu(scanner.nextInt());
        }
    }

    public void handleMenu(int option) {
        switch (option) {
            case 1:
//                printAuctionsMenu();
                AuctionMenu auctionMenu = AuctionMenu.getInstance();
                handleSubmenu(auctionMenu);
                break;
            case 2:
//                printItemsMenu();
                ItemsMenu itemsMenu = ItemsMenu.getInstance();
                itemsMenu.printMenu();
                inside = false;
                ItemsMenu.inside = true;
                while (ItemsMenu.inside) {
                    Scanner scanner = new Scanner(System.in);
                    itemsMenu.handleMenu(scanner.nextInt());
                }
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option");
        }
    }

}
