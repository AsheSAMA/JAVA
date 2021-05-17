import static net.mindview.util.SwingConsole.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Calculator extends JFrame {
    public void go(){
        JFrame frame=new JFrame();
        JPanel panel1=new JPanel();
        JPanel panel2=new JPanel();
        panel1.setBackground(Color.red);
        panel1.setSize(200,200);
        panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
        JButton b1=new JButton("+");
        JButton b2=new JButton("-");
        JButton b3=new JButton("x");
        JButton b4=new JButton("÷");
        b1.setSize(100,20);
        b2.setSize(50,20);
        b3.setSize(50,20);
        b4.setSize(50,20);
        panel1.add(b1);
        panel1.add(b2);
        panel1.add(b3);
        panel1.add(b4);
        frame.getContentPane().add(BorderLayout.EAST,panel1);
        frame.setSize(400,400);
        frame.setVisible(true);
        TextField text1=new TextField();
        TextField text2=new TextField();
        TextField text3=new TextField();
        text1.setFont(new Font("宋体",Font.BOLD,30));
        text2.setFont(new Font("宋体",Font.BOLD,30));
        text3.setFont(new Font("宋体",Font.BOLD,30));
        text1.setSize(50,20);
        text2.setSize(50,20);
        text3.setSize(50,20);
        panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
        frame.getContentPane().add(BorderLayout.CENTER,panel2);
        panel2.add(text1);
        panel2.add(text2);
        panel2.add(text3);
            b1.addActionListener(e -> {
                try {
                    double n1 = Double.parseDouble(text1.getText());
                    double n2 = Double.parseDouble(text2.getText());
                    text3.setText("" + (n1 + n2));
                }
                catch (java.lang.NumberFormatException a){
                    text3.setText("还没输好呢");
                }
        });
            b2.addActionListener(e -> {
                try {
                    double n1 = Double.parseDouble(text1.getText());
                    double n2 = Double.parseDouble(text2.getText());
                    text3.setText("" + (n1 - n2));
                }catch (java.lang.NumberFormatException a){
                    text3.setText("还没输好呢");
                }
            });
            b3.addActionListener(e -> {
                try {
                    double n1 = Double.parseDouble(text1.getText());
                    double n2 = Double.parseDouble(text2.getText());
                    text3.setText("" + (n1 * n2));
                }
                catch (java.lang.NumberFormatException a){
                    text3.setText("还没输好呢");
                }
            });
            b4.addActionListener(e -> {
                try {
                    double n1 = Double.parseDouble(text1.getText());
                    double n2 = Double.parseDouble(text2.getText());
                    text3.setText("" + (n1 / n2));
                }
                catch (java.lang.NumberFormatException a){
                    text3.setText("还没输好呢");
                }
            });
        }
    public static void main(String[] args){
        Calculator calculator=new Calculator();
        calculator.go();
    }
}