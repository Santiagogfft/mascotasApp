package es.medac.MascotaApp.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *Esta clase se encargara de las consultas DML basicas de la tabla Clientes contando con variables constantes que 
 * tendran las consultas que se realizaran y los metodos que se encargaran de realizar los DML de la tabla
 * @author Michael Santiago Jara Castro
 * @author Jhonatan Caro
 * @author Casimiro Ochaga 
 */
public class DMLClientes {
    private final Connection conexionBD;
    
    private final String insertAll = "INSERT INTO CLIENTES VALUES(?, ?, ?, ?);";
    private final String deleteId = "DELETE FROM CLIENTES WHERE idCliente = ?;";
    private final String updateAll = "UPDATE CLIENTES SET primerApellido = ?, cuentaBanco = ?, telefono = ? WHERE idCliente = ?;";
    private final String updateTel = "UPDATE CLIENTES SET telefono = ? WHERE idCliente = ?;";
    private final String updateCB = "UPDATE CLIENTES SET cuentaBanco = ? WHERE idCliente = ?;";
    
    public DMLClientes(){
        this.conexionBD = new ConexionBD().getConexion();
    }
    
    public boolean existenciaCliente(int idC){
        try(PreparedStatement pS = conexionBD.prepareStatement("SELECT idCliente FROM clientes WHERE idCliente = ?;")){
            pS.setInt(1, idC);
            ResultSet rs = pS.executeQuery();
            int id = rs.getInt("idCliente");
            if(id == idC){
                pS.close();
                conexionBD.close();
                System.out.println("Conexion cerrada");
                return true;
            }else{
                pS.close();
                conexionBD.close();
                System.out.println("Conexion cerrada");                
                return false;
            }
        }catch(SQLException eSQL){
            System.err.println("Error:"+eSQL.getMessage());
            return false;
        }
    }
    
    /**
     * Metodo encargado de la inserccion de la tabla clientes, contando con los distintos parametros respectivos a los campos que
     * tiene la tabla clientes.
     * @param idC
     * @param pA
     * @param cB
     * @param t 
     * @return  
     */
    public boolean insertAll(int idC, String pA, String cB, int t){
        try(PreparedStatement pS = conexionBD.prepareStatement(insertAll)){
            pS.setInt(1, idC);
            pS.setString(2, pA);
            pS.setString(3, cB);
            pS.setInt(4, t);
            int fI = pS.executeUpdate();
            if(fI > 0){
                System.out.println("Insercción Exitosa");
                pS.close();
                conexionBD.close();
                System.out.println("Conexion cerrada");
                return true;                  
            }            
            pS.close();
            System.out.println("Conexion cerrada");
            return false;
        }catch(SQLException errorInsert){
            System.err.println("Error al insertar:"+ errorInsert.getMessage());
            return false;
        }
    }
    /**
     * 
     * @param idC 
     * @return  
     */
    public boolean deleteid(int idC){
        try(PreparedStatement pS = conexionBD.prepareStatement(deleteId)){
            pS.setInt(1, idC);
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
        }catch(SQLException errorDelete){
            System.err.println("Error al eliminar:"+errorDelete.getMessage());
            return false;
        }
    }
    /**
     * 
     * @param idC
     * @param pA
     * @param bC
     * @param t 
     * @return  
     */
    public boolean updateAll(int idC, String pA, String bC, int t){
        try(PreparedStatement pS = conexionBD.prepareStatement(updateAll)){
            pS.setString(1, pA);
            pS.setString(2, bC);
            pS.setInt(3, t);
            pS.setInt(4, idC);
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
        }catch(SQLException errorUpdate){
            System.err.println("Error al actualizar:"+errorUpdate.getMessage());
            return false;
        }
    }
    /**
     * 
     * @param idC
     * @param t 
     * @return  
     */
    public boolean updateTel(int idC, int t){
        try(PreparedStatement pS = conexionBD.prepareStatement(updateTel)){
            pS.setInt(1, t);
            pS.setInt(2, idC);
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
        }catch(SQLException errorUpdate){
            System.err.println("Error al actualizar:"+errorUpdate.getMessage());
            return false;
        }
    }
    /**
     * 
     * @param idC
     * @param cB 
     * @return  
     */
    public boolean updateCB(int idC, String cB){
        try(PreparedStatement pS = conexionBD.prepareStatement(updateCB)){
            pS.setString(1, cB);
            pS.setInt(2, idC);
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
        }catch(SQLException errorUpdate){
            System.err.println("Error al actualizar:"+errorUpdate.getMessage());
            return false;
        }
    }
    public boolean updateSpecific(int idC, String col, Object T){
        if(T instanceof String cad){
            try(PreparedStatement pS = conexionBD.prepareStatement("UPDATE CLIENTES SET "+col+" = ? WHERE idCliente = ?;")){
                pS.setString(1, cad);
                pS.setInt(2, idC);
                int fI = pS.executeUpdate();
                if(fI > 0){
                System.out.println("Actualizacion Exitosa");
                pS.close();
                conexionBD.close();
                System.out.println("Conexion cerrada");
                return true;                  
                }
            }catch(SQLException eInsert){
                System.err.println("Error al insertar:"+eInsert.getMessage() );
                return false;
            }
        }else if(T instanceof Integer num ){
                try(PreparedStatement pS = conexionBD.prepareStatement("UPDATE CLIENTES SET "+col+" = ? WHERE idCliente = ?;")){
                pS.setInt(1, num);
                pS.setInt(2, idC);
                int fI = pS.executeUpdate();
                if(fI > 0){
                System.out.println("Actualizacion Exitosa");
                pS.close();
                conexionBD.close();
                System.out.println("Conexion cerrada");
                return true;                  
                }
            }catch(SQLException eInsert){
                System.err.println("Error al insertar:"+eInsert.getMessage() );
                return false;
            }
        }else{
            System.err.println("Error al elegir el tipo de variable");
            return false;
        }
        return false;
    }
    
}
