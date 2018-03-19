package com.logic;

import static com.msg.message.valid;
import com.objects.*;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

public class uGeneric {
    
    protected static DefaultListModel modelo = new DefaultListModel();
    protected static DefaultListModel modeloAlt = new DefaultListModel();
    protected static ArrayList<Cliente> clientes = new ArrayList<>();
    protected static ArrayList<Habitacion> habitaciones = new ArrayList<>();
    protected static ArrayList<Articulo> articulos = new ArrayList<>();
    protected static ArrayList<Venta> ventas = new ArrayList<>();

    public static int getClientes() {
        return clientes.size();
    }
    public static int getHabitaciones() {
        return habitaciones.size();
    }
    public static int getArticulos() {
        return articulos.size();
    }
    public static int getVentas() {
        return ventas.size();
    }
    
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
    
    // Función para cargar la Lista de Objetos Alternativa
    
    public static <T> DefaultListModel dataModelAlt(ArrayList<T> objetos) {

        modeloAlt.clear();

        objetos.forEach((objeto) -> {
            modeloAlt.addElement(objeto.toString());
        });
        
        return modeloAlt;
    }
    
    // Funcion para eliminar objetos de cada clase
    
    public static void delete(Object objeto) {

        if (valid("¿Esta seguro que quiere eliminarlo?") == true){
            
            if (objeto.getClass() == Habitacion.class){
                habitaciones.remove(objeto);
            } else if (objeto.getClass() == Cliente.class) {
                clientes.remove(objeto);
            } else if (objeto.getClass() == Articulo.class) {
                articulos.remove(objeto);
            } else if (objeto.getClass() == Venta.class) {
                ventas.remove(objeto);
            }
        }
            
    }

}
