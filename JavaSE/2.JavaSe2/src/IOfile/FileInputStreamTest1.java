package IOfile;

import java.io.FileInputStream;
import java.io.InputStream;

public class FileInputStreamTest1 {
    public static void main(String[] args) {
        String path = "2.JavaSe2/src/IOFile/tempFile1";
        InputStream is = null;
        try {
//            is = new FileInputStream(path);
//            int b;
//            while ((b = is.read()) != -1)
//                System.out.print((char) b);
//            is.close();
            is = new FileInputStream(path);
            byte[] bs = new byte[1024];
            int len=is.read(bs);
            System.out.println("\n"+new String(bs,0,len));
            is.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
