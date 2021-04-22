import java.util.Scanner;
public class PrintYh{
    public static void main(String args[]){
        int Line_num;
        int i,a;
        int row=0,col;
        int yh[]=new int[20];     //不超过20行
        Scanner reader=new Scanner(System.in);
        System.out.print("请输入行数:");
        Line_num=reader.nextInt();
        yh[0]=1;
        for (;row<Line_num;row++){          //控制输出行数为Line_num的循环控制
            for (col=row;col>0;col--)
                yh[col]=yh[col-1]+yh[col];
            for (i=Line_num;i>row;i--)  {

                System.out.print("     ");
                //控制输出每行前导空格的循环控制
           }
            for (col=0;col<=row;col++){

            System.out.print(yh[col]); System.out.print("         ");
            }        //输出下标为col的项的代码
            System.out.println("  ");
        }
    }
}
