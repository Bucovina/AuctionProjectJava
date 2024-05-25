package menus;

import classes.User;

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
        switch (option) {
            case 0:
                inside = false;
                MainMenu.inside = true;
                break;
            default:
                handleOption(option);
        }
    }

    public abstract void handleOption(int option);
}
