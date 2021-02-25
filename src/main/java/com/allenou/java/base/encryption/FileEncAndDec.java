package com.allenou.java.base.encryption;

import java.io.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class FileEncAndDec {

    private static final int numOfEncAndDec = 0x99; //加密解密秘钥
    private static int dataOfFile = 0; //文件字节内容
    public static void main(String[] args) {


        String path = System.getProperty("user.dir");
        System.out.println(path);
        File srcFile = new File("桌面.jpg"); //初始文件
        File encFile = new File("encFile.tif"); //加密文件
        File decFile = new File("decFile.bmp"); //解密文件

        try {
            EncFile(srcFile, encFile); //加密操作
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void EncFile(File srcFile, File encFile) throws Exception {
        if(!srcFile.exists()){
            System.out.println("source file not exixt");
            return;
        }

        if(!encFile.exists()){
            System.out.println("encrypt file created");
            encFile.createNewFile();
        }
        InputStream fis  = new FileInputStream(srcFile);
        OutputStream fos = new FileOutputStream(encFile);

        while ((dataOfFile = fis.read()) > -1) {
            fos.write(dataOfFile^numOfEncAndDec);
        }

        fis.close();
        fos.flush();
        fos.close();
    }
}
