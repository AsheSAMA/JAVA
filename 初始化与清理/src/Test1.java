public class Test1 {
    String abc;
    String a="你好";
    String b;
    Test1(){
        b="这是构造器的";
    }
    public static void main(String[] args){
        Test1 test1=new Test1();
        System.out.println(test1.abc);
        System.out.println(test1.a);
        System.out.println(test1.b);
    }
}
