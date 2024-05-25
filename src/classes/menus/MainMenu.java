package classes.menus;

import java.util.Scanner;

public class MainMenu implements IMenu {
    private static MainMenu menu = null;

    public static boolean inside = false;

    String s = "Gogu";

    private MainMenu (){

    }

    public static synchronized MainMenu getInstance(){
        if(menu == null){
            menu = new MainMenu();
        }
        return menu;
    }

    public void printMenu(){
        System.out.println("----------------- Main Menu -----------------");
        System.out.println("Hello, " + s);
        System.out.println("1. Auctions");
        System.out.println("2. Bidders");
        System.out.println("3. Items");
        System.out.println("4. Auctioneers");
        System.out.println("5. Bids");
        System.out.println("0. Exit");
    }

    public void handleSubmenu(Menu menu){
        menu.printMenu();
        inside = false;
        Menu.inside = true;
        while(Menu.inside){
            Scanner scanner = new Scanner(System.in);
            menu.handleMenu(scanner.nextInt());
        }
    }

    public void handleMenu(int option){
        switch(option){
            case 1:
                AuctionMenu auctionMenu = AuctionMenu.getInstance();
                handleSubmenu(auctionMenu);
                break;
            case 2:
                BiddersMenu biddersMenu = BiddersMenu.getInstance();
                handleSubmenu(biddersMenu);
                break;
            case 3:
                ItemsMenu itemsMenu = ItemsMenu.getInstance();
                handleSubmenu(itemsMenu);
                break;
            case 4:
                AuctioneersMenu auctioneersMenu = AuctioneersMenu.getInstance();
                handleSubmenu(auctioneersMenu);
                break;
            case 5:
                BidsMenu bidsMenu = BidsMenu.getInstance();
                handleSubmenu(bidsMenu);
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option");

        }
    }
}
