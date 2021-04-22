import java.util.Scanner;

public class MenuSelect{
    public static void main(String args[]){
        System.out.println("1) 输入学生成绩信息");
        System.out.println("2）按总平均成绩排序");
        System.out.println("3）按学号排序");
        System.out.println("4）输出成绩信息表");
        System.out.println("0）结束退出");
        System.out.println("==========================");
        System.out.print("请输入功能选择：");
        Scanner reader=new Scanner(System.in);
        int  select=reader.nextInt( );
        switch(select){     //用开关语句实现根据select执行相应功能
            case 0: {
                System.out.println("结束退出");
                break;
                     }
                                   //结束switch语句执行
            case  1:{System.out.println("1) 输入学生成绩信息成功");break;}     //输出对应功能1的执行信息并结束
            case  2:{System.out.println("2）按总平均成绩排序成功");break;}         //输出对应功能2的执行信息并结束
            case  3:{System.out.println("3）按学号排序成功");break;}         //输出对应功能3的执行信息并结束
            case  4:{System.out.println("4）信息表输出成功");break;}//输出对应功能4的执行信息并结束
            default:{System.out.println("5）错误");}                //针对超出范围的输入，出错误信息
        }
    }
}
