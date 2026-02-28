package exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionTest1 {

    private static void test1(){//Runtime Exception
        int[] arr ={1,2,3};
        System.out.println(arr[3]);
    }

    private static void test2() throws ParseException, FileNotFoundException {//编译异常
        String str="2025-1111  11:31:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=sdf.parse(str);

        InputStream in = new FileInputStream("d:/a.txt");
    }

    private static void show1(){
        try {
            test2();
        }
        catch (ParseException e) {
            e.printStackTrace();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    private static void show2() throws Exception{
        test2();
    }

    public static void main(String[] args) {
        show1();
        System.out.println("=========");
        try {
            show2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
