package es.medac.MascotaApp.model;

import java.sql.Date;

/**
 *
 * @author Michael Santiago Jara Castro
 * @author Jhonatan Caro
 * @author Casimiro Ochaga
 */
public class Mascotas {
    //Atributos
    private int idMascota;
    private int idCliente;
    private String aliasMascota;
    private String especie;
    private String raza;
    private String colorPelo;
    private Date fechaNacimiento;
    private int vacunaciones;
    //Constructores (Vacío-Parametros)
    public Mascotas(){
        this.idMascota = 0;
        this.idCliente = 0;
        this.aliasMascota = "";
        this.especie = "";
        this.raza = "";
        this.colorPelo = "";
        this.fechaNacimiento = null;
        this.vacunaciones = 0;
    }
    public Mascotas(int idM, int idC, String aM, String e, String r, String cP, Date fH, int v){
        this.idMascota = idM;
        this.idMascota = idM;
        this.idCliente = idC;
        this.aliasMascota = aM;
        this.especie = e;
        this.raza = r;
        this.colorPelo = cP;
        this.fechaNacimiento = fH;    
        this.vacunaciones = v;
    }
    //Getters
    public int getIdMascota(){
        return this.idMascota;
    }
    public int getIdCliente(){
        return this.idCliente;
    }
    public String getAliasMascota(){
        return this.aliasMascota;
    }
    public String getEspecie(){
        return this.especie;
    }
    public String getRaza(){
        return this.raza;
    }
    public String getColorPelo(){
        return this.colorPelo;
    }
    public Date getfechaNacimiento(){
        return this.fechaNacimiento;
    }
    public int getVacunaciones(){
        return this.vacunaciones;
    }
    //Setters
    public void setIdMascota(int idM){
        this.idMascota = idM;
    }
    public void setIdCliente(int idC){
        this.idCliente = idC;
    }
    public void setAliasMascota(String aM){
        this.aliasMascota = aM;
    }
    public void setEspecie(String e){
        this.especie = e;
    }
    public void setRaza(String r){
        this.raza = r;
    }
    public void setColorPelo(String cP){
        this.colorPelo = cP;
    }
    public void setFechaNacimiento(Date fH){
        this.fechaNacimiento = fH;    
    }
    public void setVacunaciones(int v){
        this.vacunaciones = v;
    }
    @Override
    public String toString(){
        return "---------Información Mascota---------"+
               "\nID Mascota:"+this.idMascota+
               "\nID Cliente:"+this.idCliente+
               "\nAlias Mascota:"+this.aliasMascota+
               "\nEspecie:"+this.especie+
               "\nRaza:"+this.raza+
               "\nColor Pelo:"+this.colorPelo+
               "\nFecha Nacimiento:"+this.fechaNacimiento+
               "\nVacunaciones:"+this.vacunaciones+"\n";
    }
    
    public String info(){
        return this.idMascota+" | "+this.idCliente+" | "+this.aliasMascota+" | "+this.especie+" | "+this.raza+" | "+this.colorPelo+" | "+this.fechaNacimiento+" | "+this.vacunaciones+"\n";
    }
}
