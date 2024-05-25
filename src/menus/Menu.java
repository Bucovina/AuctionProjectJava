package menus;

public abstract class Menu implements IMenu {
    public static boolean inside = false;

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
