package classes;

import enums.GendersEnum;
import enums.RolesEnum;

import java.security.InvalidParameterException;

public class Auctioneer extends User {

    public Auctioneer(String name, String password, String username, int gender) {
        super(name, password, username, RolesEnum.Auctioneer.getValue(), gender);
    }

    public Auctioneer(int Id,String name, String password, String username, int gender) {
        super(Id,name, password, username, RolesEnum.Auctioneer.getValue(), gender);
    }

}
