public class Test3 {
    Test3(){
        System.out.println("这是一条消息");
    }
    Test3(String a){
        System.out.println(a);
    }
    public static void main(String[] args){
        Test3 test3=new Test3("你好你好");
    }
}
