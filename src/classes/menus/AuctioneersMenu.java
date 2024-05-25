package classes.menus;

public class AuctioneersMenu extends Menu{

        private static AuctioneersMenu menu = null;

        private AuctioneersMenu() {

        }

        public static synchronized AuctioneersMenu getInstance() {
            if (menu == null) {
                menu = new AuctioneersMenu();
            }
            return menu;
        }

        public void printMenu() {
            System.out.println("----------------- Auctioneers Menu -----------------");
            System.out.println("1. Add auctioneer");
            System.out.println("2. List auctioneers");
            System.out.println("0. Exit");
        }

        public void handleOption(int option) {
            switch (option) {
                case 1:
                    //auctioneerAdd();
                    break;
                case 2:
                    //auctioneerList();
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
}
