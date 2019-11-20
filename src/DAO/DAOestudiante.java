
package DAO;
import Conexion.Conexion;
import Curso.Estudiante;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOestudiante {
    
    private static String sql_insert = "insert into estudiante (rut,nombre,promedio) values (?,?,?)";
    private static String sql_update = "update estudiante set nombre= ?,promedio =? where rut=?";
    private static String sql_delete = "delete * from estudiante where rut =?";
    private static String sql_selectAll = "select * from estudiante";
    private static String sql_mejorPromedio = "select promedio from estudiante where peromedio=?";
      
    private static Conexion objConn = Conexion.InstanciaConn();
    private ResultSet rs;
    
      
      
    public boolean Crear(Estudiante e){
        PreparedStatement ps;
        try {
            
            
            ps = objConn.getConn().prepareStatement(sql_insert);
            ps.setInt(1, e.getRut());
            ps.setString(2, e.getNombre());
            ps.setFloat(3, e.getPromedio());
            
            if(ps.executeUpdate()>0){
                return true;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOestudiante.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
        
            objConn.Cerrar();
        }
        
        return false;
    
    }


    public boolean modificar(Estudiante e){
        try {
            PreparedStatement ps;
            
            ps = objConn.getConn().prepareStatement(sql_update);
            ps.setString(1, e.getNombre());
            ps.setFloat(2, e.getPromedio());
            ps.setInt(3, e.getRut());
            
            if(ps.executeUpdate() >0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOestudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
        return false;

        }
    
    // elimina un estudiante
    public boolean eliminar(Estudiante e){
          try {
            PreparedStatement ps;
            
            ps = objConn.getConn().prepareStatement(sql_delete);
            
            ps.setInt(1, e.getRut());
            
     
        }catch (SQLException ex) {
            Logger.getLogger(DAOestudiante.class.getName()).log(Level.SEVERE, null, ex);
              
        }
        return false;
      
    }


      
    public ArrayList<Estudiante> todosEstudiantes(){
        try {
            ArrayList<Estudiante> LPers = new ArrayList();
            PreparedStatement ps;
            
            
            ps = objConn.getConn().prepareStatement(sql_selectAll);
            rs = ps.executeQuery();
            
            while(rs.next()){
                LPers.add(new Estudiante(rs.getInt("rut"), rs.getString("nombre"),rs.getFloat("promedio")));
            }
            
            return LPers;
        } catch (SQLException ex) {
            Logger.getLogger(DAOestudiante.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        
            objConn.Cerrar();
        }
        
        return null;
    }
    
      
    public boolean mejorEstudiantePeorEstudiante(Estudiante e, float peorNota, float mejorNota) {
        try {
            PreparedStatement ps;
            ps = objConn.getConn().prepareStatement(sql_mejorPromedio);
            for(int i = 0; i<todosEstudiantes().size(); i++) {
                if (ps.setFloat(1, e.getPromedio()) > mejorNota) {
                    mejorNota = e.getPromedio();
                }
            }
        } catch(SQLException ex) {
            System.out.println(ex);
        }
      }
     
      
    
      
      
      
      
}
