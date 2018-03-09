package com.logic;

import com.objects.*;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;

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

    public static void setCliente(Cliente cliente) {
        uGeneric.cliente = cliente;
    }

    public static void setHabitacion(Habitacion habitacion) {
        uGeneric.habitacion = habitacion;
    }

    public static void setArticulo(Articulo articulo) {
        uGeneric.articulo = articulo;
    }

    public static void setVenta(Venta venta) {
        uGeneric.venta = venta;
    }
    
    // Función para cargar la Lista de Objetos
    
    public static <T> DefaultListModel dataModel(ArrayList<T> objetos) {

        modelo.clear();

        objetos.forEach((objeto) -> {
            modelo.addElement(objeto.toString());
        });
        
        return modelo;
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
