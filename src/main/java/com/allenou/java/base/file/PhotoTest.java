package com.allenou.java.base.file;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

public class PhotoTest {

    public static void main(String[] args) {
        // 测试从Base64编码转换为图片文件
        String strImge = "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";
        GenerateImage(strImge, "C:\\ideaWorkUTF-8\\11.jpg");
        // 测试从图片文件转换为Base64编码
        // System.out.println(GetImageStr("d:\\11.jpg"));
    }



    public static String GetImageStr(String imgFilePath) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        byte[] data = null;

        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(imgFilePath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 对字节数组Base64编码

        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);// 返回Base64编码过的字节数组字符串
    }

    public static boolean GenerateImage(String imgStr, String imgFilePath) {// 对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) // 图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] bytes = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {// 调整异常数据
                    bytes[i] += 256;
                }
            }
            // 生成jpeg图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(bytes);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}