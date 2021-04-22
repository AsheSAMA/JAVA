class A {
	float a;             //声明一个float型实例变量a
    static float b;//声明一个float型类变量b,即static变量b
    void setA(float a) {
	    this.a=a;       //将参数a的值赋值给成员变量a
    }
    void setB(float b) {
	    this.b=b;       //将参数b的值赋值给成员变量b
    }
    float getA() {
        return a;
    }
    float getB() {
        return b;
    }
    void outputA( ) {
        System.out.println(a);
    }
    static void outputB( ) {
        System.out.println(b);
    }
}
public class Example {
    public static void main(String args[]) {
        A.b = 100;           //通过类名操作类变量b,并赋值100
        A.outputB();        //通过类名调用方法inputB()
        A cat = new A();
        A dog = new A();
        cat.a = 200;          //cat象调用方法setA(int a)将cat的成员a的值设置为200
        cat.setB(400);          //cat调用方法setB(int b)将cat的成员b的值设置为400
        dog.setA(150);//dog象调用方法setA(int a)将dog的成员a的值设置为150
        dog.setB(300);         //dog调用方法setB(int b)将dog的成员b的值设置为300
        cat.outputA();         //cat调用outputA( )。
        cat.outputB();         //cat调用inputB( )。
        dog.outputA();         //dog调用inputA( )。
        dog.outputB();//dog调用inputB( )。
    }
}