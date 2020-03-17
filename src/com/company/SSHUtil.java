package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

public class SSHUtil {
     public void connect() throws IOException {
         String hostname = "192.168.100.1"; //远程IP
         int port = 22;//22 usually the default port //远程SSH端口，默认可以不填
         String username = "root"; //远程服务器用户名
         String password = "12345"; //远程服务器密码

         //指明连接主机的IP地址
         Connection conn = new Connection(hostname,port); //也可以使用new Connection(hostname)直接链接

         conn.connect(); // 连接
         conn.authenticateWithPassword(username,password); //进行用户认证，返回值为true(成功),false(失败)

         Session session = conn.openSession(); //可以用来执行命令行指令等

         //以下来模仿命令行进行交互
         String shellStr = "cd;source .bash_profile;sqlplus huan1/abcde@192.168.100.1/orcl @/allcases_10g/80_00_0_2_43_src.sql";
         session.execCommand(shellStr); //执行命令，多个命令间用";"分隔

        //打印控制台返回信息
         InputStream is = new StreamGobbler(session.getStdout());
         BufferedReader brs = new BufferedReader(new InputStreamReader(is));
         //这里存在一个问题，没有退出while
         while (true){
             String line = brs.readLine();
             if (line == null){
                 System.out.println("over");
                 break;

             }
             System.out.println(line);
         }

        //使用完毕后记得释放连接
         brs.close();
         session.close();
         conn.close();

    }

}
