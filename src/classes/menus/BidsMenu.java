package classes.menus;
import classes.Bid;

import java.util.Collection;

public class BidsMenu extends Menu{
    private static BidsMenu menu = null;
    private Collection<Bid> bids;

    private BidsMenu() {

    }

public static synchronized BidsMenu getInstance() {
        if (menu == null) {
            menu = new BidsMenu();
        }
        return menu;
    }

public void printMenu() {
        System.out.println("----------------- Bids Menu -----------------");
        System.out.println("1. Add bid");
        System.out.println("2. List bids");
        System.out.println("0. Exit");
    }

public void handleOption(int option) {
        switch (option) {
            case 1:
                //bidAdd();
                break;
            case 2:
                //bidList();
                break;
            default:
                System.out.println("Invalid option");
        }
    }
}

