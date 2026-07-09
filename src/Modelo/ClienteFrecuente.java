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
public class ClienteFrecuente  extends Cliente implements Frecuente { 

    public ClienteFrecuente(String nombre, String cedula) {
        super(nombre, cedula);
    } 
    

    @Override
    public double aplicarDescuento(double subtotal) {
        return subtotal * PORC;
    }
    
    @Override
    public double calcularTotalConDescuento(double subtotal) {
        return aplicarDescuento(subtotal);
    }
    
    @Override
    public String toString() {
        return super.toString() + " - FRECUENTE (10% Desc.)";
    }
}
