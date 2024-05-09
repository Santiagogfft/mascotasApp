package es.medac.MascotaApp.model;

import java.sql.Date;

/**
 *
 * @author Michael Santiago Jara Castro
 * @author Jhonatan Caro
 * @author Casimiro Ochaga
 */
public class Vacunas extends Mascotas{
    //Atributos
    private int idMascota;
    private Date fechaV;
    private String enfermedad;
    private Date fechaProximaV;
    //Constructores (Vacío - Parametros)
    public Vacunas(){
        this.idMascota = getIdMascota();
        this.fechaV = null;
        this.enfermedad = "";
        this.fechaProximaV = null;
    }
    public Vacunas(Date fV, String en, Date fPV){
        this.idMascota = getIdMascota();
        this.fechaV = fV;
        this.enfermedad = en;
        this.fechaProximaV = fPV;
    }
    //Getters
    public Date getFechaV(){
        return this.fechaV;
    }
    public String getEnfermedad(){
        return this.enfermedad;
    }
    public Date getFechaProximaV(){
        return this.fechaProximaV;
    }
    //Setters
    public void setFechaV(Date fV){
        this.fechaV = fV;
    }
    public void setEnfermedad(String en){
        this.enfermedad = en;
    }
    public void setFechaProximaV (Date fPV){
        this.fechaProximaV = fPV;
    }
    @Override
    public String toString(){
        return "---------Información Vacunas---------"+
               "\n Fecha Vacuna:"+this.fechaV+
               "\n Enfermedad:"+this.enfermedad+
               "\n Fecha Proxima Vacuna:"+this.fechaProximaV;
    }
    
}