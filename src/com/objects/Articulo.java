package com.objects;

public class Articulo {
    
    private String nombre;
    private float precio;

    // Constructor
    
    public Articulo(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    
    // Metodos de Acceso

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    @Override public String toString(){
        
        return "" + this.nombre + " (" + this.precio + ")";
    }
}
