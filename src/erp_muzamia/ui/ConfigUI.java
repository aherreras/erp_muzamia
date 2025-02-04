/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package erp_muzamia.ui;

import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class ConfigUI extends javax.swing.JInternalFrame {

    /**
     * Creates new form ConfigUI
     */
    public ConfigUI() {
        initComponents();
//        try {
//            this.setMaximum(true);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Fatal Error", JOptionPane.ERROR_MESSAGE);
//        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbConfCateServ = new javax.swing.JButton();
        jbConfServ = new javax.swing.JButton();
        jbConfFormPago = new javax.swing.JButton();
        jbConfTipOperacion = new javax.swing.JButton();
        jbConfPeriodo = new javax.swing.JButton();
        jbConfProveedores = new javax.swing.JButton();
        jbConfProd = new javax.swing.JButton();
        jbConfEstilistas = new javax.swing.JButton();
        jbConfAlmacenes = new javax.swing.JButton();
        jbConfCompPago = new javax.swing.JButton();
        jbConfCateProd = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("CONFIGURACIONES");

        jbConfCateServ.setBackground(new java.awt.Color(204, 255, 255));
        jbConfCateServ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp_muzamia/ui/imgs/icons8-category-30.png"))); // NOI18N
        jbConfCateServ.setText("CAT. SERVICIOS");
        jbConfCateServ.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbConfCateServ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfCateServActionPerformed(evt);
            }
        });

        jbConfServ.setBackground(new java.awt.Color(204, 204, 255));
        jbConfServ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp_muzamia/ui/imgs/icons8-list-30.png"))); // NOI18N
        jbConfServ.setText("SERVICIOS");
        jbConfServ.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbConfServ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfServActionPerformed(evt);
            }
        });

        jbConfFormPago.setText("Configurar FORMAS DE PAGO");
        jbConfFormPago.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbConfFormPago.setEnabled(false);

        jbConfTipOperacion.setText("Configurar TIPO DE OPERACION");
        jbConfTipOperacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbConfTipOperacion.setEnabled(false);

        jbConfPeriodo.setBackground(new java.awt.Color(0, 153, 153));
        jbConfPeriodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp_muzamia/ui/imgs/icons8-investment-30.png"))); // NOI18N
        jbConfPeriodo.setText("PERIODOS DE FACTURACION");
        jbConfPeriodo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jbConfProveedores.setText("Configurar PROVEEDORES");
        jbConfProveedores.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbConfProveedores.setEnabled(false);
        jbConfProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfProveedoresActionPerformed(evt);
            }
        });

        jbConfProd.setBackground(new java.awt.Color(204, 255, 204));
        jbConfProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp_muzamia/ui/imgs/icons8-toiletries-30.png"))); // NOI18N
        jbConfProd.setText("PRODUCTOS");
        jbConfProd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbConfProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfProdActionPerformed(evt);
            }
        });

        jbConfEstilistas.setBackground(new java.awt.Color(204, 153, 0));
        jbConfEstilistas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp_muzamia/ui/imgs/icons8-stylist-30.png"))); // NOI18N
        jbConfEstilistas.setText("ESTILISTAS");
        jbConfEstilistas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbConfEstilistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfEstilistasActionPerformed(evt);
            }
        });

        jbConfAlmacenes.setText("Configurar ALMACENES");
        jbConfAlmacenes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbConfAlmacenes.setEnabled(false);
        jbConfAlmacenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfAlmacenesActionPerformed(evt);
            }
        });

        jbConfCompPago.setText("Configurar COMPROBANTES DE PAGO");
        jbConfCompPago.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbConfCompPago.setEnabled(false);
        jbConfCompPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfCompPagoActionPerformed(evt);
            }
        });

        jbConfCateProd.setBackground(new java.awt.Color(255, 204, 204));
        jbConfCateProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp_muzamia/ui/imgs/icons8-category-30.png"))); // NOI18N
        jbConfCateProd.setText("CAT. PRODUCTOS");
        jbConfCateProd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbConfCateProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfCateProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbConfPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jbConfFormPago, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jbConfCateServ, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                            .addComponent(jbConfCateProd, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jbConfServ, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbConfProd, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jbConfTipOperacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jbConfEstilistas, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbConfAlmacenes, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jbConfProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbConfCompPago, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbConfCateServ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbConfCateProd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbConfServ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbConfProd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbConfAlmacenes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbConfEstilistas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbConfCompPago, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbConfProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jbConfFormPago, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jbConfTipOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jbConfPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbConfCateServActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfCateServActionPerformed
        MantCateUI mantCateUI = new MantCateUI(0);
        mantCateUI.pack();
        mantCateUI.setLocationRelativeTo(null);
        mantCateUI.setVisible(true);
    }//GEN-LAST:event_jbConfCateServActionPerformed

    private void jbConfServActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfServActionPerformed
        MantServUI mantServUI = new MantServUI();
        mantServUI.pack();
        mantServUI.setLocationRelativeTo(null);
        mantServUI.setVisible(true);
    }//GEN-LAST:event_jbConfServActionPerformed

    private void jbConfProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfProdActionPerformed
        MantProdUI mantProdUI = new MantProdUI();
        mantProdUI.pack();
        mantProdUI.setLocationRelativeTo(null);
        mantProdUI.setVisible(true);
    }//GEN-LAST:event_jbConfProdActionPerformed

    private void jbConfEstilistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfEstilistasActionPerformed
        MantEstiUI mantEstiUI = new MantEstiUI();
        mantEstiUI.pack();
        mantEstiUI.setLocationRelativeTo(null);
        mantEstiUI.setVisible(true);
    }//GEN-LAST:event_jbConfEstilistasActionPerformed

    private void jbConfProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfProveedoresActionPerformed
        MantProvUI mantProvUI = new MantProvUI();
        mantProvUI.pack();
        mantProvUI.setLocationRelativeTo(null);
        mantProvUI.setVisible(true);
    }//GEN-LAST:event_jbConfProveedoresActionPerformed

    private void jbConfAlmacenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfAlmacenesActionPerformed
//        MantAlmacenUI mantAlmacen = new MantAlmacenUI();
//        mantAlmacen.pack();
//        mantAlmacen.setLocationRelativeTo(null);
//        mantAlmacen.setVisible(true);
    }//GEN-LAST:event_jbConfAlmacenesActionPerformed

    private void jbConfCompPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfCompPagoActionPerformed
//        MantCompUI mantComp = new MantCompUI();
//        mantComp.pack();
//        mantComp.setLocationRelativeTo(null);
//        mantComp.setVisible(true);
    }//GEN-LAST:event_jbConfCompPagoActionPerformed

    private void jbConfCateProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfCateProdActionPerformed
        MantCateUI mantCateUI = new MantCateUI(1);
        mantCateUI.pack();
        mantCateUI.setLocationRelativeTo(null);
        mantCateUI.setVisible(true);
    }//GEN-LAST:event_jbConfCateProdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbConfAlmacenes;
    private javax.swing.JButton jbConfCateProd;
    private javax.swing.JButton jbConfCateServ;
    private javax.swing.JButton jbConfCompPago;
    private javax.swing.JButton jbConfEstilistas;
    private javax.swing.JButton jbConfFormPago;
    private javax.swing.JButton jbConfPeriodo;
    private javax.swing.JButton jbConfProd;
    private javax.swing.JButton jbConfProveedores;
    private javax.swing.JButton jbConfServ;
    private javax.swing.JButton jbConfTipOperacion;
    // End of variables declaration//GEN-END:variables
}
