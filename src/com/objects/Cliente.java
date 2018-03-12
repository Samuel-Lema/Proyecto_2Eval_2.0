package com.objects;

import com.logic.uGeneric;

public class Cliente {
    
    private final int codigo;
    private String dni, nombre, tlf;
    
    // Constructor

    public Cliente(String dni, String nombre, String tlf) {
        this.codigo = uGeneric.getClientes();
        this.dni = dni;
        this.nombre = nombre;
        this.tlf = tlf;
    }
    
    // Metodos de Acceso

    public int getCodigo() {
        return codigo;
    }
    
    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTlf() {
        return tlf;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }
    
    @Override public String toString(){
        
        return "" + this.dni + " (" + this.nombre + ")";
    }
}
