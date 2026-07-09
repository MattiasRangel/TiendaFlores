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
public class Cliente extends Persona  { 
   


    public Cliente(String nombre, String cedula) {
        super(nombre, cedula); 
    }

    
    // Método clave para el Polimorfismo: Devuelve el subtotal sin descuento.
    public double calcularTotalConDescuento(double subtotal) {
        
        
        return subtotal; 
    }

    @Override
    public String toString() {
        return nombre + " (CC: " + cedula + ")";
    }
}
