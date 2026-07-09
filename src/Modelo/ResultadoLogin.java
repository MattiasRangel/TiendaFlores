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
public class ResultadoLogin {
    
    private boolean exito;
    private int rol; 

    public ResultadoLogin(boolean exito, int rol) {
        this.exito = exito;
        this.rol = rol;
    }

   
    public boolean isExito() {
        return exito;
    }

    public int getRol() {
        return rol;
    }
    
}
