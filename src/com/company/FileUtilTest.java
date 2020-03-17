package com.company;

import java.util.ArrayList;
import java.util.List;

public class FileUtilTest {
    public static void main(String[] args) {

        FileUtil fileUtil = new FileUtil();
        String path = "/Users/chh/Desktop/allcases_incre/80_00_0_2_43_tgt.sql";
        try {
            ArrayList list =  fileUtil.readFromTextFile(path);
            System.out.println(list);
        }catch (Exception e){

        }



        System.out.println("Hello World!");
    }
}
