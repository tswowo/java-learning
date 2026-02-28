package oop1;

class Father{
    private String name;
    public Father(String name){
        this.name=name;
    }
    public String getName(){
        return "father "+name;
    }
    public void setName(String name){
        this.name=name;
    }
}

class Son extends Father{
    public Son(String name) {
        super(name);
    }
    @Override
    public String getName(){
        return "Son "+super.getName();
    }
}

public class OOPTest3 {
    public static void main(String[] args) {
        Son f=new Son("asd");
        System.out.println(f.getName());
    }
}
