package es.medac.MascotaApp.model;

import java.util.Date;

/**
 *
 * @author Michael Santiago Jara Castro
 * @author Jhonatan Caro
 * @author Casimiro Ochaga
 */
public class Pesos extends Mascotas{
    //Atributos
    private int idMascota;
    private Date fechaP;
    private double peso;
    //Constructores (Vacío-Parametros)
    public Pesos(){
        this.idMascota = getIdMascota();
        this.fechaP = null;
        this.peso = 0.0;
    }
    public Pesos(Date fP, double ps){
        this.idMascota = getIdMascota();
        this.fechaP = fP;
        this.peso = ps;
    }
    //Getters
    public Date getFechaP(){
        return this.fechaP;
    }
    public double getPeso(){
        return this.peso;
    }
    //Setters
    public void setFechaP(Date fP){
        this.fechaP = fP;
    }
    public void setPeso(double ps){
        this.peso = ps;
    }
    @Override
    public String toString(){
        return "---------Información Peso---------"+
               "\n Fecha Pesado:"+this.peso+
               "\n Peso:"+this.peso+"\n";
    }
}
