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
    SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
    
    private final String insertarClientes = "INSERT INTO CLIENTES VALUES ?, ?, ?, ?;";
    
    public InsertarFichero(){
        this.conexionBD = new ConexionBD().getConexion();
    }
    
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
