
public class test10{
    static int a(int sum){
        return sum/1000;
    }
    static int b(int sum){
        return (sum%1000)/100;
    }



    static int c(int sum){
        return (sum%100)/10;
    }
    static int d(int sum){
        return sum%10;
    }





    static int zuhe(int a,int b){
        return (a*10)+b;
    }
    static void zongshu(int sum,int a,int b){
        if (a*b==sum)System.out.println(a+" 乘 "+b+" = "+sum);
    }
    public static void main(String[] args){
        for (int i=1000;i<10000;i++){
            zongshu(i,zuhe(a(i),b(i)),zuhe(c(i),d(i)));
            zongshu(i,zuhe(a(i),b(i)),zuhe(d(i),c(i)));
            zongshu(i,zuhe(a(i),c(i)),zuhe(b(i),d(i)));
            zongshu(i,zuhe(a(i),c(i)),zuhe(d(i),b(i)));
            zongshu(i,zuhe(a(i),d(i)),zuhe(c(i),b(i)));
            zongshu(i,zuhe(a(i),d(i)),zuhe(b(i),c(i)));

            zongshu(i,zuhe(b(i),a(i)),zuhe(a(i),d(i)));
            zongshu(i,zuhe(b(i),a(i)),zuhe(d(i),a(i)));

            zongshu(i,zuhe(b(i),c(i)),zuhe(d(i),a(i)));
            zongshu(i,zuhe(b(i),d(i)),zuhe(c(i),a(i)));

            zongshu(i,zuhe(c(i),a(i)),zuhe(d(i),b(i)));
            zongshu(i,zuhe(c(i),b(i)),zuhe(d(i),a(i)));

        }

    }
}