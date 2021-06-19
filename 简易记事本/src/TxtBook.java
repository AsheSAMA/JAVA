import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class TxtBook extends JFrame implements ActionListener {
    JButton newFileButton, openButton, saveButton, otherButton, quitButton;
    JMenuBar jMenuBar;
    JMenu fileMenu, editMenu, helpMenu;
    JTextArea jTextArea;
    String Address;
    FileDialog save, open;
    JDialog jDialog;
    JLabel YesOrNo;
    JButton YES,NO;
    boolean flag=false;//若是用flag判定，思维更清晰？

    //记事本主窗体
    TxtBook() {
        //创建菜单
        this.setLayout(null);
        jMenuBar = new JMenuBar();
        jMenuBar.setSize(400, 50);
        fileMenu = new JMenu("文件");
        editMenu = new JMenu("编辑");
        helpMenu = new JMenu("帮助");
        fileMenu.setSize(100, 50);
        editMenu.setSize(100, 50);
        helpMenu.setSize(100, 50);
        //创建5个按钮
        newFileButton = new JButton("新建");
        openButton = new JButton("打开");
        saveButton = new JButton("保存");
        otherButton = new JButton("另存为");
        quitButton = new JButton("退出");
        //为5个按钮创建监视器
        newFileButton.addActionListener(this);
        openButton.addActionListener(this);
        saveButton.addActionListener(this);
        otherButton.addActionListener(this);
        quitButton.addActionListener(this);
        //将8个东西装入菜单
        fileMenu.add(newFileButton);
        fileMenu.add(openButton);
        fileMenu.add(saveButton);
        fileMenu.add(otherButton);
        fileMenu.add(quitButton);
        jMenuBar.add(fileMenu);
        jMenuBar.add(editMenu);
        jMenuBar.add(helpMenu);
        //创建TextArea
        jTextArea = new JTextArea();
        jTextArea.setSize(400, 350);
        jTextArea.setLocation(0, 50);
        //TextArea的字体
        jTextArea.setFont(new Font("Serif", Font.PLAIN, 20));


        //总加入
        this.setTitle("记事本");
        this.add(jMenuBar);
        this.add(jTextArea);
        this.setSize(400, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }

    //保存弹窗
    /*static String mingzi;
        JDialog jDialog;
        JLabel shuru;
        JTextField saveAddress;
        JButton baocun;
        FlowLayout flowLayout;
        JFileChooser jFileChooser;*/
    /*void inittanchaung(){
        jDialog=new JDialog();
        flowLayout=new FlowLayout(FlowLayout.LEFT,20,20);
        jDialog.setLayout(flowLayout);
        shuru=new JLabel("请输入名字+后缀名");
        baocun=new JButton("保存");
        saveAddress =new JTextField(15);


        jDialog.add(shuru);
        jDialog.add(saveAddress);
        jDialog.add(baocun);
        saveAddress.setSize(50,20);

        jDialog.setSize(450,150);
        jDialog.setVisible(true);

        baocun.addActionListener(this);
    }*/

    //另存为弹窗
    void initSaveAs() {
        save = new FileDialog(this, "另存为", 1);
        save.setVisible(true);
    }

    //打开弹窗
    void initOpenAs() {
        open = new FileDialog(this, "打开", 0);
        open.setVisible(true);
    }

    //监听器创建
    public void actionPerformed(ActionEvent e) {
        //新建按钮监听器-------已完成
        if (e.getSource() == newFileButton) {
            new TxtBook();
        }
        //打开按钮监听器-------已完成
        if (e.getSource() == openButton) {
            initOpenAs();
            openAS();
        }
        //另存为按钮监听器-------已完成
        if (e.getSource() == otherButton) {
            initSaveAs();
            if (this.getTitle() == "记事本") {
                saveAs();
            }else savedontAs();
        }
        //退出按钮监听器-------已完成
        if (e.getSource() == quitButton) {
            initQuit();

        }
        //保存按钮监听器-------已完成
        if (e.getSource() == saveButton) {
            if (this.getTitle() == "记事本") {
                initSaveAs();
                saveAs();
            }
            else save();
        }
        //是按钮监听器-------已完成
        if (e.getSource()==YES){
            if (Address==null){
                initSaveAs();
                saveAs();
            }else save();
            xiaohui();
        }
        //否按钮监听器-------已完成
        if(e.getSource()==NO){
            xiaohui();
        }
        /*if (e.getSource()==baocun){
            TxtBook.mingzi=saveAddress.getText();
            jDialog.dispose();
            this.setTitle(mingzi);
            save();}*/


}
    //销毁
    void xiaohui(){
        jDialog.dispose();
        this.dispose();
    }

    //打开
    public void openAS(){
        File file=new File(open.getDirectory(),open.getFile());
        this.setTitle(open.getFile());
        String s;
        FileReader Reader;
        try{
            Reader=new FileReader(file);
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file),"UTF-8");
            BufferedReader br = new BufferedReader(inputStreamReader);
            while ((s=br.readLine())!=null){
                jTextArea.setText(s+"\n");
            }
            Address=file.getPath();
            br.close();

            Reader.close();
        }catch (Exception e){System.out.println("openAS报错");}
    }

    //创建离开窗口
    void initQuit(){
        jDialog=new JDialog();
        YesOrNo=new JLabel("是否需要保存");
        YES=new JButton("是");
        NO=new JButton("否");
        jDialog.setLayout(null);
        jDialog.setSize(500,200);
        jDialog.setVisible(true);
        jDialog.add(YesOrNo);
        jDialog.add(YES);
        jDialog.add(NO);
        YesOrNo.setSize(100,50);
        YES.setSize(100,40);
        NO.setSize(100,40);
        YesOrNo.setLocation(210,20);
        YES.setLocation(100,100);
        NO.setLocation(300,100);
        YES.addActionListener(this);
        NO.addActionListener(this);

    }

    //保存的方法
    public void save(){

        File file=new File(Address);
        FileWriter writer;
        try{
            writer=new FileWriter(file);
            writer.write(jTextArea.getText());
            writer.flush();
            writer.close();
        }catch (Exception e){System.out.println("save报错");}
    }

    //另存为的方法
    public void saveAs(){
        File file=new File(save.getDirectory(),save.getFile());
        FileWriter writer;
        try{
            writer=new FileWriter(file);
            writer.write(jTextArea.getText());
            writer.flush();
            writer.close();
        }
        catch (Exception e){System.out.println("saveAs报错");}
        this.setTitle(save.getFile());
        Address=file.getPath();
    }
    //另存为中没有改地址的方法
    public void savedontAs(){
        File file=new File(save.getDirectory(),save.getFile());
        FileWriter writer;
        try{
            writer=new FileWriter(file);
            writer.write(jTextArea.getText());
            writer.flush();
            writer.close();
        }
        catch (Exception e){System.out.println("savedontAs报错");}
    }
    //主方法
    public static void main(String[] args){
        new TxtBook();
    }


}

