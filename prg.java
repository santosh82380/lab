import java.sql.*;
class prg{
public static void main(String args[]){

try{

Class.forName("oracle.jdbc.driver.OracleDriver");

Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","cs045","1da19cs045");

Statement stmt=con.createStatement();
//String sql1=("insert into Books values(12,'Java Programming','Herbert',9,'TMH')");
//String sql2=("update Books set edition=9 where Bid=1432");
//String sql3=("Delete from Books where Bid=12345");
String sql=("select * from Books");
//ResultSet rs2=stmt.executeQuery(sql1);
//ResultSet rs3=stmt.executeQuery(sql2);
//ResultSet rs4=stmt.executeQuery(sql3);
ResultSet rs=stmt.executeQuery(sql);


while(rs.next())
{
System.out.println(rs.getInt(1)+ " " +rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5) );

}
con.close();

}catch(Exception e)
{

System.out.println(e);
}
}
}
