public class test7 {
    public static void main(String[] args){
        System.out.println(StaticTest.i);
        Incrementable.incrment();
        System.out.println(StaticTest.i);
        Incrementable sf=new Incrementable();
        sf.incrment();
        System.out.println(StaticTest.i);
    }
}
class StaticTest{
    static int i =47;
}
class Incrementable{
    static void incrment(){
        StaticTest.i++;
    }
}
