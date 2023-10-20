package org.example.DB;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnecection {

    public void connection() {
        String url = "jdbc:mysql://localhost:3306/a10?serverTimezone=Asia/Seoul&useOldAliasMetadataBehavior=true";

        String user = "root";
        String password = "";
        String driverName = "com.mysql.cj.jdbc.Driver";

        try{
            DriverManager.getConnection(url, user, password);
            Class.forName(driverName);
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
