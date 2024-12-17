/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package erp_muzamia.ui;

import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class HomeUI extends javax.swing.JFrame {

    /**
     * Creates new form VentaServicios
     */
    public HomeUI() {
        initComponents();
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        this.setMaximizedBounds(env.getMaximumWindowBounds());
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdpFrames = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        jbInventario = new javax.swing.JButton();
        jbConfigurar = new javax.swing.JButton();
        jbVentas = new javax.swing.JButton();
        jbCatalogo = new javax.swing.JButton();
        jbClientes = new javax.swing.JButton();
        jbGraficos = new javax.swing.JButton();
        jbReportes = new javax.swing.JButton();
        jbCaja = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jmiNuevaVenta = new javax.swing.JMenuItem();
        jmiNuevoCliente = new javax.swing.JMenuItem();
        jmiUsuario = new javax.swing.JMenuItem();
        jmiGuardar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmiImportar = new javax.swing.JMenuItem();
        jmiExportar = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jmiLimpiar = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jmiBuscarVenta = new javax.swing.JMenuItem();
        jmiBuscarCliente = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jmiSotck = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jmiReporteOperaciones = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jmiMantServicios = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MUZAMIA SPA - SISTEMA DE VENTAS Y ADMINISTRACION DE NEGOCIO");
        setLocation(new java.awt.Point(0, 0));

        javax.swing.GroupLayout jdpFramesLayout = new javax.swing.GroupLayout(jdpFrames);
        jdpFrames.setLayout(jdpFramesLayout);
        jdpFramesLayout.setHorizontalGroup(
            jdpFramesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 792, Short.MAX_VALUE)
        );
        jdpFramesLayout.setVerticalGroup(
            jdpFramesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jbInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp_muzamia/ui/imgs/icons8-empty-box-25.png"))); // NOI18N
        jbInventario.setText("Inventario");
        jbInventario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jbInventario.setEnabled(false);
        jbInventario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbInventario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jbConfigurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp_muzamia/ui/imgs/icons8-settings-25.png"))); // NOI18N
        jbConfigurar.setText("Configurar");
        jbConfigurar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jbConfigurar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbConfigurar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbConfigurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfigurarActionPerformed(evt);
            }
        });

        jbVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp_muzamia/ui/imgs/icons8-vender-stock-30.png"))); // NOI18N
        jbVentas.setText("Ventas");
        jbVentas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jbVentas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbVentas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVentasActionPerformed(evt);
            }
        });

        jbCatalogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp_muzamia/ui/imgs/icons8-archive-list-of-parts-25.png"))); // NOI18N
        jbCatalogo.setText("Catálogo");
        jbCatalogo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jbCatalogo.setEnabled(false);
        jbCatalogo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbCatalogo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCatalogoActionPerformed(evt);
            }
        });

        jbClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp_muzamia/ui/imgs/icons8-crowd-25.png"))); // NOI18N
        jbClientes.setText("Clientes");
        jbClientes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jbClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbClientesActionPerformed(evt);
            }
        });

        jbGraficos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp_muzamia/ui/imgs/icons8-chart-25.png"))); // NOI18N
        jbGraficos.setText("Gráficos");
        jbGraficos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jbGraficos.setEnabled(false);
        jbGraficos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbGraficos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jbReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp_muzamia/ui/imgs/icons8-report-25.png"))); // NOI18N
        jbReportes.setText("Reportes");
        jbReportes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jbReportes.setEnabled(false);
        jbReportes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbReportes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jbCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp_muzamia/ui/imgs/icons8-register-machine-25.png"))); // NOI18N
        jbCaja.setText("Mov. Caja");
        jbCaja.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jbCaja.setEnabled(false);
        jbCaja.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbCaja.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCajaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbConfigurar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbGraficos, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCatalogo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jbVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jbCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jbCatalogo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jbInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jbReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jbGraficos, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jbConfigurar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenu2.setText("Archivo");

        jMenu1.setText("Nuevo");

        jmiNuevaVenta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jmiNuevaVenta.setText("Venta");
        jmiNuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNuevaVentaActionPerformed(evt);
            }
        });
        jMenu1.add(jmiNuevaVenta);

        jmiNuevoCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jmiNuevoCliente.setText("Cliente");
        jMenu1.add(jmiNuevoCliente);

        jmiUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jmiUsuario.setText("Usuario");
        jMenu1.add(jmiUsuario);

        jMenu2.add(jMenu1);

        jmiGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiGuardar.setText("Guardar");
        jMenu2.add(jmiGuardar);
        jMenu2.add(jSeparator1);

        jmiImportar.setText("Importar");
        jmiImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiImportarActionPerformed(evt);
            }
        });
        jMenu2.add(jmiImportar);

        jmiExportar.setText("Exportar");
        jMenu2.add(jmiExportar);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Editar");

        jmiLimpiar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jmiLimpiar.setText("Limpiar");
        jmiLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiLimpiarActionPerformed(evt);
            }
        });
        jMenu3.add(jmiLimpiar);

        jMenu5.setText("Buscar");

        jmiBuscarVenta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jmiBuscarVenta.setText("Venta");
        jMenu5.add(jmiBuscarVenta);

        jmiBuscarCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jmiBuscarCliente.setText("Cliente");
        jMenu5.add(jmiBuscarCliente);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jMenuItem1.setText("Usuario");
        jMenu5.add(jMenuItem1);

        jMenu3.add(jMenu5);

        jMenuBar1.add(jMenu3);

        jMenu6.setText("Ver");

        jmiSotck.setText("Stock de Insumos");
        jMenu6.add(jmiSotck);

        jMenuBar1.add(jMenu6);

        jMenu4.setText("Reportes");

        jmiReporteOperaciones.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiReporteOperaciones.setText("Reporte de Operaciones");
        jmiReporteOperaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiReporteOperacionesActionPerformed(evt);
            }
        });
        jMenu4.add(jmiReporteOperaciones);

        jMenuBar1.add(jMenu4);

        jMenu7.setText("Mantenimiento");

        jmiMantServicios.setText("Servicios");
        jmiMantServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMantServiciosActionPerformed(evt);
            }
        });
        jMenu7.add(jmiMantServicios);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jdpFrames)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpFrames)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiLimpiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiLimpiarActionPerformed

    private void jmiNuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNuevaVentaActionPerformed
        VentasUI ventaUI = new VentasUI();
        ventaUI.pack();
        ventaUI.setLocationRelativeTo(null);
        ventaUI.setVisible(true);
    }//GEN-LAST:event_jmiNuevaVentaActionPerformed

    private void jmiReporteOperacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiReporteOperacionesActionPerformed
        ReporteVentas reporteUI = new ReporteVentas();
        jdpFrames.add(reporteUI);
        reporteUI.show();
    }//GEN-LAST:event_jmiReporteOperacionesActionPerformed

    private void jmiMantServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMantServiciosActionPerformed
        MantServUI mantServUI = new MantServUI();
        jdpFrames.add(mantServUI);
        mantServUI.show();
    }//GEN-LAST:event_jmiMantServiciosActionPerformed

    private void jmiImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiImportarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiImportarActionPerformed

    private void jbVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVentasActionPerformed
        LstVentasUI lstVentasUI = new LstVentasUI();
        jdpFrames.add(lstVentasUI);
        lstVentasUI.show();
    }//GEN-LAST:event_jbVentasActionPerformed

    private void jbCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCatalogoActionPerformed
        CatalogoUI catalogoUI = new CatalogoUI();
        jdpFrames.add(catalogoUI);
        catalogoUI.show();
    }//GEN-LAST:event_jbCatalogoActionPerformed

    private void jbCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCajaActionPerformed
        CajaUI cajaUI = new CajaUI();
        jdpFrames.add(cajaUI);
        cajaUI.show();
    }//GEN-LAST:event_jbCajaActionPerformed

    private void jbClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbClientesActionPerformed
        ClienteUI_OLD clienteUI = new ClienteUI_OLD();
        clienteUI.pack();
        clienteUI.setLocationRelativeTo(null);
        clienteUI.setVisible(true);
    }//GEN-LAST:event_jbClientesActionPerformed

    private void jbConfigurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfigurarActionPerformed
        ConfigUI configUI = new ConfigUI();
        jdpFrames.add(configUI);
        configUI.show();
    }//GEN-LAST:event_jbConfigurarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JButton jbCaja;
    private javax.swing.JButton jbCatalogo;
    private javax.swing.JButton jbClientes;
    private javax.swing.JButton jbConfigurar;
    private javax.swing.JButton jbGraficos;
    private javax.swing.JButton jbInventario;
    private javax.swing.JButton jbReportes;
    private javax.swing.JButton jbVentas;
    private javax.swing.JDesktopPane jdpFrames;
    private javax.swing.JMenuItem jmiBuscarCliente;
    private javax.swing.JMenuItem jmiBuscarVenta;
    private javax.swing.JMenuItem jmiExportar;
    private javax.swing.JMenuItem jmiGuardar;
    private javax.swing.JMenuItem jmiImportar;
    private javax.swing.JMenuItem jmiLimpiar;
    private javax.swing.JMenuItem jmiMantServicios;
    private javax.swing.JMenuItem jmiNuevaVenta;
    private javax.swing.JMenuItem jmiNuevoCliente;
    private javax.swing.JMenuItem jmiReporteOperaciones;
    private javax.swing.JMenuItem jmiSotck;
    private javax.swing.JMenuItem jmiUsuario;
    // End of variables declaration//GEN-END:variables
}
