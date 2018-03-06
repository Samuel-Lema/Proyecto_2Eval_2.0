package com.objects;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Venta {
    
    private boolean finalizada;
    private Habitacion habitacion;
    private final Cliente cliente;
    private ArrayList<Articulo> articulos = new ArrayList<>();;
    
    // Constructor

    public Venta(Habitacion habitacion, Cliente cliente) {
        this.habitacion = habitacion;
        habitacion.setOcupada(true);
        this.cliente = cliente;
        this.finalizada = false;
    }
    
    // Get's

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    public void addArticulo(Articulo articulo){
        
        this.articulos.add(articulo);
    }
    public void setFinalizada(boolean finalizada) {
        
        this.finalizada = finalizada;
    }
    
    // Funciones de la Venta
    
    public void cambiarHabitacion(Habitacion habitacion){
            
        if (habitacion.isOcupada() == false){
            
            this.habitacion.setOcupada(false);
            this.habitacion = habitacion;
        } else {
                
            System.out.format("La Habitacion (%s) esta ocupada.", habitacion.getNombre());
        }
    }
    
    // Añade un Articulo
    public void añadirArticulo(){
        
        Articulo articulo = (Articulo)JOptionPane.showInputDialog(null, "", "Selecciona el Articulo", 
                JOptionPane.PLAIN_MESSAGE, null, maestro.articulos.toArray(), null );
        
        this.articulos.add(articulo);
    }
    
    // Finaliza la Venta
    public void finalizar(){
      
        this.habitacion.setOcupada(false);
        setFinalizada(true);
    }
    
}
