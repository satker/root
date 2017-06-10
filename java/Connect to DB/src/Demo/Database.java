package Demo;

import java.sql.*;

public class Database {
     public static String getData() {
         String result = "";
         try {
             Class.forName("org.postgresql.Driver");
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         }

         String connectionString = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=postgres";
         try {
             Connection connection = DriverManager.getConnection(connectionString);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from pizza");
              result = "<table>";
             while (resultSet.next()){
               result += "<tr><td>" + resultSet.getString("name") + "</td></tr>";
             }
             result += "</table>";

         } catch (SQLException e) {
             e.printStackTrace();
         }

         return result;
    }


}
