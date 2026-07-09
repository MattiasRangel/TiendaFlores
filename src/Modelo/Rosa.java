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

public class Rosa extends Producto {
    private String color;
    private String origen; 

    public Rosa(String nombre, double precio, int cantidadStock, String color, String origen) {
        super(nombre, precio, cantidadStock); 
        this.color = color;
        this.origen = origen;
    }

    public String getColor() { return color; }
    public String getOrigen() { return origen; }

    

    
    public String info() {
        return super.toString();
    }
    
    
    
    
    @Override
    public String obtenerDetalle() {
        return "Color: " + color + ", Origen: " + origen;
    }
}
