package menus;

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
        System.out.println("0. Exit");
    }

    public void handleMenu(int option){
        switch(option){
            case 1:
//                printAuctionsMenu();
                AuctionMenu auctionMenu = AuctionMenu.getInstance();
                auctionMenu.printMenu();
                inside = false;
                AuctionMenu.inside = true;
                while(AuctionMenu.inside){
                    Scanner scanner = new Scanner(System.in);
                    auctionMenu.handleMenu(scanner.nextInt());
                }
                break;
            case 2:
//                printBiddersMenu();
                BiddersMenu biddersMenu = BiddersMenu.getInstance();
                biddersMenu.printMenu();
                inside = false;
                BiddersMenu.inside = true;
                while(BiddersMenu.inside){
                    Scanner scanner = new Scanner(System.in);
                    biddersMenu.handleMenu(scanner.nextInt());
                }
                break;
            case 3:
//                printItemsMenu();
                ItemsMenu itemsMenu = ItemsMenu.getInstance();
                itemsMenu.printMenu();
                inside = false;
                ItemsMenu.inside = true;
                while(ItemsMenu.inside){
                    Scanner scanner = new Scanner(System.in);
                    itemsMenu.handleMenu(scanner.nextInt());
                }
                break;
            case 4:
//                printAuctioneersMenu();
                AuctioneersMenu auctioneersMenu = AuctioneersMenu.getInstance();
                auctioneersMenu.printMenu();
                inside = false;
                AuctioneersMenu.inside = true;
                while(AuctioneersMenu.inside){
                    Scanner scanner = new Scanner(System.in);
                    auctioneersMenu.handleMenu(scanner.nextInt());
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
