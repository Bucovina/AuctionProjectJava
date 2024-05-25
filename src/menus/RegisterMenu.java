package menus;

import classes.Auctioneer;
import classes.Bidder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class RegisterMenu implements IMenu{

    private static RegisterMenu registerMenu = null;

    public static boolean inside = false;

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
            Auctioneer auctioneer = new Auctioneer(name, password, username);
       }
       else if(role == 2) {
           Bidder bidder = new Bidder(name, password, username);
       }
        //TODO else {}

        System.out.print("Press any key to submit and save");

        //TODO saveUser()
    }

    @Override
    public void handleMenu(int option) {

    }
}
