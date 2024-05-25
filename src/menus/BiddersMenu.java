package menus;

public class BiddersMenu extends Menu {

        private static BiddersMenu menu = null;

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

        public void handleOption(int option) {
            switch (option) {
                case 1:
                    //bidderAdd();
                    break;
                case 2:
                    //bidderList();
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
}
