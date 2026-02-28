package IOfile;

import java.io.*;

public class CopyFile1 {
    public static void main(String[] args) {
        String path = "2.JavaSe2/src/IOFile/24.jpg";
        byte[] bs = new byte[(1 << 20)];
        try (InputStream is = new FileInputStream(path);
             OutputStream os = new FileOutputStream("2.JavaSe2/src/IOFile/24_copy.jpg");
        ) {
            int len = is.read(bs);
            os.write(bs, 0, len);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
