public class Test18 {
    Test18(String a){
        System.out.println(a);
    }
    public static void main(String[] args){
        Test18[] test18s=new Test18[5];
        for (int i=0;i<test18s.length;i++){
            test18s[i]=new Test18("abc");
        }
    }
}
