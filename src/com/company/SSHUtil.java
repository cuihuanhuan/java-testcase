package com.company;

import java.io.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import com.company.FileUtil;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import static java.lang.Thread.*;

public class SSHUtil {
    public void connect() throws IOException, InterruptedException, SQLException {
        String hostname = "192.168.90.1"; //远程IP
        int port = 22;//22 usually the default port //远程SSH端口，默认可以不填
        String username = "root"; //远程服务器用户名
        String password = "12345"; //远程服务器密码
        String srcDB = "jdbc:oracle:thin:@//192.168.90.1:1521/orclpdb";
        String tgtDB = "jdbc:oracle:thin:@//192.168.90.2:1521/orclpdb";
        DBUtil dbUtil = new DBUtil();
        BufferedWriter out = null;
        //指明连接主机的IP地址
        //         Connection conn = new Connection(hostname,port); //也可以使用new Connection(hostname)直接链接
        //
        //         conn.connect(); // 连接
        //         conn.authenticateWithPassword(username,password); //进行用户认证，返回值为true(成功),false(失败)

        //         Session see = conn.openSession(); //可以用来执行命令行指令等
        //         see.execCommand("/root/Desktop/i2active/bin/iadebug track --state 596A15A1-3607-0838-8746-38699D26A04A"); //执行命令，多个命令间用";"分隔
        //         //打印控制台返回信息
        //         InputStream is = new StreamGobbler(see.getStdout());
        //             BufferedReader brs = new BufferedReader(new InputStreamReader(is));
        //             //这里存在一个问题，没有退出while
        //             while (true){
        //             String line = brs.readLine();
        //             if (line == null){
        //                 System.out.println("over");
        //                 break;
        //
        //             }
        //             System.out.println(line);
        //         }

        //使用完毕后记得释放连接
        //         brs.close();

        FileUtil fu = new FileUtil();
        ArrayList lst = fu.readDir("/Users/chh/Desktop/error_case/");
        //System.out.println(lst);
        //以下来模仿命令行进行交互
        for (int i = 0; i < lst.size(); i++) {

            //System.out.println(lst.get(i));
            Connection conn = new Connection(hostname, port); //也可以使用new Connection(hostname)直接链接

            conn.connect(); // 连接
            conn.authenticateWithPassword(username, password); //进行用户认证，返回值为true(成功),false(失败)
            Date date = new Date();
            //这个方法也是需要导包的
            //注意第二个mm要大写,不然月份会有错误
            out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("/Users/chh/Desktop/incre/ret.txt", true)));
            SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
            System.out.println(sdf.format(date));
            out.write(sdf.format(date) + "\r\n");
            String shellStr = "cd;source .bash_profile;sqlplus huan1/12345@192.168.90.1/orclpdb @/allcases_incre/" + lst.get(i).toString();
            System.out.println(shellStr);
            out.write(shellStr + "\r\n");
            Session session = conn.openSession(); //可以用来执行命令行指令等
            session.execCommand(shellStr); //执行命令，多个命令间用";"分隔
            Thread.sleep(30000);
            String tgtfile = lst.get(i).toString().replace("src", "tgt");
            System.out.println("/Users/chh/Desktop/error_case/" + tgtfile);
            ArrayList<String> stringArrayList = FileUtil.readFromTextFile("/Users/chh/Desktop/error_case/" + tgtfile);

            for (int j = 0; j < stringArrayList.size(); j++) {
                dbUtil.db(srcDB);
                System.out.println(stringArrayList.get(j).toString().trim());
                out.write(stringArrayList.get(j).toString().trim() + "\r\n");
                List srcList = dbUtil.select(stringArrayList.get(j));
                System.out.println(srcList);
                out.write(srcList.toString() + "\r\n");
                dbUtil.db(tgtDB);
                List tgtList = dbUtil.select(stringArrayList.get(j));
                System.out.println(tgtList);
                out.write(tgtList.toString() + "\r\n");
                if (srcList.equals(tgtList)) {
                    System.out.println("PASS");
                    out.write("PASS" + "\r\n");
                } else {
                    System.out.println("FAIL");
                    out.write("FAIL" + "\r\n");
                }
            }
            out.close();
            FileUtil.delete("/Users/chh/Desktop/error_case/" + lst.get(i).toString());
            FileUtil.delete("/Users/chh/Desktop/error_case/" + tgtfile);


        }


        //打印控制台返回信息
        //         InputStream is = new StreamGobbler(session.getStdout());
        //             BufferedReader brs = new BufferedReader(new InputStreamReader(is));
        //             //这里存在一个问题，没有退出while
        //             while (true){
        //             String line = brs.readLine();
        //             if (line == null){
        //                 System.out.println("over");
        //                 break;
        //
        //             }
        //             System.out.println(line);
        //         }
        //
        //        //使用完毕后记得释放连接
        //         brs.close();
        //         session.close();
        //         conn.close();

    }

}
