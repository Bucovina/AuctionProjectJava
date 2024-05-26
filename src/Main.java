import menus.LoginRegister;
import menus.Menu;
import services.GenericService;
import services.ItemService;
import services.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserService userService = GenericService.getInstance(UserService.class);
        ItemService itemService = GenericService.getInstance(ItemService.class);

        LoginRegister loginRegister = LoginRegister.getInstance();
        Menu.handleSubmenu(loginRegister);
    }
}