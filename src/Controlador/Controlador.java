/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cajero;
import Modelo.Cliente;
import Modelo.Florista;
import Modelo.ResultadoLogin;
import Modelo.TiendaRosas;
import Modelo.Usuario;
import Modelo.Venta;

/**
 *
 * @author Mattias
 */
public class Controlador {

    public Controlador() {
       
        super();
        TiendaRosas hol = new TiendaRosas();
        hol.inicializarDatos(); 
    
    }
    
     private static final TiendaRosas tien = new TiendaRosas();
    private static Venta tienda = new Venta();

    
    
    public void setCliente(Cliente cliente) {
        tienda.setCliente(cliente);
    }
    
    
    public ResultadoLogin Validar_datos(String user, String pass){
        
        
        Usuario usuarioEncontrado = tien.validarIngreso(user, pass);
        
        if (usuarioEncontrado != null) {
            int rol = 0;
            
            // Revisar el rol del usuario
            if (usuarioEncontrado instanceof Florista){
                rol = 1; // Rol 1: Florista
            } else if (usuarioEncontrado instanceof Cajero){
                rol = 2; // Rol 2: Cajero
            }
            
            // Login correcto
            return new ResultadoLogin(true, rol); 
            
        } else {
            // Login fallido
            return new ResultadoLogin(false, 0); 
        }
    }
    
    public String llenar_inv (String nombre, String precio, String cantidadStock, String color, String origen){
    
     
     
     tien.llenarrosa(nombre, precio, cantidadStock, color, origen);

    return "rosa llenada";
    
    }
    
    public String llenar_cliente (String nombre, String cedula, Boolean frecuente){
    
        
        Cliente cliente = tien.registrar_cliente(nombre, cedula, frecuente);
        setCliente(cliente);
        return "cliente registrado";
    }
    
    public String verificar_ced(String cedula){
    
       
        
        if(tien.buscarClientePorCedula(cedula) == null){
        
        
        return "Cliente no encontrado";}
        

    return tien.buscarClientePorCedula(cedula).toString();
    }
    
    public String llenar_venta(String producto, String unidades) {
        tienda.agregarDetalle(producto, unidades);
        return "Agregado: " + unidades + " de " + producto;
    }

    public String mostrar_total() {
        return String.valueOf(tienda.calcularTotalFinal());
    }
    
    public String generarFactura() {

    tien.actualizarInventario(tienda);
    

    // Limpia la venta actual para la siguiente factura
    Venta tienda = new Venta();
    

    return "Factura generada y stock actualizado";
}
    
    public String clientefact(){
        
    
    return tien.obtenerUltimoClienteRegistrado().toString();
    }
    
    public String detalles_pro(){
    
        String detalles = tienda.mostrar_inventarioFact();
    return detalles;
    }
    
    public String entregarFactura() {

    tien.registrarVentaDelDia(tienda);
    tien.actualizarInventario(tienda);

        tienda = new Venta();

        return "Factura entregada y venta registrada";
    }
    
    public String nuevaVenta() {

    
    Controlador.tienda.limpiarCarrito();
    Controlador.tienda = new Venta();

    return "Nueva venta iniciada";
    }
    
    
    
}
