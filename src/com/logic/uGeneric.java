package com.logic;

import com.objects.*;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

public class uGeneric {
    
    protected static DefaultListModel modelo = new DefaultListModel();
    protected static ArrayList<Cliente> clientes = new ArrayList<>();
    protected static ArrayList<Habitacion> habitaciones = new ArrayList<>();
    protected static ArrayList<Articulo> articulos = new ArrayList<>();
    protected static ArrayList<Venta> ventas = new ArrayList<>();
    
    // Genero objetos vacios para trabajar el flujo entre clases.
    
    protected static Cliente cliente;
    protected static Habitacion habitacion;
    protected static Articulo articulo;
    protected static Venta venta;

    public static Cliente getCliente() {
        return cliente;
    }

    public static Habitacion getHabitacion() {
        return habitacion;
    }

    public static Articulo getArticulo() {
        return articulo;
    }

    public static Venta getVenta() {
        return venta;
    }
    
    // Funcion para eliminar objetos sobrecargada para cada clase
    
    public static <T> void delete(Cliente objeto) {
        
        clientes.remove(objeto);
    }
    public static void delete(Habitacion objeto) {
        
        habitaciones.remove(objeto);
    }
    public static void delete(Articulo objeto) {
        
        articulos.remove(objeto);
    }
    public static void delete(Venta objeto) {
        
        ventas.remove(objeto);
    }
}
