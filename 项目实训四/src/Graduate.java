

interface StudentManageInterface{
    void setFee(int a);
    double getFee();
}
interface TeacherManageInterface{
    void setPay(int b);
    double getPay();
}
public class Graduate implements StudentManageInterface,TeacherManageInterface{
    String name;
    String sex;
    int age;
    double fee;
    double pay;

    Graduate(String name,String sex,int age){
        this.name=name;
        this.sex=sex;
        this.age=age;

    }

    public void setFee(int a) {
        fee=a;
    }

    @Override
    public double getFee() {
        return fee;
    }
    public void setPay(int b){
        pay=b;
    }

    @Override
    public double getPay() {
        return pay*12;
    }
    public static void daikuan(Graduate a){
        if(a.getFee()>a.getPay()){
            System.out.println("年收入："+a.getPay());
            System.out.println("年学费："+a.getFee());
            System.out.print("provide a loan");
        }
        else {
            System.out.println("年收入："+a.getPay());
            System.out.println("年学费："+a.getFee());
        }
    }

    public static void main(String args[]){
        Graduate zhangsan =new Graduate("zhansgan","man",24);
        zhangsan.setFee(20000);
        zhangsan.setPay(1000);
        daikuan(zhangsan);

    }
}
