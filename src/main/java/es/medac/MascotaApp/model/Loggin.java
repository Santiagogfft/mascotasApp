/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.medac.MascotaApp.model;

/**
 *
 * @author Usuario
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
