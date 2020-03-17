package com.company;

import oracle.jdbc.pool.OracleDataSource;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtilbk {
    public OracleDataSource ods;
    public Connection conn;
    public PreparedStatement pstmt;
    public Statement stmt;
    public ResultSet rset;
    public FileInputStream in;
    public DBUtilbk(){
        try {
            this.db();
        }catch (Exception e){

        }
    }
    public void db()  throws SQLException{
        ods = new OracleDataSource();
        String url = "jdbc:oracle:thin:@//192.168.100.1:1521/orcl";
        ods.setURL(url);
        ods.setUser("HUAN1");
        ods.setPassword("abcde");
        conn = ods.getConnection();
        stmt = conn.createStatement();
    }


    public List  select(String sql) throws SQLException{
        rset = stmt.executeQuery (sql);
        List list = new ArrayList();
        list=convertList(rset);
        return list;
//        rset.close();
//        stmt.close();
    }

    private static List convertList(ResultSet rs) throws SQLException {
        List list = new ArrayList();
        ResultSetMetaData md = rs.getMetaData();//获取键名
        int columnCount = md.getColumnCount();//获取行的数量
        while (rs.next()) {
            Map rowData = new HashMap();//声明Map
            for (int i = 1; i <= columnCount; i++) {
                //rowData.put(md.getColumnName(i), rs.getObject(i));//获取键名及值
                rowData.put(md.getColumnName(i), rs.getString(i));

            }
            list.add(rowData);
        }
        return list;
    }
}
