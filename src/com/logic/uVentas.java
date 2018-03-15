package com.logic;

import static com.admin.Maestro_Ventas.*;
import javax.swing.DefaultComboBoxModel;
import com.objects.*;
import javax.swing.JList;

public class uVentas extends uGeneric {
        
    // Administra la interacción de los botones
    
    public static void util(boolean enabled, boolean buttons, boolean buttonsalt){
        
        cbCliente.setEnabled(enabled);
        cbHabitacion.setEnabled(enabled);
        chkFinalizada.setEnabled(enabled);
        cbArticulo.setEnabled(buttonsalt);
        
        btnAddArt.setEnabled(buttonsalt);
        btnDeleteArt.setEnabled(buttonsalt);
        btnCancel.setEnabled(buttons);
        btnSave.setEnabled(buttons);
    }
    
    // Recoge el modelo para la lista
    
    public static void getList(JList lista, boolean habilitada) {
        
        lista.setModel(dataModel(ventas));
        lista.setEnabled(habilitada);
    }
    
    // Recoge el modelo para la lista alternativa
    
    public static void getListAlt(JList lista) {
        
        try {
            lista.setModel(dataModelAlt(venta.getArticulos()));
            
        } catch(NullPointerException except){
            
        }
    }
       
    // Recoge los modelos para los comboBox
    
    public static void getComboBox(boolean habilitada) {

        cbCliente.setModel(new DefaultComboBoxModel(clientes.toArray()));
        cbHabitacion.setModel(new DefaultComboBoxModel(habitaciones.toArray()));
        cbArticulo.setModel(new DefaultComboBoxModel(articulos.toArray()));
        
        cbCliente.setEnabled(habilitada);
        cbHabitacion.setEnabled(habilitada);
        cbArticulo.setEnabled(habilitada);
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
    
    // Añade el articulo a la venta
    
    public static void addArticulo(){
        
        venta.addArticulo((Articulo) cbArticulo.getSelectedItem());
    }
    
    public static void deleteArticulo(JList list, int articulo) {
        
        if (list.getSelectedIndex() != -1){
            
            venta.getArticulos().remove(articulo);
        } else {}
        
    }
    
    // Finaliza la venta y desocupa la habitación
    
    public static void finalizar(){
        
        venta.finalizar();
    }
    
    // Guarda el Objeto
    
    public static void saveObject(){
        
        if (venta == null){
        
            ventas.add(new Venta(
                    (Habitacion) cbHabitacion.getSelectedItem(),
                    (Cliente) cbCliente.getSelectedItem()));
        } else {
            venta.setCliente((Cliente) cbCliente.getSelectedItem());
            venta.cambiarHabitacion((Habitacion) cbHabitacion.getSelectedItem());
        }
    }
}
