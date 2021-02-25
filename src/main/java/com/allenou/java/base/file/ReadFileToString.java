package com.allenou.java.base.file;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ReadFileToString {

    public static void main(String[] args) throws IOException {
        File file  = new File("c:\\Users\\12804\\Desktop\\SVN\\005_中国网联\\20210105网联商户报备\\20200502\\MA_Z2012911000011_20200521_0001.xml");
        byte[] bytes = FileUtils.readFileToByteArray(file);
        String fileStringUtf8 = FileUtils.readFileToString(file,"UTF-8");
    }
}
