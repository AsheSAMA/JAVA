public class Test10 {
    boolean b=false;
    Test10(boolean a){
        this.b=a;
    }
    protected void finalize(){
        if (b)System.out.println("垃圾回收");
        else System.out.println("不回收");
    }
    public static void main(String[] args){
        new Test10(true);
        System.gc();
    }
}