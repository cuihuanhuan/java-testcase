package com.company;

import oracle.jdbc.pool.OracleDataSource;

import java.sql.*;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;


public class DBUtil {
    public OracleDataSource ods;
    public Connection conn;
    public PreparedStatement pstmt;
    public Statement stmt;
    public ResultSet rset;
    public FileInputStream in;
//    public DBUtil(){
//        try {
//            this.db();
//        }catch (Exception e){
//
//        }
//    }
    public void db(String url)  throws SQLException{
        ods = new OracleDataSource();
        //String url = "jdbc:oracle:thin:@//192.168.90.1:1521/orclpdb";
        ods.setURL(url);
        ods.setUser("HUAN1");
        ods.setPassword("12345");
        conn = ods.getConnection();
        stmt = conn.createStatement();
    }




    public List  select(String sql) {
        List list = new ArrayList();
        try {
            rset = stmt.executeQuery(sql);
            list = convertList(rset);
//        rset.close();
//        stmt.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return list;
    }

    private static List convertList(ResultSet rs) throws SQLException {
        List list = new ArrayList();
        ResultSetMetaData md = rs.getMetaData();//获取键名
        int columnCount = md.getColumnCount();//获取行的数量
        while (rs.next()) {
            //Map rowData = new HashMap();//声明Map
            List ls = new ArrayList();
            for (int i = 1; i <= columnCount; i++) {
                //rowData.put(md.getColumnName(i), rs.getObject(i));//获取键名及值
                //rowData.put(md.getColumnName(i), rs.getString(i));
                try{
                    ls.add(rs.getString(i));
                }catch (Exception e){
                    try{
                        ls.add(rs.getClob(i));
                    }catch (Exception ee){
                        ls.add(rs.getBlob(i));
                    }

                }


            }
            list.add(ls);
        }
        return list;
    }
}
