package com.logic;

import static com.admin.Maestro_Habitaciones.*;
import com.objects.Habitacion;
import javax.swing.JList;

public class uHabitaciones extends uGeneric {
    
    // Administra la interacción de los botones
    
    public static void util(boolean text, boolean clean, boolean buttons){
        
        textNombre.setEnabled(text);
        chkOcupada.setEnabled(text);
        
        if (clean == true){
            textNombre.setText("");
            chkOcupada.setSelected(false);
        }
        
        btnCancel.setEnabled(buttons);
        btnDelete.setEnabled(buttons);
        btnSave.setEnabled(buttons);
    }
        
    // Recoge el modelo para la lista
    
    public static void getList(JList lista, boolean habilitada) {
        
        lista.setModel(dataModel(habitaciones));
        lista.setEnabled(habilitada);
    }
    
    // Obtiene el objeto seleccionado en la lista
    
    public static void getObject(JList list){
        
        int pos = list.getSelectedIndex();
        
        if (list.getSelectedIndex() != -1){
            habitacion = habitaciones.get(list.getSelectedIndex());
        
            textNombre.setText(habitacion.getNombre());
            chkOcupada.setSelected(habitacion.isOcupada());
        } else {
            habitacion = null;
        }
    }
    
    // Guarda el Objeto
    
    public static void saveObject(){
        
        if (habitacion == null){
        
            habitaciones.add(new Habitacion(
                    textNombre.getText()));
        } else {
            habitacion.setNombre(textNombre.getText());
            habitacion.setOcupada(chkOcupada.isSelected());
        }
    }
}
