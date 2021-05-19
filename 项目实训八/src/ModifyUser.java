import  javax.swing.*;
import  java.awt.event.*;
import  java.sql.*;
public  class  ModifyUser extends JFrame implements ActionListener{
    JPanel pnlMain;
    JLabel lblName,lblPass;
    JTextField txtName,txtPass;
    JButton  btnInsert,btnUpdate,btnDelete,btnNext;
    Connection conn;
    ResultSet  rs;
    public ModifyUser( ){
        super("用户数据的增-删-改");
        pnlMain=new JPanel();
        lblName=new JLabel("用户名：");
        lblPass=new JLabel("密  码：");
        txtName=new JTextField(16);
        txtPass=new JTextField(16);
        btnInsert=new JButton("插入");
        btnInsert.addActionListener(this);
        btnUpdate=new JButton("修改");
        btnUpdate.addActionListener(this);
        btnDelete=new JButton("删除");
        btnDelete.addActionListener(this);
        btnNext=new JButton(">>");
        btnNext.addActionListener(this);
        pnlMain.add(lblName);
        pnlMain.add(lblPass);
        pnlMain.add(txtName);
        pnlMain.add(txtPass);
        pnlMain.add(btnInsert);
        pnlMain.add(btnUpdate);
        pnlMain.add(btnDelete);
        pnlMain.add(btnNext);
        setContentPane(pnlMain);
        setSize(280,150);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource(  )==btnInsert)
            insertUser(  );
        if (ae.getSource( )==btnUpdate)
            updateUser(  );
        if (ae.getSource(  )==btnDelete){
            int intChoice=JOptionPane.showConfirmDialog(
                    null,"确定要删除该记录吗？","确认删除",
                    JOptionPane.YES_NO_OPTION);
            if (intChoice==JOptionPane.YES_OPTION)
                deleteUser();
        }
        if (ae.getSource()==btnInsert){
            try{
                rs.next(  );
                txtName.setText(rs.getString(1));
                txtPass.setText(rs.getString(2));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"数据获取错误");
            }
        }
    }
    public Connection openDB(){
        try{
            Class.forName("jdbc.odbc.JdbcOdbcDriver");    //加载驱动程序jdbc.odbc.JdbcOdbcDriver
            conn= DriverManager.getConnection("jdbc:odbc:HappyChat","sa","123456"); //建立数据库连接，连接HappyCha，用户sa,密码123456
            return conn;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"连接数据库失败！");
            return  null;
        }
    }
    public void getUser(){
        try{
            Statement  stmt=openDB().createStatement();
            rs=stmt.executeQuery("select  * from users"); //查询数据库表users中数据的SQL语句
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"用户信息获取失败！");
        }

    }
    public void insertUser(){
        try{
            PreparedStatement psm=openDB().prepareStatement(
                    "Insert users(U_Name,U_Pass) value(?,?)");
            psm.setString(1,txtName.getText());
            psm.setString(2,txtPass.getText());
            psm.executeUpdate();
            JOptionPane.showMessageDialog(null,"用户信息添加成功！");
            psm.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"用户信息添加失败！");
        }
    }
    public void updateUser(){
        try{
            Statement sm=openDB().createStatement();
            String strUpdate="update users set U_Pass='"+txtPass.getText()+
                    "' where U_Name='"+txtName.getText()+"'";
            sm.executeUpdate(strUpdate);
            JOptionPane.showMessageDialog(null,"用户信息修改成功！");
            sm.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"用户信息添加失败！");
        }
    }
    public void deleteUser(){
        try{
            Statement sm=openDB().createStatement();
            sm.executeUpdate("delete from users where U_Name='"+txtName.getText()+"'");
            JOptionPane.showMessageDialog(null,"用户信息删除成功！");
            sm.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"用户信息删除失败！");
        }
    }
    public static void main(String args[]){
        ModifyUser mu=new ModifyUser();
        mu.getUser();
    }
}
