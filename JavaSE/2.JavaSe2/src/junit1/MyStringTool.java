package junit1;

public class MyStringTool {
    public boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public int getLength(String str) throws NullPointerException{
        return str.length();
    }
}
