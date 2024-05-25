package menus;

import services.GenericService;
import services.UserService;
import classes.User;
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

    public void logIn(String username, String  password){
        User user = userService.Auth(username,password);
        if(user == null){
            printMenu();
        }
        else {
            Menu.setCurrentUser(user);
        }

    }

    @Override
    public void printMenu() {
        System.out.println("----------------- Login Menu -----------------");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = in.nextLine();
        System.out.print("Enter password: ");
        String password = in.nextLine();
        logIn(username, password);
    }

    @Override
    public void handleMenu(int option) {

    }
}
