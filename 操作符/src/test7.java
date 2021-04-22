import java.util.Random;

public class test7 {
    public static void main(String[] args){
        Random random=new Random();
        int i=random.nextInt(100);
        System.out.println(i);
        if(i%2==0)System.out.println("正面");
        else System.out.println("反面");
    }
}
