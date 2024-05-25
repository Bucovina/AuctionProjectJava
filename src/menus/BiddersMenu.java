package menus;

import classes.Bid;
import services.AuctionService;
import services.BidService;
import services.GenericService;

import java.util.Scanner;

public class BiddersMenu extends Menu {

        private static BiddersMenu menu = null;
        BidService bidService = GenericService.getInstance(BidService.class);
        private BiddersMenu() {

        }

        public static synchronized BiddersMenu getInstance() {
            if (menu == null) {
                menu = new BiddersMenu();
            }
            return menu;
        }

        public void printMenu() {
            System.out.println("----------------- Bidders Menu -----------------");
            System.out.println("1. Add bidder");
            System.out.println("2. List bidders");
            System.out.println("0. Exit");
        }

        public void addBid(){
            System.out.println("----------------- Add Bid Menu -----------------");
            Scanner in = new Scanner(System.in);
            System.out.print("Enter bid price: ");
            int price = Integer.parseInt(in.nextLine());
            //bidService
            bidService.addBid(new Bid(price, Menu.getCurrentUser().getId()));
        }

        public void handleOption(int option) {
            switch (option) {
                case 1:
                    addBid();
                    break;
                case 2:
                    //bidderList();
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
}
