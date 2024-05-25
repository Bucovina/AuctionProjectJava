package classes;

import enums.RolesEnum;

import java.security.InvalidParameterException;

public class Auctioneer extends User {

    public Auctioneer(String name, String password, String username) {
        super(name, password, username, RolesEnum.Auctioneer.getValue());
    }

    public Auctioneer(int Id,String name, String password, String username) {
        super(Id,name, password, username, RolesEnum.Auctioneer.getValue());
    }

}
