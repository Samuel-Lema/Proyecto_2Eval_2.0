package com.logic;

import static com.admin.Maestro_Ventas.*;
import com.objects.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;

public class uVentas extends uGeneric {

    public static void util(boolean enabled, boolean buttons){
        
        cbCliente.setEnabled(enabled);
        cbHabitacion.setEnabled(enabled);
        
        btnCancel.setEnabled(buttons);
        btnSave.setEnabled(buttons);
    }
    
    public static void cargarLista(JList lista, boolean habilitada) {

        lista.setEnabled(habilitada);
        
        modelo.clear();
        int i = 0;
        
        for (Venta ven: ventas){
            modelo.addElement("Venta " + i++);
        }
        
        lista.setModel(modelo);
    }
        
    public static void cargarLista(boolean habilitada) {

        cbCliente.setModel(new DefaultComboBoxModel(clientes.toArray()));
        cbHabitacion.setModel(new DefaultComboBoxModel(habitaciones.toArray()));
        
        cbCliente.setEnabled(habilitada);
        cbHabitacion.setEnabled(habilitada);
    }
    
    // Obtiene el objeto seleccionado en la lista
    
    public static void getObject(JList list){
        
        int pos = list.getSelectedIndex();
        
        if (list.getSelectedIndex() != -1){
            venta = ventas.get(list.getSelectedIndex());
        
            cbCliente.setSelectedItem(venta.getCliente());
            cbHabitacion.setSelectedItem(venta.getHabitacion());
        } else {
            venta = null;
        }
    }
    
    public static void addObject(JList list){
        
        venta = null;
        list.setEnabled(false);
    }
    
    public static void saveObject(){
        
        if (venta == null){
        
            ventas.add(new Venta(
                    (Habitacion) cbHabitacion.getSelectedItem(),
                    (Cliente) cbCliente.getSelectedItem()));
        } else {
            venta.cambiarHabitacion((Habitacion) cbHabitacion.getSelectedItem());
        }
    }
}
