public class Test9 {
    Test9(String a){
        this(5);
        System.out.println("这是第一个构造器");

    }
    Test9(int a){
        System.out.println("这是第二个构造器");
    }
    public static void main(String[] args){
        Test9 test9=new Test9("aa");
    }
}
