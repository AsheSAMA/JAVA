import java.util.Random;

public class test4 {
    static float v(float a,float b){
        return a/b;

    }
    public static void main(String[] args){
        Random rand=new Random();
        float distance =200f;
        float time = 10f;
        float vl =v(distance,time);
        System.out.println(vl);
    }
}
