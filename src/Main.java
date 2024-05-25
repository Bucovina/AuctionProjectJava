import menus.LoginRegister;
import services.GenericService;
import services.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserService userService = GenericService.getInstance(UserService.class);

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