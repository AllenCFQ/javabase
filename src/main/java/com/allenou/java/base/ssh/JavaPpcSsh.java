package com.allenou.java.base.ssh;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;

public class JavaPpcSsh {

    static  String destIp = "xxxxxxx";
    static  int port = 22;
    static  String user = "xxx";
    static  String pasword = "xxxx";


    public static void main(String[] args) throws Exception {
        String commandFace =  " cd /usr/faceroute/script; ./restart.sh ";
        String commandCups =  " cd /usr/app1/bin; ./restart.sh ";
        rpcShell(commandFace);
    }


    public static  void rpcShell(String command) throws IOException {

        Connection connection = null;
        BufferedReader bufferedReader = null;
        // 接收执行脚本错误时返回的信息
        BufferedReader errBufferedReader = null;
        Session session = null;
        // 字符编码
        String charsetString = "utf-8";
        try {
            InetAddress inetAddress = InetAddress.getByName(destIp);
            // 测试网络的联通性
            boolean reachable = inetAddress.isReachable(1000);
            connection = new Connection(destIp,port);
            // 建立连接，如果没有此步骤会报Connection is not established!了解未建立
            connection.connect();
            // 校验权限
            connection.authenticateWithPassword(user, pasword);
            session = connection.openSession();
            // 执行命令

            session.execCommand(command);
            System.out.println( command+" OK ");
            Thread.sleep(8000);

            // 获取执行命令输出的信息
            /**

             InputStream stdout = session.getStdout();
             // 获取执行命令出现的错误信息
             InputStream stderr = session.getStderr();
             bufferedReader = new BufferedReader(
             new InputStreamReader(stdout, charsetString));
             // 接收读取到的返回信息
             String returnMessage = null;
             while ((returnMessage = bufferedReader.readLine()) != null) {
             System.out.println("1111111" + returnMessage);
             }
             errBufferedReader = new BufferedReader(
             new InputStreamReader(stderr, charsetString));
             while ((returnMessage = errBufferedReader.readLine()) != null) {
             System.out.println("222222" + returnMessage);
             }
             Integer exitStatus = session.getExitStatus();
             System.out.println("返回的状态" + exitStatus);

             */

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (errBufferedReader != null) {
                errBufferedReader.close();
            }
            if (connection != null) {
                connection.close();
            }
            session.close();
        }
    }



    public static  void rpcShell(String ip,int port,String user2,String pw,String command) throws IOException {



        Connection connection = null;
        BufferedReader bufferedReader = null;
        // 接收执行脚本错误时返回的信息
        BufferedReader errBufferedReader = null;
        Session session = null;
        // 字符编码
        String charsetString = "utf-8";
        try {
            System.out.println("测试网络的联通性"+ip);
            InetAddress inetAddress = InetAddress.getByName(ip);
            // 测试网络的联通性
            boolean reachable = inetAddress.isReachable(1000);
            System.out.println("测试网络的联通性"+ip+";"+reachable);
            connection = new Connection(ip,port);
            // 建立连接，如果没有此步骤会报Connection is not established!了解未建立
            connection.connect();
            System.out.println("连接"+ip+";"+port);
            // 校验权限
            connection.authenticateWithPassword(user2, pw);
            session = connection.openSession();
            // 执行命令

            session.execCommand(command);
            System.out.println( command+" OK ");
            Thread.sleep(8000);

            // 获取执行命令输出的信息
            /**

             InputStream stdout = session.getStdout();
             // 获取执行命令出现的错误信息
             InputStream stderr = session.getStderr();
             bufferedReader = new BufferedReader(
             new InputStreamReader(stdout, charsetString));
             // 接收读取到的返回信息
             String returnMessage = null;
             while ((returnMessage = bufferedReader.readLine()) != null) {
             System.out.println("1111111" + returnMessage);
             }
             errBufferedReader = new BufferedReader(
             new InputStreamReader(stderr, charsetString));
             while ((returnMessage = errBufferedReader.readLine()) != null) {
             System.out.println("222222" + returnMessage);
             }
             Integer exitStatus = session.getExitStatus();
             System.out.println("返回的状态" + exitStatus);

             */

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (errBufferedReader != null) {
                errBufferedReader.close();
            }
            if (connection != null) {
                connection.close();
            }
            session.close();
        }
    }


}
