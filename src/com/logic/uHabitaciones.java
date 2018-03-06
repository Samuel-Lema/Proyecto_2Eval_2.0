package com.logic;

import static com.admin.Maestro_Habitaciones.*;
import com.objects.Habitacion;
import javax.swing.JList;

public class uHabitaciones extends uGeneric {
    
    public static void util(boolean text, boolean clean, boolean buttons){
        
        textNombre.setEnabled(text);
        chkOcupada.setEnabled(text);
        
        if (clean == true){
            textNombre.setText("");
            chkOcupada.setSelected(false);
        }
        
        btnCancel.setEnabled(buttons);
        btnSave.setEnabled(buttons);
    }
        
    public static void cargarLista(JList lista, boolean habilitada) {

        lista.setEnabled(habilitada);
        
        modelo.clear();

        habitaciones.forEach((hab) -> {
            modelo.addElement(hab.toString());
        });
        
        lista.setModel(modelo);
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
    
    public static void addObject(JList list){
        
        habitacion = null;
        list.setEnabled(false);
    }
    
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
