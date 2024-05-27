package menus;

import classes.Auctioneer;
import classes.Bidder;
import services.GenericService;
import services.UserService;

import java.util.Scanner;

public class RegisterMenu extends Menu {

    private static RegisterMenu registerMenu = null;

    public static boolean inside = false;

    UserService userService = GenericService.getInstance(UserService.class);

    private RegisterMenu() {
    }

    public static synchronized RegisterMenu getInstance() {
        if (registerMenu == null) {
            registerMenu = new RegisterMenu();
        }
        return registerMenu;
    }

    @Override
    public void printMenu() {
        LoginRegister.inside = false;
        RegisterMenu.inside = true;
        System.out.println("----------------- Register Menu -----------------");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter full name : ");
        String name = in.nextLine();
        System.out.print("Enter username: ");
        String username = in.nextLine();
        System.out.print("Enter password: ");
        String password = in.nextLine();
        System.out.print("Choose role : 1. Auctioneer or 2. Bidder");
        int role = Integer.parseInt(in.nextLine());
        System.out.print("Choose role : 1. Male or 2. Female");
        int gender = Integer.parseInt(in.nextLine());
        if (role == 1) {
            Auctioneer auctioneer = new Auctioneer(name, password, username,gender);
            userService.addUser(auctioneer);
            Menu.setCurrentUser(userService.Auth(name, password));

        } else if (role == 2) {
            Bidder bidder = new Bidder(name, password, username, gender);
            userService.addUser(bidder);
            Menu.setCurrentUser(userService.Auth(name, password));
        }
//       LoginRegister.inside = false;
        RegisterMenu.inside = false;
    }

    @Override
    public void handleMenu(int option) {

    }

    @Override
    public void handleOption(int option) {

    }
}
