public class test14 {
    static void Stringequals(String a,String b){
        System.out.println(a+"------"+b);

        System.out.println(a==b);
        System.out.println(a!=b);
        System.out.println(a.equals(b));
        System.out.println(b.equals(a));
        System.out.println("----------------------");
    }

    public static void main(String[] args){
        String a="abc";
        String b="bcd";
        String c="abc";
        Stringequals(a,b);
        Stringequals(a,c);
        Stringequals(b,c);

    }
}
