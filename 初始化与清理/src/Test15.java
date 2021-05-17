public class Test15 {
    String a;
    Test15(String a){
        this.a=a;
        System.out.println(this.a);
    }
    public static void main(String[] args){
        Test15 a,b;
        a=new Test15("abc");
        b=new Test15("def");
    }
}
