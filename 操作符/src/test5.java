public class test5 {

    public static void main(String[] args){
        Dog dog1=new Dog();
        Dog dog2=new Dog();
        dog1.name="spot";
        dog1.says="Ruff!";
        dog2.name="scruffy";
        dog2.says="Wurf!";
        System.out.println(dog1.name+"   "+dog1.says);
        System.out.println(dog2.name+"   "+dog2.says);
        System.out.println("compare");
        System.out.println("dog1==dog2   : "+(dog1==dog2));
        System.out.println("dog1 equal dog2   :"+dog1.equals(dog2));
    }
}
class Dog{
    String name;
    String says;
}