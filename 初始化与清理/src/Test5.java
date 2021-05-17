class Dog{
    void bark(int a,double b){
        System.out.println("barking");
    }
    void bark(double a,int b){
        System.out.println("howling");
    }
    void bark(String a){
        System.out.println("flying");
    }
}
public class Test5 {
    public static void main(String[] args){
        Dog dog=new Dog();
        dog.bark(5,5.0);
        dog.bark(5.0,6);
        dog.bark("aaa");
    }
}
