package IOfile;

import java.io.File;
import java.io.IOException;

public class FileTest1 {

    public static void main(String[] args)  {
        File f1=new File("2.JavaSe2/src/IOFile/IOFiles");
        System.out.println(f1.mkdir());

        File f2= new File(f1,"tempFile1");

        File f=new File("2.JavaSe2/src/IOFile/IOFiles/tempFile1");
        System.out.println(f.exists());
        System.out.println(f.length());
        System.out.println(f.getName());
        System.out.println(f.isFile());
        System.out.println(f.isDirectory());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getPath());

        try {
            System.out.println(f.createNewFile());
            System.out.println(f.delete());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        for(var ff:f1.listFiles())
            System.out.println(ff.getName());
    }
}