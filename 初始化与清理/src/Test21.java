
enum Mianzhi{
    YIYUAN,WUYUAN,SHIYUAN,ERSHIYUAN,WUSHIYUAN,YIBAIYUAN
}
public class Test21 {
    Mianzhi mianzhi;
    public Test21(Mianzhi mianzhi){
        this.mianzhi=mianzhi;
    }
    public static void main(String[] args){
/*        for (Mianzhi s:Mianzhi.values())
            System.out.println(s+"   original"+s.ordinal());*/
             Test21
                     wuyuan=new Test21(Mianzhi.WUYUAN),
                     shiyuan=new Test21(Mianzhi.SHIYUAN);
             wuyuan.XuanZe();
             shiyuan.XuanZe();
    }
    void XuanZe(){
        switch (mianzhi){
            case WUYUAN:System.out.println("这是5元");break;
            case SHIYUAN:System.out.println("这是10元");break;
            case WUSHIYUAN:System.out.println("这是50元");break;
            case YIBAIYUAN:System.out.println("这是100元");break;
            case YIYUAN:System.out.println("这是1元");break;
            case ERSHIYUAN:System.out.println("这是20元");break;
        }
    }
}
