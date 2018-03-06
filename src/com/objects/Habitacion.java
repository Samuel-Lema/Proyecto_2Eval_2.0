package com.objects;

public class Habitacion{

    private String nombre;
    private boolean ocupada;
    
    // Constructor

    public Habitacion(String nombre) {
        this.nombre = nombre;
        this.ocupada = false;
    }
    
    // Get's y Set's

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    // Modifica la habitacion a ocupada
    
    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }   
    
    @Override public String toString(){
        
        String ocup = "Vacia";
        
        if (ocupada == true){
            ocup = "Ocupada";
        }
        
        return "" + this.nombre + " (" + ocup + ")";
    }
}
