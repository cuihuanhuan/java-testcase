package com.company;

import java.io.*;

import java.util.ArrayList;

public class FileUtil {
    public static  ArrayList<String> readFromTextFile(String pathname) throws IOException {
        ArrayList<String> strArray = new ArrayList<String>();
        File filename = new File(pathname);
        InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));
        BufferedReader br = new BufferedReader(reader);
        String line = "";
        line = br.readLine();

        while(line != null) {
            if(line.trim()!="/")
                if(!line.trim().startsWith("spool"))
                    if(!line.trim().startsWith("--"))
                        if (!line.trim().startsWith("/"))
                            if(!line.trim().equals(""))
                                if(!line.trim().equals("rollback"))
                                    if(line.indexOf("for update")!=-1) {
                                        line.replace("for update", " ");
                                        strArray.add(line.replace("for update", " "));
                                    }else{
                                        strArray.add(line);
                                    }
                                     line = br.readLine();


        }
        return strArray;
    }
    public ArrayList readDir(String pathname){
        File file = new File(pathname);		//获取其file对象
        File[] fs = file.listFiles();	//遍历path下的文件和目录，放在File数组中
        ArrayList arr = new ArrayList();
        for(File f:fs){					//遍历File[]数组
            if(!f.isDirectory())		//若非目录(即文件)，则打印
                //System.out.println(f);
                if(f.toString().indexOf("src")!=-1){
                    arr.add(f.toString().substring(30));
                }

                //arr.add(f);
        }
        return arr;
    }
    public static void delete(String path){
        File file = new File(path);
        if (file.exists()) {
            file.delete();
            //System.out.println("文件已经被成功删除");
        }

    }

}

