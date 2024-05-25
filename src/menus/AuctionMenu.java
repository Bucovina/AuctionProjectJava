package menus;

import classes.Auction;
import services.AuctionService;
import services.GenericService;
import services.ItemService;

import java.util.Scanner;

public class AuctionMenu extends Menu{

    private static AuctionMenu menu = null;
    ItemService itemService = GenericService.getInstance(ItemService.class);
    AuctionService auctionService = GenericService.getInstance(AuctionService.class);
    private AuctionMenu() {

    }

    public static synchronized AuctionMenu getInstance() {
        if (menu == null) {
            menu = new AuctionMenu();
        }
        return menu;
    }

    public void addAuction(){
        System.out.println("----------------- Add Auction Menu -----------------");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter auction title: ");
        String title = in.nextLine();
        System.out.print("Enter auction description: ");
        String description = in.nextLine();
        System.out.print("Enter auction start price: ");
        int startPrice = Integer.parseInt(in.nextLine());
        System.out.print("Your items are : ");
        //itemService.
        System.out.print("Choose the item id you would like to create an auction for : ");
        int itemId = Integer.parseInt(in.nextLine());
        Auction auction = new Auction(title, description, itemId, Menu.getCurrentUser().getId(), startPrice);
        auctionService.addAuction(auction);
        }

    public void printMenu() {
        System.out.println("----------------- Auctions Menu -----------------");
        System.out.println("1. Add auction");
        System.out.println("2. List auctions");
        System.out.println("3. Start an auction");
        System.out.println("0. Exit");
    }

    public void handleOption(int option) {
        switch (option) {
            case 1:
                addAuction();
                break;
            case 2:
                //auctionList();
                break;
            case 3:
                //auctionStart();
                break;
            case 4:
                inside = false;
                MainMenu.inside = true;
                break;
            default:
                System.out.println("Invalid option");
        }
    }
}
