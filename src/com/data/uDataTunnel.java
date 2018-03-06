package com.data;

import com.logic.uGeneric;
import com.objects.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class uDataTunnel extends uGeneric {
    
    public static void cargar() throws FileNotFoundException, IOException {
        
        // Carga las Habitaciones
        
        String archivo = "src/com/data/habitaciones.txt";
        BufferedReader b = new BufferedReader(new FileReader(archivo));
        String linea = b.readLine();
        
        while(linea != null){

            String[] ref = linea.split(" * ");
            habitaciones.add(new Habitacion(ref[0]));
            linea = b.readLine();
        }
        
        b.close();
        
        // Carga los Clientes
        
        archivo = "src/com/data/clientes.txt";
        b = new BufferedReader(new FileReader(archivo));
        linea = b.readLine();
        
        while(linea != null){

            String[] ref = linea.split(" * ");
            clientes.add(new Cliente(ref[0], ref[2], ref[4]));
            linea = b.readLine();
        }
        
        b.close();
        
        // Carga los Articulos
        
        archivo = "src/com/data/articulos.txt";
        b = new BufferedReader(new FileReader(archivo));
        linea = b.readLine();
        
        while(linea != null){

            String[] ref = linea.split(" * ");
            articulos.add(new Articulo(ref[0], Float.parseFloat(ref[2])));
            linea = b.readLine();
        }
        
        b.close();
        
        // Carga las Ventas
        
        archivo = "src/com/data/ventas.txt";
        b = new BufferedReader(new FileReader(archivo));
        linea = b.readLine();
        
        while(linea != null){

            String[] ref = linea.split(" * ");
            ventas.add(new Venta(habitaciones.get(Integer.parseInt(ref[0])-1), clientes.get(Integer.parseInt(ref[2])-1)));
            linea = b.readLine();
        }
        
        b.close();
    }
    
    public static void guardarHabitaciones(){
        
        
    }
    public static void guardarClientes(){
        
        
    }
    public static void guardarArticulos(){
        
        
    }
    public static void guardarVentas(){
        
        
    }
}
