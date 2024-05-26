package menus;

import classes.Auction;
import classes.Auctioneer;
import classes.Bid;
import classes.Item;
import enums.RolesEnum;
import services.AuctionService;
import services.BidService;
import services.GenericService;
import services.ItemService;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AuctionMenu extends Menu{

    private static AuctionMenu menu = null;
    ItemService itemService = GenericService.getInstance(ItemService.class);
    AuctionService auctionService = GenericService.getInstance(AuctionService.class);
    BidService bidService = GenericService.getInstance(BidService.class);

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
        System.out.print("Your items are : \n");
        List<Item> myItems= itemService.getUserItems();
        int index=0;
        Map<Integer,Item> itemCoversion = new HashMap<>();
        for(Item item:myItems) {
            index++;
            itemCoversion.put(index,item);
            System.out.println(index+". "+item.toString());
        }
        System.out.print("Choose the item id you would like to create an auction for : ");
        int itemId = Integer.parseInt(in.nextLine());
        Item realItem=itemCoversion.get(itemId);

        Auction auction = new Auction(title, description,  realItem, (Auctioneer)Menu.getCurrentUser(), startPrice);
        auctionService.addAuction(auction);
        System.out.printf("\nAuction added successfully. Press any key to get back to menu ... ");
        String ch = in.nextLine();
        printMenu();
        }

    public void printMenu() {
        System.out.println("\n----------------- Auctions Menu -----------------");
        if(Menu.getCurrentUser().getRole() == RolesEnum.Auctioneer.getValue())
            System.out.println("1. Add auction");
        else
            System.out.println("1. Participate in auction");
        System.out.println("2. List auctions");
        System.out.println("0. Exit");
    }

    public void auctionList(){
        System.out.println("\n--------------- Auctions List ----------------");
        List<Auction> auctions = auctionService.getAuctions();
        for(Auction auction:auctions) {
            System.out.println(auction.toString());
        }
        System.out.println("\nPress any key to get back to main menu ... ");
        Scanner in = new Scanner(System.in);
        String ch = in.nextLine();
        printMenu();
    }


    public void participateInAuction(){
        System.out.print("\n--------Auction Participation--------------");
        System.out.print("\nThe auctions are : ");
        Scanner in = new Scanner(System.in);
        List<Auction> auctions = auctionService.getAuctions();
        int index=0;
        Map<Integer,Auction> auctionCoversion = new HashMap<>();
        for(Auction auction:auctions) {
            index++;
            auctionCoversion.put(index,auction);
            System.out.println("\n" + index+". "+auction.toString());
        }
        System.out.print("\nChoose the auction id you would like to participate in : ");
        int auctionId = Integer.parseInt(in.nextLine());
        Auction realauction=auctionCoversion.get(auctionId);
        auctionService.startTimingAuction(realauction);
        Menu.handleSubmenu(AuctionMenu.getInstance());
    }

    public void handleOption(int option) {
        switch (option) {
            case 1:
                if(Menu.getCurrentUser().getRole() == RolesEnum.Auctioneer.getValue())
                    addAuction();
                else
                    participateInAuction();
                break;
            case 2:
                auctionList();
                break;
            case 0:
                inside = false;
                Menu.handleSubmenu(MainMenu.getInstance());
                break;
            default:
                System.out.println("Invalid option");
        }
    }
}
