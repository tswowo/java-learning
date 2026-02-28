package exceptions;

public class ExceptionTest2 {

    private static int test1(int a,int b) throws Exception{
        if(b==0){
            throw new Exception("除数不能为0");
        }
        return a/b;
    }

    public static void main(String[] args) {
        try {
            System.out.println(test1(10,0));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
