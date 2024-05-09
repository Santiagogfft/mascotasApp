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
public class DMLMascotas {
    private final Connection conexionBD;
    
    private final String insertAll = "INSERT INTO MASCOTAS VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    private final String deleteIdM = "DELETE FROM MASCOTAS WHERE idMascota = ?;";
    private final String updateAll = "UPDATE MASCOTAS SET idCliente = ?, aliasMascota = ?, especie = ?, raza = ?, colorPelo = ?, fechaNacimiento = ?, vacunaciones = ? WHERE idMascota = ?;";
    
    public DMLMascotas(){
        this.conexionBD = new ConexionBD().getConexion();
    }
    /**
     * Este metodo esta diseñado para insertar una mascota nueva en la BD de datos, este ingresara
     * todos los datos pasados como parametro los cuales son los mismos campos que tiene la tabla
     * mascotas de la bd
     * @param idMascota
     * @param idCliente
     * @param aliasMascota
     * @param especie
     * @param raza
     * @param colorPelo
     * @param fechaNacimiento
     * @param vacunaciones
     * @return 
     */
    public boolean insertAll(int idMascota, int idCliente, String aliasMascota, String especie, String raza, String colorPelo, Date fechaNacimiento, int vacunaciones){
        try (PreparedStatement pS = conexionBD.prepareStatement(insertAll)){
            pS.setInt(1, idMascota); //Inserccion de Datos
            pS.setInt(2, idCliente);
            pS.setString(3, aliasMascota);
            pS.setString(4, especie);
            pS.setString(5, raza);
            pS.setString(6, colorPelo);
            pS.setDate(7, fechaNacimiento);
            pS.setInt(8, vacunaciones);
            Consultas c = new Consultas();            
            if(c.filtroCliente(idCliente) == true){
                int fI =pS.executeUpdate();
                if(fI > 0){
                System.out.println("Insercción Exitosa");
                pS.close();
                conexionBD.close();
                System.out.println("Conexion cerrada");
                return true;                  
                }                
            }else{
                System.err.println("El Cliente no esta registrado");
                return false;
            }         
            pS.close();
            System.out.println("Conexion cerrada");
            return false;
        }catch(SQLException errorInsert){
            System.err.println("Error al insertar: "+errorInsert.getMessage());
            return false;
        }
    }
    /**
     * Este metodo permitira eliminar una mascota mediante el id pasado como parametro
     * @param idMascota id que permite realizar la eliminación
     * @return  
     */
    public boolean deleteIdM(int idMascota){
        try(PreparedStatement pS = conexionBD.prepareStatement(deleteIdM)){
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
        }catch (SQLException errorDelete){
            System.err.println("Error al eliminar: "+errorDelete.getMessage());
            return false;
        }
    }
    /**
     * Metodo que permite realizar una actualizacion de todos los datos de la mascota con el id pasado como parametro
     * este actualizara todos los campos de la mascota que coincida con el id, actualizando los anteriores valores por los
     * nuevos que son pasados como parametro
     * @param idMascota
     * @param idCliente
     * @param aliasMascota
     * @param especie
     * @param raza
     * @param colorPelo
     * @param fechaNacimiento
     * @param vacunaciones
     * @return 
     */
    public boolean updateAll(int idMascota, int idCliente, String aliasMascota, String especie, String raza, String colorPelo, Date fechaNacimiento, int vacunaciones) {
        try (PreparedStatement pS = conexionBD.prepareStatement(updateAll)){
            pS.setInt(1, idCliente);
            pS.setString(2, aliasMascota);
            pS.setString(3, especie);
            pS.setString(4, raza);
            pS.setString(5, colorPelo);
            pS.setDate(6, fechaNacimiento);
            pS.setInt(7, vacunaciones);
            pS.setInt(8, idMascota);
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
        }catch(SQLException errorInsert){
            System.err.println("Error al actualizar: "+errorInsert.getMessage());
            return false;
        }
    }
    /**
     * Este metodo sirve para actualizar especificamente el numero de vacunas de una mascota la cual concidira con
     * el id pasado como parametro
     * @param idM
     * @param vac
     * @return 
     */
    public boolean updateVacunaciones(int idM, int vac){
        try(PreparedStatement pS = conexionBD.prepareStatement("UPDATE MASCOTAS SET vacunaciones = ? WHERE idMascota = ?;")){
            pS.setInt(1, vac);
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
        }catch(SQLException errUpdate){
            System.err.println("Error al actualizar"+errUpdate.getMessage());
            return false;
        }
    }
    /**
     * Este metodo se encargara de realizar una actualizacion especifica dependiendo del tipo de dato que sea
     * tendra tres parametros el cual el primero sera el Id de la mascota la cual se quiere modificar, el segundo sera la
     * columna de la tabla mascotas que se desea modificar y el tercero el valor generico que tomara, en este caso dependiendo
     * de la instancia de la que sea el valor realizara un update especifico dependiendo de si es String, Integer, Double, Date y 
     * en caso de los Date tiene otros dos filtros, uno para cada tabla diferente pues estos actualizan valores de multiples tablas
     * @param idM id de mascota que se desea modificar
     * @param col columna de la tabla que se desea modificar
     * @param T valor generico que sera el que remplace el valor de la columna especificada de la mascota pedida
     * @return 
     */
    public boolean updateSpecific(int idM, String col, Object T){
        if(T instanceof String cad){
            try(PreparedStatement pS = conexionBD.prepareStatement("UPDATE MASCOTAS SET "+col+" = ? WHERE idMascota = ?;")){
                pS.setString(1, cad);
                pS.setInt(2, idM);
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
                try(PreparedStatement pS = conexionBD.prepareStatement("UPDATE MASCOTAS SET "+col+" = ? WHERE idMascota = ?;")){
                pS.setInt(1, num);
                pS.setInt(2, idM);
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
        }else if(T instanceof Double num ){
                try(PreparedStatement pS = conexionBD.prepareStatement("UPDATE PESOS SET "+col+" = ? WHERE idMascota = ?;")){
                pS.setDouble(1, num);
                pS.setInt(2, idM);
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
        }else if(T instanceof Date fec){
            if(col.equals("fechaVacuna")){
                try(PreparedStatement pS = conexionBD.prepareStatement("UPDATE VACUNAS SET "+col+" = ? WHERE idMascota = ?;")){
                pS.setDate(1, fec);
                pS.setInt(2, idM);
                int fI = pS.executeUpdate();
                if(fI > 0){
                fec.setYear(fec.getYear()+1);
                DMLVacunas v = new DMLVacunas();
                v.updateFechaProx(idM, fec);
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
            }else if(col.equals("fechaPesado")){
                try(PreparedStatement pS = conexionBD.prepareStatement("UPDATE PESOS SET "+col+" = ? WHERE idMascota = ?;")){
                pS.setDate(1, fec);
                pS.setInt(2, idM);
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
            }
        }else{
            System.err.println("Error al elegir el tipo de variable");
            return false;
        }
        return false;
    }
}