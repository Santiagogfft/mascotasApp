package es.medac.MascotaApp.model;

/**
 * Esta clase se encargara de crear un filtro para que los usuarios que intenten ingresar el programa
 * y realizar conexion con la BD deban ingresar un usuario y una contraseña establecidos para poder ingresar, caso contrario
 * no podran realizaro
 */
public class Loggin {
    private String usuario;
    private String contraseña;
    
    public Loggin(String user, String contra){
        this.usuario = user;
        this.contraseña = contra;
    }
    
    public boolean comprobarUsuario(){
        if(this.usuario.equals("Santiago") && this.contraseña.equals("@Santiago123")){
            return true;
        }else if (this.usuario.equals("Jhonatan") && this.contraseña.equals("@Jhonatan123")){
            return true;
        }else if(this.usuario.equals("Casimiro") && this.contraseña.equals("@Casimiro123")){
            return true;
        }else{
            return false;
        }
    }
    
}
