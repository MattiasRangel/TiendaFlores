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
public class DetalleVenta {
    
    private String producto; 
    private int cantidad;

    public DetalleVenta(String producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public String getProducto() {
        return producto;
    }

    
    
    public int getCantidad() { return cantidad; }

    public double calcularSubtotal() {
        String nombreDetalle = this.producto.trim();  // Quita espacios del nombre guardado

        for (Producto p : TiendaRosas.inventario) {
            if (p.getNombre().trim().equalsIgnoreCase(nombreDetalle)) {
                return p.getPrecio() * this.cantidad;
            }
        }
        return 0.0;  // Si no encuentra
    }

    @Override
    public String toString() {
            return producto + " | Cantidad: " + cantidad +
           " | Subtotal: $" + calcularSubtotal();
    }
    
    
    
    
}
