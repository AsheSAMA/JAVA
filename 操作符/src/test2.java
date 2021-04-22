public class test2 {
    float a;
    test2(float q){
        a=q;
    }
    public static void main(String[] args){
        test2 ttest1=new test2(47);
        test2 ttest2=new test2(27);
        System.out.println("1:t1.a"+ttest1.a+"     "+"2:t2.a"+ttest2.a);
        ttest1=ttest2;
        System.out.println("1:t1.a"+ttest1.a+"     "+"2:t2.a"+ttest2.a);
        ttest1.a=37;
        System.out.println("1:t1.a"+ttest1.a+"     "+"2:t2.a"+ttest2.a);

    }
}
