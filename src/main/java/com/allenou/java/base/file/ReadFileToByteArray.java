package com.allenou.java.base.file;

import java.io.*;
import java.util.Base64;

public class ReadFileToByteArray  extends  ReadFile {

    public static void main(String[] args) throws IOException {

        byte[] fileBytes =readFileToByteArray(new File("c:\\Users\\12804\\Desktop\\SVN\\005_中国网联\\20210105网联商户报备\\20200502\\MA_Z2012911000011_20200521_0001.xml"));
        System.out.println(Base64.getEncoder().encodeToString(fileBytes));
    }

    public static byte[] readFileToByteArray(final File file) throws IOException {
        InputStream in = null;
        try {
            if (file.exists()) {
                if (file.isDirectory()) {
                    throw new IOException("File '" + file + "' exists but is a directory");
                }
                if (file.canRead() == false) {
                    throw new IOException("File '" + file + "' cannot be read");
                }
            } else {
                throw new FileNotFoundException("File '" + file + "' does not exist");
            }

            in = new FileInputStream(file);
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            copy((InputStream)in, (OutputStream)output);
            return output.toByteArray();
        } finally {
            closeQuietly(in);
        }
    }


}
