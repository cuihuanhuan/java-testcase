package com.company;

import java.io.*;
import java.util.ArrayList;

public class FileUtil {
    public ArrayList<String> readFromTextFile(String pathname) throws IOException {
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
                                strArray.add(line);
                                line = br.readLine();

        }
        return strArray;
    }
}

