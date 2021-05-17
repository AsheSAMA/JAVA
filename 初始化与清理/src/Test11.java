public class Test11 {
    public static void main(String[] args){
        Tank tank1=new Tank(true);
        Tank tank2=new Tank(true);
        Tank tank3=new Tank(true);
        tank1.XianShi();
        tank2.XianShi();
        tank3.XianShi();
        tank1.doKong();
        System.gc();

    }
}
class Tank{
    boolean zhuangtai;
    protected void finalize(){
        if (!zhuangtai)System.out.println(this.getClass().getName()+"垃圾回收");
    }
    Tank(boolean a){
        zhuangtai=a;
    }
    void doKong(){
        zhuangtai=false;
    }
    void doMan(){
        zhuangtai=true;
    }
    void XianShi(){
        System.out.println(zhuangtai);
    }
}
