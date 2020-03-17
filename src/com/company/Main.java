package com.company;




import java.util.ArrayList;
import java.util.List;
public class Main {

    public static void main(String[] args) {
        DBUtil dbUtil = new DBUtil();
        try{
            List list = new ArrayList();
            list = dbUtil.select();
            System.out.println(list);
        }catch (Exception e) {

        }

        System.out.println("Hello World!");
    }


}

