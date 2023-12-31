package org.example;
import org.example.db.DBConnection;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;
@Getter
@Setter
public class Container {
    private static Scanner sc;
    private static DBConnection dbConnection;
    public static void init(){
        sc = new Scanner(System.in);
    }

    public static Scanner getSc() {
        return sc;
    }

    public static void close(){
        sc.close();
    }
    public static DBConnection getDBconnection() {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }
}
