package IOfile;

import java.io.*;

public class FileReader1 {
    public static void main(String[] args) {
        String path = "2.JavaSe2/src/IOFile/tempFile1";
        try (Reader r = new FileReader(path)) {
            int ch,idx=0;
            while ((ch =r.read()) != -1){
                System.out.println((idx++)+" "+ch+" "+(char)ch);
            }
//            char[] cs = new char[1024];
//            int len = r.read(cs);
//            System.out.println(new String(cs, 0, len));
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
