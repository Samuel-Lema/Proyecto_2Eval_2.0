package com.data;

import com.logic.uGeneric;
import com.objects.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
            try {
                ventas.add(new Venta(habitaciones.get(Integer.parseInt(ref[0])-1), clientes.get(Integer.parseInt(ref[2])-1)));
            } catch (IndexOutOfBoundsException except){
                
            }
            
            linea = b.readLine();
        }
        
        b.close();
    }
    
    public static void guardarHabitaciones(){
        
        File ruta = new File("src/com/data/habitaciones.txt");
        FileWriter escribir;
        
        try {
            escribir = new FileWriter(ruta, false);
            
            for(Habitacion hab: habitaciones){
                
                escribir.write(hab.getNombre() + "\r");
            }
            
            escribir.close();
            
        } catch(IOException except){}
    }
    public static void guardarClientes(){
        
        File ruta = new File("src/com/data/clientes.txt");
        FileWriter escribir;
        
        try {
            escribir = new FileWriter(ruta, false);
            
            for(Cliente cli: clientes){
                
                escribir.write(cli.getDni() + " * " + cli.getNombre() + " * " + cli.getTlf() + "\n");
            }
            
            escribir.close();
            
        } catch(IOException except){}
    }
    public static void guardarArticulos(){
        
        File ruta = new File("src/com/data/articulos.txt");
        FileWriter escribir;
        
        try {
            escribir = new FileWriter(ruta, false);
            
            for(Articulo art: articulos){
                
                escribir.write(art.getNombre() + " * " + art.getPrecio() + "\n");
            }
            
            escribir.close();
            
        } catch(IOException except){}
    }
    public static void guardarVentas(){
        
        File ruta = new File("src/com/data/ventas.txt");
        FileWriter escribir;
        
        try {
            escribir = new FileWriter(ruta, false);
            
            for(Venta venta: ventas){
                String artVenta = "";
                int count = 0;
                
                for (Articulo art: venta.getArticulos()){
                    if (count == 0){
                        artVenta = String.valueOf(art.getCodigo());
                    } else {
                        artVenta = artVenta + " / " + art.getCodigo();
                    }
                    count++;
                }
                
                escribir.write(venta.getHabitacion().getCodigo() + " * " + venta.getCliente().getCodigo() + " * " + artVenta + "\n");
            }
            
            escribir.close();
            
        } catch(IOException except){}
    }
}
