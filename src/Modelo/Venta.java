/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Mattias
 */
public class Venta {

    private Cliente cliente;   
    private Date fecha;
    private ArrayList<DetalleVenta> detalles;

    public Venta() {
        this.fecha = new Date();
        this.detalles = new ArrayList<>();
    }

    public Venta(Cliente cliente) {
        this.cliente = cliente;
        this.fecha = new Date();
        this.detalles = new ArrayList<>();
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void agregarDetalle(String producto, String cantidad) {
        int cant = Integer.parseInt(cantidad);
        detalles.add(new DetalleVenta(producto, cant));
    }

    public ArrayList<DetalleVenta> getDetalles() {
        return detalles;
    }

    
    public double calcularSubtotal() {
        double subtotal = 0;
        for (DetalleVenta dv : detalles) {
            subtotal += dv.calcularSubtotal();
        }
        return subtotal;
    }

    
    public double calcularTotalFinal() {
        double subtotal = calcularSubtotal();
        return cliente.calcularTotalConDescuento(subtotal);
        
    }
    
    public String mostrar_inventarioFact(){
    
    StringBuilder factura = new StringBuilder();

    for (DetalleVenta dv : detalles) {
        factura.append(dv.toString()).append("\n");
    }

    return factura.toString();
    }
    
    public void limpiarCarrito() {
    detalles.clear();
}
}

