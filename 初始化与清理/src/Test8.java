public class Test8 {
    void bark(double a,int b){
        System.out.println("howling");
        barkk("aaa");
        this.barkk("aaa");
    }
    void barkk(String a){
        System.out.println("flying");
    }
    public static void main(String[] args){
        Test8 test8=new Test8();
        test8.bark(5.0,6);
    }
}
