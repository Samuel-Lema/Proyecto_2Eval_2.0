package com.objects;

import com.logic.uGeneric;
import static com.msg.message.show;
import java.util.ArrayList;

public class Venta {
    
    private final int codigo;
    private boolean finalizada;
    private Habitacion habitacion;
    private Cliente cliente;
    private ArrayList<Articulo> articulos = new ArrayList<>();;
    
    // Constructor

    public Venta(Habitacion habitacion, Cliente cliente) {
        this.codigo = uGeneric.getVentas();
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
                show("La Habitacion (" + habitacion.getNombre() + ") esta ocupada.");
            }
        }
    }
    
    // Finaliza la Venta
    
    public void finalizar(){
      
        this.habitacion.setOcupada(false);
        this.finalizada = true;
    }

    @Override public String toString() {
        return "Venta " + this.codigo;
    }

}
