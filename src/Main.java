import menus.LoginRegister;
import menus.Menu;

public class Main {
    public static void main(String[] args) {
        LoginRegister loginRegister = LoginRegister.getInstance();
        Menu.handleSubmenu(loginRegister);
    }
}