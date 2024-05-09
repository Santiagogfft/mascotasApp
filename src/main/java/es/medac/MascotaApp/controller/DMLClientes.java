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
    /**
     * Este metodo es un complemento de otro que se encarga de consultar el id del cliente pedido como parametro devolviendo
     * true en dado caso en el que este id exista ya registrado en la BD y false en caso de que no se encuentre en la BD.
     * @param idC
     * @return 
     */
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
     * Este metodo se encargara de eliminar el cliente de nuestra BD por el id que le pasemos como parametro
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
     * Este metodo sirve para actualizar todos los datos del cliente el cual coincida con el id pasado
     * como parametro y actualizando los datos en la bd cambiando los valores de la bd por los pasados
     * como parametro
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
     * Este metodo sirve para actualizar el telefono del usuario, se le pasa como parametro el id del cliente y 
     * el nuevo numero que se le quiere asignar y este metodo cambiara el telefono del cliente con el id en la BD
     * @param idC id para modificar el cliente 
     * @param t parametro que remplazara el valor del telefono en la BD del cliente
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
     * Este metodo sirve para actualizar la cuenta de banco del cliente con el que el id coincida con el pasado en el parametro
     * actualizando su cuenta de banco en la bd por el nuevo valor pasado como parametro
     * @param idC id que concidira con el cliente
     * @param cB nuevo valor de la cuenta de banco del cliente
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
    /**
     * Este metodo actualiza los datos de manera especifica dependiendo del tipo de dato que sea
     * cuenta con distintos tipos de updates en los cuales se le pasan 3 parametros para funcionar, el primero sera
     * el id a actualizar, el segundo la columna que se quiere modificar y el tercero tipo Objecto el valor a asignar, por
     * medio de un if se filtrara para ver si es de tipo String y Int y cual tipo de insercción se hara.
     * @param idC id del cliente que se desea modificar
     * @param col columna de la tabla que se desea modificar
     * @param T valor generico que se pasara para insertar
     * @return 
     */
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
