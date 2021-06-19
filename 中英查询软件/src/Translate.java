import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Translate extends JFrame implements ActionListener {
    JTextField shurukuang=new JFormattedTextField();
    JLabel shuru=new JLabel("输入要查询的单词:");
    JButton chaxun=new JButton("查询");
    JTextArea xianshi=new JTextArea();
    Translate(){
        init();
        this.setTitle("英语释义查询");
        this.setSize(450,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        chaxun.addActionListener(this);
    }
    void init(){
        this.setLayout(null);
        this.add(shuru);
        this.add(shurukuang);
        this.add(chaxun);
        this.add(xianshi);
        xianshi.setSize(390,150);
        xianshi.setLocation(10,50);
        chaxun.setLocation(300,15);
        chaxun.setSize(100,30);
        shuru.setLocation(10,5);
        shuru.setSize(130,50);
        shurukuang.setLocation(140,15);
        shurukuang.setSize(140,30);

    }
    public void actionPerformed(ActionEvent e){

        String url = "jdbc:mysql://localhost:3306/test";

        if(e.getSource()==chaxun){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver"); /*com.mysql.cj.jdbc.Driver*/
            }
            catch (Exception b){
                System.out.println("无法加载驱动程序");
            }
            try {
                Connection con = DriverManager.getConnection(url,"root","SAMAsama");
                Statement stmt=con.createStatement(); //建立Statement对象
                ResultSet rs=stmt.executeQuery("SELECT * FROM test.word");//执行对象stmt的SQL命令“select  * from users”



                if(shurukuang.getText().charAt(0)>=97&&shurukuang.getText().charAt(0)<=122){
                    while (rs.next()){

                        if(rs.getString(1).equalsIgnoreCase(shurukuang.getText()))
                            xianshi.setText(rs.getString(2));
                        if (xianshi.isValid())xianshi.setText("数据库中无此单词");
                    }

                    rs.close();
                    stmt.close();
                }
                else {
                    while (rs.next()){
                        String a=rs.getString(2);
                        String[] b =a.split("\\、");
                        for(int i=0;i<b.length;i++) {
                            if (b[i].equals(shurukuang.getText())){
                                xianshi.setText(rs.getString(1));
                            }

                        }
                        if (xianshi.isValid())xianshi.setText("数据库中无此单词");
                    }

                    rs.close();
                    stmt.close();
                }
            } catch (SQLException a) {

                System.out.println("SQL异常");
            }

        }
    }
    public static void main(String[] args){
        new Translate();
    }
}
