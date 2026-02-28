package exceptions;

class ageIllegalException extends Exception {
    public ageIllegalException(String message) {
        super(message);
    }
}

class runAgeIllegalException extends RuntimeException {
    public runAgeIllegalException(String message) {
        super(message);
    }
}

public class ExceptionTest3 {
    public static void main(String[] args) {
        //编译型异常 继承Exception 编译时报异常
        try {
            saveAge(10);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        //运行时异常 继承RuntimeException 运行时报异常
        runSaveAge(-10);
    }

    private static void saveAge(int age) throws ageIllegalException {
        if (age < 0 || age > 120) {
            throw new ageIllegalException("年龄不合法");
        } else {
            System.out.println("保存年龄成功:" + age);
        }
    }

    private static void runSaveAge(int age) throws runAgeIllegalException {
        if (age < 0 || age > 120) {
            throw new runAgeIllegalException("年龄不合法");
        } else {
            System.out.println("保存年龄成功:" + age);
        }
    }
}
