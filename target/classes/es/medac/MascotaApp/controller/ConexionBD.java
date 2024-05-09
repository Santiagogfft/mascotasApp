package es.medac.MascotaApp.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Michael Santiago Jara Castro.
 * @author Jhonatan Caro.
 * @author Casimiro Ochaga.
 * Esta clase sera la encargada de realizar la conexión entre el programa y la base de datos local utilizando unas
 * variables estaticas con un usuario administrador para poder acceder a esta y el url de la BD.
 */
public class ConexionBD {
    protected Connection conexionBD;
    private final String usuario = "admin";
    private final String contraseña = "1234";
    private final String url = "jdbc:mysql://localhost:3306/mascotasapp";
    /**
     * Establece la conexiòn con la BD para poder realizar las consultas o modificaciones
     * necesarias por el programa.
     * @return el return regresa la conexión a la base de datos para poder ser utilizada.
     */
    public Connection getConexion(){
        try {
            conexionBD = (Connection) DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conexión Exitosa");
        } catch (SQLException fallo){
            System.err.println("Conexión fallida: "+ fallo.getMessage());
        }
        return conexionBD;
    }
    
    
    /**
     * Metodo diseñado para cerrar la conexión a la base de Datos, este metodo debera
     * ejecutarse cada vez que se realice un proceso donde se realice una nueva conexion con la base de datos.
     */
    public void closeConexion(){
        try{
            this.conexionBD.close();
        }catch(SQLException notClose){
            System.err.println("Error al cerrar la conexión: "+notClose.getMessage());
        }
    }
}
