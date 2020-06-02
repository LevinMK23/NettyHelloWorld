package io;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        File file = new File("src\\main\\java\\dir1\\BZ6A3602.jpg");
        String name = file.getName();
        // DataInputStream
        File copy = new File("src\\main\\java\\dir2\\BZ6A3602_copy.jpg");
        try(InputStream in = new BufferedInputStream(new FileInputStream(file));
                OutputStream out = new BufferedOutputStream(new FileOutputStream(copy))) {
            while (in.available() > 0) {
                out.write(in.read());
            }
        }
        System.out.println("origin: " + file.length() + " bytes");
        System.out.println("copy: " + copy.length() + " bytes");
    }
}
