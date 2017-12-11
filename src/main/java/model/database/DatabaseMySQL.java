package model.database;

 
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


import com.mysql.jdbc.Connection;

/**
 *
 * @author cassioseffrin
 */
public class DatabaseMySQL   {

    private static Connection connection;
 
    
    public static Connection getConnection(){
        if (connection == null){
            return conectar();
        }else{
            return connection;
        }
    }
    
    private static Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
             connection = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/veterinaria", "root","123");
            return  connection;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DatabaseMySQL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

 
    private void desconectar() {
        try {
            this.connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
