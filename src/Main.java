
import classes.menus.MainMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MainMenu mainMenu = MainMenu.getInstance();
        Scanner scanner = new Scanner(System.in);
        MainMenu.inside = true;
        while (MainMenu.inside) {
            mainMenu.printMenu();
            int option = scanner.nextInt();
            mainMenu.handleMenu(option);
        }
    }
}