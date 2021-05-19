import  java.sql.*;
public  class QueryUser{
    public static void main(String  args[ ]){
        try{
             Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
             //加载驱动程序 sun.jdbc.odbc.JdbcOdbcDriver
        }catch (Exception e){
            System.out.println("无法载入JDBC驱动程序");
        }
        try{
            Connection conn=DriverManager.getConnection("jdbc:odbc:HappyChat","sa","123456");  //建立连接，字符串：“jdbc:odbc:HappyChat”,”sa”,”123456”
            Statement  stmt=conn.createStatement(); //建立Statement对象
            ResultSet rs=stmt.executeQuery("select  * from users");    //执行对象stmt的SQL命令“select  * from users”
             while (rs.next()){
            System.out.println(rs.getString(1)+"  "  +rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
        }
        rs.close();
        stmt.close( );
    }
    catch(SQLException  e){
        System.out.println("SQL异常");
    }
}
     }
