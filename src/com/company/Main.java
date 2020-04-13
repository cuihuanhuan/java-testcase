package com.company;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        FileUtil util = new FileUtil();
        ArrayList arr  = util.readDir("/Users/chh/Desktop/allcases_incre");
        System.out.println(arr);

//        HANAUtil hanaUtil = new HANAUtil();
//        hanaUtil.getConnection();
//        List ret = hanaUtil.getConnection();
//        System.out.println(ret);
//
//        DBUtil dbUtil = new DBUtil();
//        List oraret  = dbUtil.select("select * from dds_time");
//        System.out.println(oraret);
//        SSHUtil ssh = new SSHUtil();
//        try {
//            ssh.connect();
//        }catch (Exception e){
//
//        }
//        DBUtil dbUtil = new DBUtil();
//
//        FileUtil fileUtil = new FileUtil();
//        String path = "/Users/chh/Desktop/allcases_incre/80_00_0_2_43_tgt.sql";
//        try {
//            ArrayList list =  fileUtil.readFromTextFile(path);
//
//            for(int i=0;i<list.size();i++){
//                List ret = dbUtil.select(list.get(i).toString());
//                System.out.println(ret);
//            }
//        }catch (Exception e){
//            System.out.println(e);
//        }
    }


}

