package com.company;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        String srcDB = "jdbc:oracle:thin:@//192.168.90.1:1521/orclpdb";
//        DBUtil dbUtil = new DBUtil();
//        dbUtil.db(srcDB);
//        try {
//            List list = dbUtil.select("select no,dbms_lob.substr(c_blob,10,1) from visible  order by no");
//            System.out.println(list);
//        }catch (Exception e){
//            System.out.println(e);
//        }

        //FileUtil util = new FileUtil();
        //ArrayList arr  = util.readDir("/Users/chh/Desktop/allcases_incre");
        //System.out.println(arr);

//        HANAUtil hanaUtil = new HANAUtil();
//        hanaUtil.getConnection();
//        List ret = hanaUtil.getConnection();
//        System.out.println(ret);
//
//        DBUtil dbUtil = new DBUtil();
//        List oraret  = dbUtil.select("select * from dds_time");
//        System.out.println(oraret);
        SSHUtil ssh = new SSHUtil();
        try {
            ssh.connect();
        }catch (Exception e){

        }
//        DBUtil dbUtil = new DBUtil();
//
//        FileUtil fileUtil = new FileUtil();
//        String path = "/Users/chh/Desktop/allcases_incre/80_00_0_2_43_tgt.sql";
//        try {
//            ArrayList list =  fileUtil.readFromTextFile(path);
//
//            for(int i=0;i<list.size();i++){
//                int bool = list.get(i).toString().indexOf("select");
//                if(bool != -1){
//                    List ret = dbUtil.select(list.get(i).toString());
//                    System.out.println(ret);
//                }else{
////                    System.out.println("字符串str中不包含子串“ab”"+result1);
//                    continue;
//                }
//
//            }
//        }catch (Exception e){
//            System.out.println(e);
//        }
    }


}

