package es.medac.MascotaApp.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

/**
 *
 * @author Michael Santiago Jara Castro
 * @author Jhonatan Caro
 * @author Casimiro Ochaga
 */
public class DMLVacunas {
    private final Connection conexionBD;
    
    private final String insertAll = "INSERT INTO VACUNAS VALUES (?, ?, ?, ?);";
    private final String deleteidM = "DELETE FROM VACUNAS WHERE idMascota = ?;";
    private final String updateAll = "UPDATE VACUNAS SET fechaVacuna = ?, enfermedad = ?, fechaProxima = ? WHERE idMascota = ?;";
    
    public DMLVacunas(){
        this.conexionBD = new ConexionBD().getConexion();
    }
    /**
     * 
     * @param idMascota
     * @param f
     * @param e
     * @param fP
     * @return 
     */
    public boolean insertAll(int idMascota, java.sql.Date f, String e, Date fP){
        try(PreparedStatement pS = conexionBD.prepareStatement(insertAll)){
            pS.setInt(1, idMascota);
            pS.setDate(2, f);
            pS.setString(3, e);
            pS.setDate(4, fP);
            int fI = pS.executeUpdate();
            if(fI > 0){
                Consultas c = new Consultas();
                DMLMascotas m = new DMLMascotas();
                int numVac = c.numVacunas(idMascota)+fI;
                m.updateVacunaciones(idMascota, numVac);                
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
     * @param idM 
     * @return  
     */
    public boolean deleteidM(int idM){
        try(PreparedStatement pS = conexionBD.prepareStatement(deleteidM)){
            pS.setInt(1, idM);
            int fI = pS.executeUpdate();
            if(fI > 0){
                Consultas c = new Consultas();
                DMLMascotas m = new DMLMascotas();
                int numVac = c.numVacunas(idM)-fI;
                m.updateVacunaciones(idM, numVac);
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
    /**
     * 
     * @param idMascota
     * @param f
     * @param e
     * @param fP
     * @return 
     */
    public boolean updateAll(int idMascota, java.sql.Date f, String e, Date fP){
        try(PreparedStatement pS = conexionBD.prepareStatement(updateAll)){
            pS.setDate(1, f);
            pS.setString(2, e);
            pS.setDate(3, fP);
            pS.setInt(4, idMascota);
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
    
    public boolean updateFechaProx(int idM, Date fVP){
        try(PreparedStatement pS = conexionBD.prepareStatement("UPDATE VACUNAS SET fechaProxima = ? WHERE idMascota = ?;")){
            pS.setDate(1, fVP);
            pS.setInt(2, idM);
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
        }catch(SQLException eInsert){
            System.err.println("Error al insertar:"+eInsert.getMessage());
            return false;
        }
    }
}
