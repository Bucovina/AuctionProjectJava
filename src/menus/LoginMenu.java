package menus;

import services.GenericService;
import services.UserService;

import java.util.Scanner;


public class LoginMenu implements IMenu{

    private static LoginMenu loginMenu = null;

    public static boolean inside = false;

    UserService userService = GenericService.getInstance(UserService.class);

    private LoginMenu() {}

    public static synchronized LoginMenu getInstance() {
        if(loginMenu == null) {
            loginMenu = new LoginMenu();
        }
        return loginMenu;
    }

    @Override
    public void printMenu() {
        System.out.println("----------------- Login Menu -----------------");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = in.nextLine();
        System.out.print("Enter password: ");
        String password = in.nextLine();
        Menu.setCurrentUser(userService.Auth(username,password));
    }

    @Override
    public void handleMenu(int option) {

    }
}
