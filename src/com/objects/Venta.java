package com.objects;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Venta {
    
    private boolean finalizada;
    private Habitacion habitacion;
    private Cliente cliente;
    private ArrayList<Articulo> articulos = new ArrayList<>();;
    
    // Constructor

    public Venta(Habitacion habitacion, Cliente cliente) {
        this.habitacion = habitacion;
        habitacion.setOcupada(true);
        this.cliente = cliente;
        this.finalizada = false;
    }
    
    // Metodos de Acceso

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void addArticulo(Articulo articulo){
        
        this.articulos.add(articulo);
    }
    
    // Funciones de la Venta
    
    public void cambiarHabitacion(Habitacion habitacion){
            
        if (habitacion.isOcupada() == false){
            
            this.habitacion.setOcupada(false);
            this.habitacion = habitacion;
        } else {
            if (habitacion != this.habitacion){
                JOptionPane.showInputDialog("La Habitacion (%s) esta ocupada.", habitacion.getNombre());
            }
        }
    }
    
    // Finaliza la Venta
    public void finalizar(){
      
        this.habitacion.setOcupada(false);
        this.finalizada = true;
    }

    @Override public String toString() {
        return "Venta";
    }
    
    
    
}
