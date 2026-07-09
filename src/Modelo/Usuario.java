/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Mattias
 */
public class Usuario extends Persona{
    
    
    protected String username;
    protected String password;


    
    
    
    public Usuario(String nombre, String cedula, String username, String password) {
        super(nombre, cedula); 
        this.username = username;
        this.password = password;
    }


    public boolean login(String user, String pass) {
        return this.username.equals(user) && this.password.equals(pass);
    }

}
