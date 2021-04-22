public class test8 {
    public static void main(String[] args){
        StaticTest1 st1=new StaticTest1();
        StaticTest1 st2=new StaticTest1();
        StaticTest1 st3=new StaticTest1();
        System.out.println(st1.i);
        System.out.println(st2.i);
        System.out.println(st3.i);
        st1.i=41;
        System.out.println(st1.i);
        System.out.println(st2.i);
        System.out.println(st3.i);
    }
}
class StaticTest1{
    static int i=40;
}
