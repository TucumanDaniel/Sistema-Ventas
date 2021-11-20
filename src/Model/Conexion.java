
package Model;

import java.sql.*;


public class Conexion {
    
    Connection con;
    
    public Connection getConnection(){
        try{
            String myBD ="jdbc:mysql://localhost:3306/sistemaventa?serverTimezone=UTC";
            con = DriverManager.getConnection(myBD, "root", "");
            return con;
        }catch (SQLException e){
            System.out.println(e.toString());
        }
        return null;
    }
    
}
