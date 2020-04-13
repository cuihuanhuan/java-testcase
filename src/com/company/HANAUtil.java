package com.company;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class HANAUtil {

    public List getConnection() throws ClassNotFoundException, SQLException {

            Class.forName("com.sap.db.jdbc.Driver");
            String url ="jdbc:sap://192.168.100.20:39015?reconnect=true"; //IP Address of HANAsystem followed by Port number
            String user ="HUAN3";
            String password = "Info2soft";
            Connection cn = java.sql.DriverManager.getConnection(url, user, password);
            //ResultSet rs = cn.createStatement().executeQuery("SELECT DATABASE_NAME FROM SYS.M_DATABASES");
            ResultSet rs = cn.createStatement().executeQuery("select * from dds_time");
            ResultSetMetaData md = rs.getMetaData();
            int columnCount = md.getColumnCount();//获取行的数量
            List list = new ArrayList();
            while (rs.next()) {
                //Map rowData = new HashMap();//声明Map
                List ls = new ArrayList();
                for (int i = 1; i <= columnCount; i++) {
                    //rowData.put(md.getColumnName(i), rs.getObject(i));//获取键名及值
                    //rowData.put(md.getColumnName(i), rs.getString(i));
                    ls.add(rs.getString(i));
                    //System.out.println(rs.getString(i));

                }
                list.add(ls);
            }

            return list;


    }
}
