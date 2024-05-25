package menus;

public class ItemsMenu extends Menu{
    private static ItemsMenu menu = null;

    private ItemsMenu() {

    }

    public static synchronized ItemsMenu getInstance() {
        if (menu == null) {
            menu = new ItemsMenu();
        }
        return menu;
    }

    public void printMenu() {
        System.out.println("----------------- Items Menu -----------------");
        System.out.println("1. Add item");
        System.out.println("2. List items");
        System.out.println("0. Exit");
    }

    public void handleOption(int option) {
        switch (option) {
            case 1:
                //itemAdd();
                break;
            case 2:
                //itemList();
                break;
            case 3:
                inside = false;
                MainMenu.inside = true;
                break;
            default:
                System.out.println("Invalid option");
        }
    }



}
