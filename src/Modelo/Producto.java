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
public abstract class Producto { 
    protected String nombre;
    protected double precio;
    protected int cantidadStock;

    public Producto(String nombre, double precio, int cantidadStock) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
    }

    
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getCantidadStock() { return cantidadStock; }

    
    public void setPrecio(double precio) { this.precio = precio; }
    public void setCantidadStock(int cantidadStock) { this.cantidadStock = cantidadStock; }

    public abstract String obtenerDetalle(); 
    
    public void restarStock(int cantidad) {
    if (cantidad <= cantidadStock) {
        cantidadStock -= cantidad;
    }
}
    
    @Override
    public String toString() {
        return nombre + " ($" + precio + ") - Stock: " + cantidadStock;
    }
}
