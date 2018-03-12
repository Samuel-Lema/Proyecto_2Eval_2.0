package com.objects;

import com.logic.uGeneric;

public class Articulo {
    
    private final int codigo;
    private String nombre;
    private float precio;

    // Constructor
    
    public Articulo(String nombre, float precio) {
        this.codigo = uGeneric.getArticulos();
        this.nombre = nombre;
        this.precio = precio;
    }
    
    // Metodos de Acceso

    public int getCodigo() {
        return codigo;
    }

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
