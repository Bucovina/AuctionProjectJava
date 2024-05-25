package classes;

import java.sql.*;

public class Database {
    private static String URL = "jdbc:mysql://localhost:3306/auctionproject";
    private static String USER = "root";
    private static String PASSWORD = "root";
    private static Database instance;

    private Database() {
    }

    public static String getURL() {
        return URL;
    }

    public static String getUSER() {
        return USER;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }


}
