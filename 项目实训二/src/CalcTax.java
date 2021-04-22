import java.util.Scanner;
public class CalcTax{
    public static void main(String args[]){
        float  个人收入;
        float  纳税金额;
        float  超出金额;
        float  实得金额;
        System.out.print("请输入你的个人收入：");
        Scanner reader=new Scanner(System.in);
        个人收入=reader.nextFloat( );
        超出金额=个人收入-3500.0f;
        if (个人收入<=3500)       //判断“个人收入”在3500元内的条件
        { 纳税金额=0.0f;   超出金额=0.0f; }
      else if (个人收入<=5000)

        纳税金额=超出金额*0.03f;
      else if (个人收入<=8000)          //判断“个人收入”在8000元内的条件
        纳税金额=(超出金额-1500f)*0.1f+45f;
      else if (个人收入<=12500)        //判断“个人收入”在12500元内的条件
        纳税金额=(超出金额-4500.0f)*0.2f+345f;
      else if (个人收入<=38500)        //判断“个人收入”在38500元内的条件
            纳税金额=(超出金额-12500.0f)*0.25f+1245f;


      else if (个人收入<=58500.0f)
            纳税金额=(超出金额-35500.0f)*0.3f+7745f;
        else if (个人收入<=83500)
            纳税金额=(超出金额-55000.0f)*0.35f+13745f;
        else
            纳税金额=(超出金额-80000.0f)*0.45f+22495f;
        System.out.println("超出金额="+超出金额);
        System.out.println("纳税金额="+纳税金额);
        实得金额=个人收入-纳税金额;
        System.out.println("实得金额=" +实得金额);       //计算和输出“实得金额”的代码
    }
}
