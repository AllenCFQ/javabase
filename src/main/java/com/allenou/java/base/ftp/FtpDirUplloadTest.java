package com.allenou.java.base.ftp;

import com.allenou.java.base.ssh.JavaPpcSsh;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import util.TimeUtil;

import java.io.File;
import java.io.FileInputStream;

public class FtpDirUplloadTest {

    private FTPClient ftp;

    public static void main(String[] args) throws Exception {
        boolean P = false;
        boolean R = false;
        boolean b_flag = true;
        boolean c_flag = false;
        if (R) {
            uploadRoutpaygate();
        }
        if (P) {
            uploadPbg();
        }
        if (b_flag) {
            faceroute_pre();
        }
        if (c_flag) {
            cups_pre();
        }

    }

    public static void faceroute_pre() throws Exception {
        String srcDir = "";
        String destDir = "";
        uploadFileOrDid(srcDir, destDir, "", 21, "", "");
        JavaPpcSsh.rpcShell(" cd /usr//netbank/faceroute/script; ./restart.sh");
    }

    public static void cups_pre() throws Exception {
        String[] srcDirS = {""};
        String destDir = "";
        for (String s : srcDirS) {
            uploadFileOrDid(s, destDir, "", 21, "", "");
        }
        JavaPpcSsh.rpcShell("  cd /usr//netbank/app1/bin; ./restart.sh");
    }

    public static void uploadPbg() throws Exception {
        String ip = "";
        int ftpport = 21;
        int sshport = 22;
        String user2 = "";
        String pwd = "";

        String[] srcDirS = {""};
        String destDir = "";
        for (String s : srcDirS) {
            uploadFileOrDid(s, destDir, ip, ftpport, user2, pwd);
        }
        JavaPpcSsh.rpcShell(ip, sshport, user2, pwd, " cd /usr//v2/app/script; ./reserv.sh");

    }

    public static void uploadRoutpaygate() throws Exception {
        String ip = "";
        int ftpport = 21;
        int sshport = 22;
        String user2 = "";
        String pwd = "";

        String[] srcDirS = {""};
        String destDir = "";
        for (String s : srcDirS) {
            uploadFileOrDid(s, destDir, ip, ftpport, user2, pwd);
        }
        JavaPpcSsh.rpcShell(ip, sshport, user2, pwd, " cd /usr///v2/app/script; ./reserv.sh");

    }

    public static void uploadFileOrDid(String srcFile, String destDir, String destIp, int port, String destUser, String destPwd) throws Exception {
        FtpDirUplloadTest t = new FtpDirUplloadTest();
        boolean conectFlag = t.connect(destDir, destIp, port, destUser, destPwd);
        if (!conectFlag) {
            System.out.println(conectFlag);
            throw new Exception("登录失败");
        }
        File file = new File(srcFile);
        t.upload(file);
    }

    /**
     * @param path     上传到ftp服务器哪个路径下
     * @param addr     地址
     * @param port     端口号
     * @param username 用户名
     * @param password 密码
     * @return
     * @throws Exception
     */
    private boolean connect(String path, String addr, int port, String username, String password) throws Exception {
        boolean result = false;
        ftp = new FTPClient();
        int reply;
        ftp.connect(addr, port);
        ftp.login(username, password);
        ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
        reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            return result;
        }
        ftp.changeWorkingDirectory(path);

        //System.out.println( "remotedir:  "+ftp.printWorkingDirectory());
        result = true;
        return result;
    }

    /**
     * @param file 上传的文件或文件夹
     * @throws Exception
     */
    private void upload(File file) throws Exception {
        if (file.isDirectory()) {
            System.out.println(ftp);
            System.out.println(file.getName());
            ftp.makeDirectory(file.getName());
            ftp.changeWorkingDirectory(file.getName());
            String[] files = file.list();
            for (int i = 0; i < files.length; i++) {
                File file1 = new File(file.getPath() + "\\" + files[i]);
                if (file1.isDirectory()) {
                    upload(file1);
                    ftp.changeToParentDirectory();
                } else {
                    File file2 = new File(file.getPath() + "\\" + files[i]);
                    FileInputStream input = new FileInputStream(file2);
                    ftp.storeFile(file2.getName(), input);
                    input.close();
                    System.out.println("上传成功：");
                    System.out.println("本地路径：" + file2.getAbsolutePath() + file2.getName());
                    System.out.println("远程路径：" + ftp.printWorkingDirectory());
                }
            }
        } else {
            File file2 = new File(file.getPath());
            FileInputStream input = new FileInputStream(file2);
            ftp.rename(file2.getName(), file2.getName() + ".bak" + TimeUtil.datetime14());
            ftp.storeFile(file2.getName(), input);

            input.close();
            System.out.println("上传成功：" + ftp.printWorkingDirectory() + "/" + file2.getName());
        }
    }


}
