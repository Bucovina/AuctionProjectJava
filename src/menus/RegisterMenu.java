package menus;

import classes.Auctioneer;
import classes.Bidder;
import classes.Database;
import classes.User;
import enums.RolesEnum;
import services.GenericService;
import services.UserService;

import javax.management.relation.Role;
import java.util.Scanner;

public class RegisterMenu implements IMenu{

    private static RegisterMenu registerMenu = null;

    public static boolean inside = false;

    UserService userService = GenericService.getInstance(UserService.class);

    private Database db = Database.getInstance();

    private RegisterMenu() {}

    public static synchronized RegisterMenu getInstance() {
        if(registerMenu == null) {
            registerMenu = new RegisterMenu();
        }
        return registerMenu;
    }

    @Override
    public void printMenu() {
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

       if(role == 1) {
            RolesEnum userRole = RolesEnum.Auctioneer;
            Auctioneer auctioneer = new Auctioneer(name, password, username);
            userService.addUser(auctioneer);
       }
       else if(role == 2) {
           RolesEnum userRole = RolesEnum.Bidder;
           Bidder bidder = new Bidder(name, password, username);
           userService.addUser(bidder);
       }
        //TODO else {}

        System.out.print("Press any key to submit and save");

        //TODO saveUser()
    }

    @Override
    public void handleMenu(int option) {

    }
}
