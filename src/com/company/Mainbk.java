package com.company;

public class Mainbk {

    public static void main(String[] args) {
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
//                List ret = dbUtil.select(list.get(i).toString());
//                System.out.println(ret);
//            }
//        }catch (Exception e){
//            System.out.println(e);
//        }
    }


}

