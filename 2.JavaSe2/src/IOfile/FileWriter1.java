package IOfile;

import java.io.*;

public class FileWriter1 {
    public static void main(String[] args) {
        String path = "2.JavaSe2/src/IOFile/tempFile2";
        try(FileWriter fw = new FileWriter(path,true);){
            fw.write("hello world123");
            fw.write('+');
            fw.write("hello world123",0,1);
            fw.write('+');
            fw.write(new char[]{'1','2','3'},0,1);
            fw.write('\n');
            fw.flush();
        }catch(Exception e){
            e.getMessage();
        }
    }
}
