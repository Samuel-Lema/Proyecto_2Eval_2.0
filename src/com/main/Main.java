package com.main;

import com.data.uDataTunnel;
import com.admin.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main extends javax.swing.JFrame {

    private Maestro_Clientes mainClientes = new Maestro_Clientes();
    private Maestro_Habitaciones mainHabs = new Maestro_Habitaciones();
    private Maestro_Articulos mainArticulos = new Maestro_Articulos();
    private Maestro_Ventas mainVentas = new Maestro_Ventas();
    
    public Main() throws FileNotFoundException, IOException {
        initComponents();
        
        /*Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().getWidth());
        int ySize = ((int) tk.getScreenSize().getHeight());
        this.setSize(xSize,ySize);*/
        
        try { 
            uDataTunnel.cargar("src/com/data/habitaciones.txt", 1);
            uDataTunnel.cargar("src/com/data/clientes.txt", 2);
            uDataTunnel.cargar("src/com/data/articulos.txt", 3);
            uDataTunnel.cargar("src/com/data/ventas.txt", 4);
            
        } catch (IOException ex) {}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        menu = new javax.swing.JMenuBar();
        menuMaestros = new javax.swing.JMenu();
        mHabitaciones = new javax.swing.JMenuItem();
        mClientes = new javax.swing.JMenuItem();
        mArticulos = new javax.swing.JMenuItem();
        mVentas = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Software de Hoteles");
        setBackground(null);
        setSize(new java.awt.Dimension(400, 300));

        jPanel1.setBackground(new java.awt.Color(147, 219, 239));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 633, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 307, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        menuMaestros.setText("Maestros");

        mHabitaciones.setText("Habitaciones");
        mHabitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mHabitacionesActionPerformed(evt);
            }
        });
        menuMaestros.add(mHabitaciones);

        mClientes.setText("Clientes");
        mClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mClientesActionPerformed(evt);
            }
        });
        menuMaestros.add(mClientes);

        mArticulos.setText("Articulos");
        mArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mArticulosActionPerformed(evt);
            }
        });
        menuMaestros.add(mArticulos);

        mVentas.setText("Ventas");
        mVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mVentasActionPerformed(evt);
            }
        });
        menuMaestros.add(mVentas);

        menu.add(menuMaestros);

        setJMenuBar(menu);

        setSize(new java.awt.Dimension(643, 358));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mClientesActionPerformed
        
        mainClientes = new Maestro_Clientes();
        mainHabs.show(false);
        mainClientes.show(true);
        mainArticulos.show(false);
        mainVentas.show(false);
    }//GEN-LAST:event_mClientesActionPerformed

    private void mHabitacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mHabitacionesActionPerformed
        
        mainHabs = new Maestro_Habitaciones();
        mainHabs.show(true);
        mainClientes.show(false);
        mainArticulos.show(false);
        mainVentas.show(false);
    }//GEN-LAST:event_mHabitacionesActionPerformed

    private void mArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mArticulosActionPerformed
        
        mainArticulos = new Maestro_Articulos();
        mainHabs.show(false);
        mainClientes.show(false);
        mainArticulos.show(true);
        mainVentas.show(false);
    }//GEN-LAST:event_mArticulosActionPerformed

    private void mVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mVentasActionPerformed
        
        mainVentas = new Maestro_Ventas();
        mainHabs.show(false);
        mainClientes.show(false);
        mainArticulos.show(false);
        mainVentas.show(true);
    }//GEN-LAST:event_mVentasActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override public void run() {
                try {
                    new Main().setVisible(true);
                } catch (IOException ex) {}
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem mArticulos;
    private javax.swing.JMenuItem mClientes;
    private javax.swing.JMenuItem mHabitaciones;
    private javax.swing.JMenuItem mVentas;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuMaestros;
    // End of variables declaration//GEN-END:variables

}
