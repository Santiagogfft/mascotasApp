package es.medac.MascotaApp.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Michael Santiago Jara Castro.
 * @author Jhonatan Caro.
 * @author Casimiro Ochaga.
 * 
 */
public class InsertarFichero {
    
    protected Connection conexionBD;
    //Formato para poder pasar los valores String a tipo Date siguiendo el formato establecido
    SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
    
    //Conexion a la BD
    public InsertarFichero(){
        this.conexionBD = new ConexionBD().getConexion();
    }
    /**
     * Este metodo se le pasara como parametro la ruta del archivo la cual este leera y guardara el numero de Filas encontrados en
     * este, devolviendo un int del numero de filas encontrados esto con el fin de complementar
     * otro metodo
     * @param ruta
     * @return 
     */
    public int nF(String ruta){
        int nF = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(new File(ruta)))){
            while(br.readLine() != null){
                nF++;
            }
        }catch(FileNotFoundException fError){
            System.err.println("Error con el archivo:"+fError.getMessage());
        }catch(IOException ioError){
            System.err.println("IOException:"+ioError.getMessage());
        }
        return nF;
    }
    /**
     * Metodo al cual se le pasara como parametro la ruta de un archivo txt o csv, leyendo todos los datos de este archivo y
     * almacenandolos en una arraybidimensional de tipo object para luego mediante el metodo InsertAll de la clase DMLMascotas
     * pueda insertar los valores a la tabla mascotas encontrados en el archivo txt o csv.
     * @param ruta
     * @return 
     */
    public boolean insertarArchivoM(String ruta){
        DMLMascotas dmlM1 = new DMLMascotas();
        int i = 0;
        boolean tr = false;
        String[][] datos = new String[nF(ruta)][8];
        try(BufferedReader br = new BufferedReader(new FileReader(new File(ruta)))){
            String linea = br.readLine();
            while((linea = br.readLine()) != null){
                datos[i] = linea.split(";");
                try {
                    java.util.Date fechaNacimiento;
                    fechaNacimiento = formato.parse(datos[i][6]);
                    java.sql.Date sqlFecha = new java.sql.Date(fechaNacimiento.getTime());
                    tr = dmlM1.insertAll(Integer.parseInt(datos[i][0]), Integer.parseInt(datos[i][1]), datos[i][2], datos[i][3], datos[i][4], datos[i][5], sqlFecha, Integer.parseInt(datos[i][7]));
                } catch (ParseException ex) {
                    System.err.println("Error al convertir:"+ex.getMessage());                    
                    return tr;
                }
                i++;
            }
            br.close();
            return tr;
        }catch(FileNotFoundException fError){
            System.err.println("Error con el archivo:"+fError.getMessage());
            return tr;
        }catch(IOException ioError){
            System.err.println("IOException:"+ioError.getMessage());
            return tr;
        }
    }
    /**
     * Este metodo pedira como parametro la ruta de un archivo el cual debera ser txt o csv, el metodo leera el archivo
     * guardando la informacion encontrada de este dentro de un Array Bidimensional de tipo Object para luego por medio de la
     * clase DMLClientes con el metodo InsertAll insertar todos los valores encontrados en el archivo txt o csv.
     * @param ruta
     * @return 
     */
    public boolean insertarArchivoC(String ruta){
        DMLClientes dmlC1 = new DMLClientes();
        int i = 0;
        boolean tr = false;
        String[][] datos = new String[nF(ruta)][4];
        try(BufferedReader br = new BufferedReader(new FileReader(new File(ruta)))){
            String linea = br.readLine();
            while((linea = br.readLine()) != null){
                datos[i] = linea.split(";");
                tr = dmlC1.insertAll(Integer.parseInt(datos[i][0]), datos[i][1], datos[i][2], Integer.parseInt(datos[i][3]));
                i++;  
            }
            br.close();
            return tr;
        }catch(FileNotFoundException fError){
            System.err.println("Error con el archivo:"+fError.getMessage());
            return tr;
        }catch(IOException ioError){
            System.err.println("IOException:"+ioError.getMessage());
            return tr;
        }
    }
    
}
