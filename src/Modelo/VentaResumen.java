/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Mattias
 */
public class VentaResumen {
    private String cliente;
    private String productos;
    private double total;
    private Date fecha;

    public VentaResumen(String cliente, String productos, double total) {
        this.cliente = cliente;
        this.productos = productos;
        this.total = total;
        this.fecha = new Date();
    }

    public String getCliente() {
        return cliente;
    }

    public String getProductos() {
        return productos;
    }

    public double getTotal() {
        return total;
    }

    public Date getFecha() {
        return fecha;
    }
}
    

