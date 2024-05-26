package menus;

import classes.User;

import java.util.Scanner;

public abstract class Menu implements IMenu {
    public static boolean inside = false;

    protected static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        Menu.currentUser = currentUser;
    }

    public void handleMenu(int option) {
        handleOption(option);
    }

    public static void handleSubmenu(Menu menu) {
        menu.inside = true;
        menu.printMenu();
        while (menu.inside) {
            Scanner scanner = new Scanner(System.in);
            menu.handleMenu(scanner.nextInt());
        }
    }

    public abstract void handleOption(int option);
}
