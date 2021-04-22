import java.lang.*;
import java.util.Scanner;

public  class PrintPrime {
    void sushu(int b) {
        boolean abc=true;
        int count=0;
        int i = b;
        for (; i > 1; i--) {
            for (int a = 2; a < i; a++) {
                if (i % a == 0) {
                    abc=false;
                    break;
                }
            }
            if(abc==true){System.out.print(i+"   ");count++;}
            if(count==10){count=0;
                            System.out.println(" ");
            }
            abc=true;
        }
    }



    public static void main (String[] args){
        System.out.print("test" );
        PrintPrime abcde=new PrintPrime();
        Scanner inputt=new Scanner(System.in);
        System.out.println("请输入一个数");

        int q=inputt.nextInt();

        abcde.sushu(q);

    }

}
