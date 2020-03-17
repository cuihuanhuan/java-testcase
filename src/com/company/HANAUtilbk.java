package com.company;

import java.sql.*;


public class HANAUtilbk {

    public  void getConnection() {
        try {
            Class.forName("com.sap.db.jdbc.Driver");
            String url ="jdbc:sap://192.168.100.20:39015?reconnect=true"; //IP Address of HANAsystem followed by Port number
            String user ="SYSTEM";
            String password = "Info2soft";
            Connection cn = java.sql.DriverManager.getConnection(url, user, password);
            ResultSet rs = cn.createStatement().executeQuery("SELECT DATABASE_NAME FROM SYS.M_DATABASES");

            // ...Enter the action here
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
