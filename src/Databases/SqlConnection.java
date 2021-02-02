package Databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection {

  public Connection getConnection() throws SQLException {
    Connection connection;
    connection= DriverManager.getConnection("jdbc:mysql://localhost/javastock", "root", "");
  return connection;
}







}






//    public void Connection () throws ClassNotFoundException, SQLException {
////       Class.forName("com.mysql.jdbc.Driver");
//       Connection connection =
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("select * from etudiants");
//
//
//
//}
