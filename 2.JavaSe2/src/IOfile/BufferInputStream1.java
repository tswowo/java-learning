package IOfile;

import java.io.*;

public class BufferInputStream1 {
    public static void main(String[] args) throws Exception {
        try (
                InputStream ifs = new FileInputStream("2.JavaSe2/src/IOFile/24.jpg");
                InputStream bis = new BufferedInputStream(ifs);
                OutputStream ofs = new FileOutputStream("2.JavaSe2/src/IOFile/24_copy.jpg");
                OutputStream bos = new BufferedOutputStream(ofs)
        ) {
            byte[] bs = new byte[(1 << 20)];
            int len = bis.read(bs);
            bos.write(bs, 0, len);
        } catch (Exception e) {
            e.getMessage();
        }
        System.out.println();
    }
}
