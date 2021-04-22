import java.util.Random;

public class test2 {
    public static void main(String[] args){
        Random random=new Random();
    int[] arr=new int[25];
        for(int i=1;i<25;i++){
        int a=random.nextInt(100);
        arr[i]=a;
        if(arr[i]<arr[i-1])System.out.println(arr[i] + " < " + arr[i-1]);
        else if(arr[i]>arr[i-1])System.out.println(arr[i] + " > " + arr[i-1]);
        else System.out.println(arr[i] + " = " + arr[i-1]);
    }

}
}
