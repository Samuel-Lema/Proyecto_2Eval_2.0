package com.logic;

import static com.admin.Maestro_Clientes.*;
import com.objects.Cliente;
import javax.swing.JList;

public class uClientes extends uGeneric {
    
    public static void util(boolean text, boolean clean, boolean buttons){
        
        textNombre.setEnabled(text);
        textDni.setEnabled(text);
        textTlf.setEnabled(text);
        
        if (clean == true){
            textNombre.setText("");
            textDni.setText("");
            textTlf.setText("");
        }
        
        btnCancel.setEnabled(buttons);
        btnSave.setEnabled(buttons);
    }
        
    public static void cargarLista(JList lista, boolean habilitada) {

        lista.setEnabled(habilitada);
        
        modelo.clear();

        clientes.forEach((cli) -> {
            modelo.addElement(cli.toString());
        });
        
        lista.setModel(modelo);
    }
    
    // Obtiene el objeto seleccionado en la lista
    
    public static void getObject(JList list){
        
        int pos = list.getSelectedIndex();
        
        if (list.getSelectedIndex() != -1){
            cliente = clientes.get(list.getSelectedIndex());
        
            textNombre.setText(cliente.getNombre());
            textDni.setText(cliente.getDni());
            textTlf.setText(cliente.getTlf());
        } else {
            cliente = null;
        }
    }
    
    public static void addObject(JList list){
        
        cliente = null;
        list.setEnabled(false);
    }
    
    public static void saveObject(){
        
        if (cliente == null){
        
            clientes.add(new Cliente(
                    textDni.getText(), 
                    textNombre.getText(), 
                    textTlf.getText()));
        } else {
            cliente.setNombre(textNombre.getText());
            cliente.setDni(textDni.getText());
            cliente.setTlf(textTlf.getText());
        }
    }
}
