package classes.menus;

public class AuctionMenu extends Menu{

    private static AuctionMenu menu = null;

    private AuctionMenu() {

    }

    public static synchronized AuctionMenu getInstance() {
        if (menu == null) {
            menu = new AuctionMenu();
        }
        return menu;
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
                //auctionAdd();
                break;
            case 2:
                //auctionList();
                break;
            case 3:
                //auctionStart();
                break;
            default:
                System.out.println("Invalid option");
        }
    }
}
