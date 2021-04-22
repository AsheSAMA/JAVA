public class test6 {
    int storage(String s){
        return s.length()*2;
    }
    public static void main(String[] args){
        String a="abc";
        test6 t6=new test6();
        System.out.print(t6.storage(a));
    }
}
