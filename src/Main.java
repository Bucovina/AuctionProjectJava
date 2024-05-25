
import menus.LoginRegister;
import menus.MainMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LoginRegister loginRegister = LoginRegister.getInstance();
        Scanner scanner = new Scanner(System.in);
        LoginRegister.inside = true;
        while (LoginRegister.inside) {
            loginRegister.printMenu();
            int option = scanner.nextInt();
            loginRegister.handleMenu(option);
        }
    }
}