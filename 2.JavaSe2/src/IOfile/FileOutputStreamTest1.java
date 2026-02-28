package IOfile;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class FileOutputStreamTest1 {
    public static void main(String[] args) {
        String path = "2.JavaSe2/src/IOFile/tempFile2";
        try {
            byte[] bs="hello world123".getBytes();
            OutputStream os = new FileOutputStream(path,true);
            os.write(97);
            os.write('+');
            os.write(bs);
            os.write('+');
            os.write(bs,0,1);
            os.write('\n');
            os.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
