package com.allenou.java.base.file;

import java.io.*;
import java.util.Base64;

public class FileUtilsXX {

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

    public static byte[] toByteArray(InputStream input) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        copy(input, output);
        return output.toByteArray();
    }

    public static int copy(InputStream input, OutputStream output) throws IOException {
        long count = copyLarge(input, output);
        if (count > Integer.MAX_VALUE) {
            return -1;
        }
        return (int) count;
    }

    public static long copyLarge(InputStream input, OutputStream output)
            throws IOException {
        return copyLarge(input, output, new byte[1024 * 4]);
    }

    public static long copyLarge(InputStream input, OutputStream output, byte[] buffer)
            throws IOException {
        long count = 0;
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
            count += n;
        }
        return count;
    }
    public static void closeQuietly(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (IOException ioe) {
        }
    }
}
