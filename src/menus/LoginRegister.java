package menus;

import java.util.Scanner;

public class LoginRegister implements IMenu{
    private static LoginRegister loginRegister = null;

    public static boolean inside = false;

    private LoginRegister() {}

    public static synchronized LoginRegister getInstance(){
        if(loginRegister == null){
            loginRegister = new LoginRegister();
        }
        return loginRegister;
    }


    @Override
    public void printMenu() {
        System.out.println("----------------- Login / Register Menu -----------------");
        System.out.println("1. Login");
        System.out.println("2. Register");
    }

    public void printMainMenu(){

        MainMenu mainMenu = MainMenu.getInstance();
        LoginRegister.inside = false;
        MainMenu.inside = true;
        while (MainMenu.inside) {
            mainMenu.printMenu();
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            mainMenu.handleMenu(option);
        }
    }

    @Override
    public void handleMenu(int option) {
        switch(option){
            case 1:
                LoginMenu loginMenu = LoginMenu.getInstance();
                loginMenu.printMenu();
                inside = false;
                LoginMenu.inside = true;
                printMainMenu();
                break;

            case 2:
                RegisterMenu registerMenu = RegisterMenu.getInstance();
                registerMenu.printMenu();
                inside = false;
                RegisterMenu.inside = true;
                printMainMenu();
                break;
        }
    }
}
