package com.company;

import java.util.ArrayList;
import java.util.List;

public class DBUtilTest {
    public static void main(String[] args) {
        DBUtil dbUtil = new DBUtil();
        try{
            List list = new ArrayList();
            list = dbUtil.select("select * from dds_rowid");
            System.out.println(list);
        }catch (Exception e) {

        }

    }

}
