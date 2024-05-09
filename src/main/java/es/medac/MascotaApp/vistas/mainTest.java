package es.medac.MascotaApp.vistas;

import es.medac.MascotaApp.controller.ConexionBD;
import es.medac.MascotaApp.controller.Consultas;
import es.medac.MascotaApp.controller.DMLMascotas;
import es.medac.MascotaApp.controller.DMLPesos;
import es.medac.MascotaApp.controller.DMLVacunas;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class mainTest {
    
    public static void main(String[] args) throws SQLException, ParseException{
        
        Logger log = Logger.getLogger(mainTest.class.getName());
        ConexionBD bd = new ConexionBD();
        bd.getConexion();
        SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
        DMLMascotas test1 = new DMLMascotas();
        DMLPesos test2 = new DMLPesos();
        DMLVacunas test3 = new DMLVacunas();
        Consultas c1 = new Consultas();
        if(c1.filtroCliente(20) == true){
            System.err.println("Mascota registrada");
        }else{
            System.out.println("Cliente no registrado");
        }
        //long fN = datoFechaNacimiento.getDate().getTime();
        //java.util.Date fechaNacimiento = formato.parse(fN);
        //java.sql.Date sqlFecha = new java.sql.Date(fN);
        //java.util.Date fechaPesado = formato.parse("");
        //test1.insertAll(200, 0, "Toby", "Perro", "Bulldog", "Gris", sqlFecha , 3);

        
    }
}
