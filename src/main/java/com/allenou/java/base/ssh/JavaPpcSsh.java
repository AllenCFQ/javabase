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
        // ����ִ�нű�����ʱ���ص���Ϣ
        BufferedReader errBufferedReader = null;
        Session session = null;
        // �ַ�����
        String charsetString = "utf-8";
        try {
            InetAddress inetAddress = InetAddress.getByName(destIp);
            // �����������ͨ��
            boolean reachable = inetAddress.isReachable(1000);
            connection = new Connection(destIp,port);
            // �������ӣ����û�д˲���ᱨConnection is not established!�˽�δ����
            connection.connect();
            // У��Ȩ��
            connection.authenticateWithPassword(user, pasword);
            session = connection.openSession();
            // ִ������

            session.execCommand(command);
            System.out.println( command+" OK ");
            Thread.sleep(8000);

            // ��ȡִ�������������Ϣ
            /**

             InputStream stdout = session.getStdout();
             // ��ȡִ��������ֵĴ�����Ϣ
             InputStream stderr = session.getStderr();
             bufferedReader = new BufferedReader(
             new InputStreamReader(stdout, charsetString));
             // ���ն�ȡ���ķ�����Ϣ
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
             System.out.println("���ص�״̬" + exitStatus);

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
        // ����ִ�нű�����ʱ���ص���Ϣ
        BufferedReader errBufferedReader = null;
        Session session = null;
        // �ַ�����
        String charsetString = "utf-8";
        try {
            System.out.println("�����������ͨ��"+ip);
            InetAddress inetAddress = InetAddress.getByName(ip);
            // �����������ͨ��
            boolean reachable = inetAddress.isReachable(1000);
            System.out.println("�����������ͨ��"+ip+";"+reachable);
            connection = new Connection(ip,port);
            // �������ӣ����û�д˲���ᱨConnection is not established!�˽�δ����
            connection.connect();
            System.out.println("����"+ip+";"+port);
            // У��Ȩ��
            connection.authenticateWithPassword(user2, pw);
            session = connection.openSession();
            // ִ������

            session.execCommand(command);
            System.out.println( command+" OK ");
            Thread.sleep(8000);

            // ��ȡִ�������������Ϣ
            /**

             InputStream stdout = session.getStdout();
             // ��ȡִ��������ֵĴ�����Ϣ
             InputStream stderr = session.getStderr();
             bufferedReader = new BufferedReader(
             new InputStreamReader(stdout, charsetString));
             // ���ն�ȡ���ķ�����Ϣ
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
             System.out.println("���ص�״̬" + exitStatus);

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
