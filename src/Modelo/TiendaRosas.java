/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Mattias
 */
public class TiendaRosas {
    
    
    public static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    public static ArrayList<Producto> inventario = new ArrayList<>();
    public static ArrayList<Cliente> listaClientes = new ArrayList<>();
    public static ArrayList<VentaResumen> listaVentas = new ArrayList<>();

    
    
    public void inicializarDatos() {
        if(listaUsuarios.isEmpty()) {
            // Polimorfismo: Guardamos Floristas y Cajeros en la misma lista de Usuarios
            listaUsuarios.add(new Florista("Ana", "1092340557", "admin", "12345"));
            listaUsuarios.add(new Cajero("Luis", "1092340557", "cajero1", "1111"));
            inventario.add(new Rosa("Freedom x15", 25000, 120, "Roja", "Nacional"));
            inventario.add(new Rosa("Salmon x15", 25000, 120, "Roja", "Nacional"));
            inventario.add(new Rosa("Rosado x15", 25000, 120, "Roja", "Nacional"));

            
            
        }
    }
    
    public ArrayList<Producto> getProductos(){
    
        return inventario;
    }
    
    public Producto buscarProducto(String nombre){
    
        for(Producto p: inventario){
        
        if (p.getNombre().equalsIgnoreCase(nombre)){
        
            return p;
        }
        }
    return null;
    }
    

    public Usuario validarIngreso(String user, String pass) {
        for (Usuario u : listaUsuarios) {
            if (u.login(user, pass)) {
                
               
                
                return u; 
            }
        }
        return null; 
    }
    
    

    public  void llenarrosa(String nombre, String precioStr, String cantidadStockStr, String color, String origen){
    
    // Manejo de errores de conversión: Siempre es mejor atrapar la excepción
    double pre;
    int cant;
    try {
        pre = Double.parseDouble(precioStr);
        cant = Integer.valueOf(cantidadStockStr);
    } catch (NumberFormatException e) {
        // En un caso real, esto debería ser reportado al usuario
        System.err.println("Error de formato al registrar producto: " + e.getMessage());
        return; 
    }
    
    // Creación del objeto Rosa (¡una sola vez!)
    Rosa nuevaRosa = new Rosa(nombre, pre, cant, color, origen);
    
    // Adición al ArrayList estático
    inventario.add(nuevaRosa);
}
    
    public Cliente registrar_cliente(String nombre, String cedula, Boolean frecuente) {

    Cliente nuevoCliente;

    if (frecuente) {
        nuevoCliente = new ClienteFrecuente(nombre, cedula);
    } else {
        nuevoCliente = new Cliente(nombre, cedula);
    }

    listaClientes.add(nuevoCliente);
    return nuevoCliente;
}
    
    public Cliente buscarClientePorCedula(String cedula) {
        for (Cliente c : listaClientes) {
            if (c.getCedula().equals(cedula)) {
                return c;
            }
        }
        return null;
    }
    
    public void actualizarInventario(Venta venta) {

        for (DetalleVenta dv : venta.getDetalles()) {

            for (Producto p : inventario) {

                if (p.getNombre().equalsIgnoreCase(dv.getProducto())) {
                    p.restarStock(dv.getCantidad());
                    break;
                }
            }
        }
    }

    
    
    public Cliente obtenerUltimoClienteRegistrado() {
    if (listaClientes.isEmpty()) {
        return null;
    }
    
    return listaClientes.get(listaClientes.size() - 1);
    }
    
    public void registrarVentaDelDia(Venta venta) {

    String cliente = venta.getCliente().getNombre();

    StringBuilder productos = new StringBuilder();
    for (DetalleVenta dv : venta.getDetalles()) {
        productos.append(dv.getProducto())
                 .append(" x")
                 .append(dv.getCantidad())
                 .append(", ");
    }

    double total = venta.calcularTotalFinal();

    listaVentas.add(new VentaResumen(
        cliente,
        productos.toString(),
        total
    ));
}

    

    
}
