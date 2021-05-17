public class Test14 {
    static String a="abc";
    static String b;
    static Test14 test14=new Test14();
    static {
        b="abcd";
    }
    static void SystemOut(String a){
        System.out.println(a);
    }
    public static void main(String[] args){
        Test14.SystemOut(a);
        Test14.SystemOut(b);
    }
}
