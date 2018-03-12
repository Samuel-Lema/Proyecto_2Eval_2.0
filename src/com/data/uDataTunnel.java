package com.data;

import com.logic.uGeneric;
import com.objects.*;
import java.io.*;

public class uDataTunnel extends uGeneric {
    
    public static void cargar(String archivo, int tipo) throws FileNotFoundException, IOException {

        BufferedReader b = new BufferedReader(new FileReader(archivo));
        String linea = b.readLine();
        
        while(linea != null){

            String[] ref = linea.split("_*_");

            try {
                switch(tipo){
                    case 1: habitaciones.add(new Habitacion(ref[0])); break;
                    case 2: clientes.add(new Cliente(ref[0], ref[2], ref[4])); break;
                    case 3: articulos.add(new Articulo(ref[0], Float.parseFloat(ref[2]))); break;
                    case 4: 
                        Venta venta = new Venta(habitaciones.get(Integer.parseInt(ref[0])), clientes.get(Integer.parseInt(ref[2])));
                        ventas.add(venta);
                        
                        String[] artVenta = ref[4].split("/");
                        
                        for (String art: artVenta){
                            venta.addArticulo(articulos.get(Integer.parseInt(art)));
                        } 
                        break;
                }
            } catch (IndexOutOfBoundsException except){}
            
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
                
                escribir.write(hab.getNombre() + "\n");
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
                
                escribir.write(cli.getDni() + "_*_" + cli.getNombre() + " * " + cli.getTlf() + "\n");
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
                
                escribir.write(art.getNombre() + "_*_" + art.getPrecio() + "\n");
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
                        artVenta = artVenta + "/" + art.getCodigo();
                    }
                    count++;
                }
                
                escribir.write(venta.getHabitacion().getCodigo() + "_*_" + venta.getCliente().getCodigo() + "_*_" + artVenta + "\n");
            }
            
            escribir.close();
            
        } catch(IOException except){}
    }
}
