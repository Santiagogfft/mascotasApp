package es.medac.MascotaApp.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author Michael Santiago Jara Castro
 * @author Jhonatan Caro
 * @author Casimiro Ochaga
 */
public class DMLPesos {
    private final Connection conexionBD;
    
    private final String insertAll = "INSERT INTO PESOS VALUES(?, ?, ?);";
    private final String deleteidM = "DELETE FROM PESOS WHERE idMascota = ?;";
    private final String updateAll = "UPDATE PESOS SET fechaPesado = ?, peso = ? WHERE idMascota = ?;";
    
    public DMLPesos(){
        this.conexionBD = new ConexionBD().getConexion();
    }
    /**
     * 
     * @param idMascota
     * @param f
     * @param ps
     * @return 
     */
    public boolean insertAll(int idMascota, Date f, double ps){
        try(PreparedStatement pS = conexionBD.prepareStatement(insertAll)){
            pS.setInt(1, idMascota);
            pS.setDate(2, f);
            pS.setDouble(3, ps);
            int fI = pS.executeUpdate();
            if(fI > 0){
                System.out.println("Inserccion Exitosa");
                pS.close();
                conexionBD.close();
                System.out.println("Conexion cerrada");
                return true;                  
            }            
            pS.close();
            System.out.println("Conexion cerrada");
            return false;
        } catch (SQLException errorInsert){
            System.err.println("Error al insertar: "+errorInsert.getMessage());
            return false;
        }
    }
    /**
     * 
     * @param idMascota 
     * @return  
     */
    public boolean deleteidM(int idMascota){
        try(PreparedStatement pS = conexionBD.prepareStatement(deleteidM)){
            pS.setInt(1, idMascota);
            int fI = pS.executeUpdate();
            if(fI > 0){
                System.out.println("Eliminacion Exitosa");
                pS.close();
                conexionBD.close();
                System.out.println("Conexion cerrada");
                return true;                  
            }            
            pS.close();
            System.out.println("Conexion cerrada");
            return false;
        } catch (SQLException errorInsert){
            System.err.println("Error al eliminar: "+errorInsert.getMessage());
            return false;
        }
    }
    
    public boolean updateAll(int idMascota, Date f, double ps){
        try(PreparedStatement pS = conexionBD.prepareStatement(updateAll)){
            pS.setDate(1, f);
            pS.setDouble(2, ps);
            pS.setInt(3, idMascota);
            int fI = pS.executeUpdate();
            if(fI > 0){
                System.out.println("Actualizacion Exitosa");
                pS.close();
                conexionBD.close();
                System.out.println("Conexion cerrada");
                return true;                  
            }            
            pS.close();
            System.out.println("Conexion cerrada");
            return false;
        } catch (SQLException errorInsert){
            System.err.println("Error al actualizar: "+errorInsert.getMessage());
            return false;
        }
    }
    
}
