package es.medac.MascotaApp.model;

/**
 *
 * @author Michael Santiago Jara Castro
 * @author Jhonatan Caro
 * @author Casimiro Ochaga
 */
public class Clientes {
    //Atributos
    private int idCliente;
    private String primerApellido;
    private String cuentaBanco;
    private int telefono;
    //Constructores (Vacío - Parametros)
    public Clientes(){
        this.idCliente = 0;
        this.primerApellido = "";
        this.cuentaBanco = "";
        int telefono = 000000000;
    }
    public Clientes(int idC, String pA, String cB, int t){
        this.idCliente = idC;
        this.primerApellido = pA;
        this.cuentaBanco = cB;
        this.telefono = t;
    }
    //Getters
    public int getIdCliente(){
        return this.idCliente;
    }
    public String getPrimerApellido(){
        return this.primerApellido;
    }
    public String getCuentaBanco(){
        return this.cuentaBanco;
    }
    public int getTelefono(){
        return this.telefono;
    }
    //Setters
    public void setIdCliente(int idC){
        this.idCliente = idC;
    }
    public void setPrimerApellido(String pA){
        this.primerApellido = pA;
    }
    public void setCuentaBanco(String cB){
        this.cuentaBanco = cB;
    }
    public void setTelefono(int t){
        this.telefono = t;
    }
    //ToString
    public String info(){
        return "---------Información Mascota---------"+
               "\nID Cliente:"+this.idCliente+
               "\nPrimer Apellido:"+this.primerApellido+
               "\nCuenta Banco:"+this.cuentaBanco+
               "\nTelefono:"+this.telefono;
    }
}
