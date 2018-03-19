package com.logic;

import static com.admin.Maestro_Articulos.*;
import com.objects.Articulo;
import javax.swing.JList;

public class uArticulos extends uGeneric {
    
    // Administra la interacción de los botones
    
    public static void util(boolean text, boolean clean, boolean buttons){
        
        textNombre.setEnabled(text);
        textPrecio.setEnabled(text);
        
        if (clean == true){
            textNombre.setText("");
            textPrecio.setText("");
        }
        
        btnCancel.setEnabled(buttons);
        btnDelete.setEnabled(buttons);
        btnSave.setEnabled(buttons);
    }
        
    // Recoge el modelo para la lista
    
    public static void getList(JList lista, boolean habilitada) {
        
        lista.setModel(dataModel(articulos));
        lista.setEnabled(habilitada);
    }
    
    // Obtiene el objeto seleccionado en la lista
    
    public static void getObject(JList list){
        
        int pos = list.getSelectedIndex();
        
        if (list.getSelectedIndex() != -1){
            articulo = articulos.get(list.getSelectedIndex());
        
            textNombre.setText(articulo.getNombre());
            textPrecio.setText(String.valueOf(articulo.getPrecio()));
        } else {
            articulo = null;
        }
    }
    
    // Guarda el Objeto
    
    public static void saveObject(){
        
        if (articulo == null){
        
            articulos.add(new Articulo(
                    textNombre.getText(), 
                    Float.parseFloat(textPrecio.getText())));
        } else {
            articulo.setNombre(textNombre.getText());
            articulo.setPrecio(Float.parseFloat(textPrecio.getText()));
        }
    }
}
