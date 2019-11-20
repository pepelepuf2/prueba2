package Conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Javier Chamorro
 */
public class Conexion {
    public static Conexion InstConn;
    private Connection conn;
    
    private Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso?zeroDateTimeBehavior=convertToNull","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public synchronized static Conexion InstanciaConn(){
        if (InstConn==null){
            InstConn = new Conexion();
        
        }
        return InstConn;
    
    }

    public Connection getConn() {
        return conn;
    }
    
    public void Cerrar(){
        InstConn = null;
    }
    
    
    
}

