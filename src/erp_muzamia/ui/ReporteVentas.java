/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package erp_muzamia.ui;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import erp_muzamia.dao.DaoFacturas;
import erp_muzamia.dao.DaoOperacion;
//import erp_muzamia.dao.DaoMetPago;
import erp_muzamia.dao.DaoUsuarios;
import erp_muzamia.dao.impl.DaoFacturasImpl;
import erp_muzamia.dao.impl.DaoOperacionImpl;
//import erp_muzamia.dao.impl.DaoMetPagoImpl;
import erp_muzamia.dao.impl.DaoUsuariosImpl;
import erp_muzamia.dto.Facturas;
import erp_muzamia.dto.Operacion;
//import erp_muzamia.dto.Metodo_pago;
import erp_muzamia.dto.Usuarios;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import org.w3c.dom.css.RGBColor;

/**
 *
 * @author User
 */
public class ReporteVentas extends javax.swing.JInternalFrame {

    /**
     * Creates new form ReporteVentas
     */
    public ReporteVentas() {
        initComponents();
        listarColumnasTabla();
        listarVentas();
        listarTotxEst();
//        listarTotxMet();
    }

    public void listarVentas() {
        DaoOperacion daoOperacion = new DaoOperacionImpl();
        List<Object[]> list = daoOperacion.listarOperaciones();
        DefaultTableModel model = (DefaultTableModel) jtVentas.getModel();
        model.setRowCount(0);

        Object[] row;
        int idTope = 0;

        for (int i = 0; i < list.size(); i++) {
            row = new Object[17];
            row = list.get(i);
            model.addRow(row);
        };

        jlCnt.setText("" + list.size());
    }

    public void listarVentas(String fecIni, String fecFin) {
        DaoOperacion daoOperacion = new DaoOperacionImpl();
        List<Object[]> list = daoOperacion.listarOperaciones(fecIni, fecFin);
        DefaultTableModel model = (DefaultTableModel) jtVentas.getModel();
        model.setRowCount(0);

        Object[] row;

        for (int i = 0; i < list.size(); i++) {
            row = new Object[17];
            row = list.get(i);
            model.addRow(row);
        };

        jlCnt.setText("" + list.size());
    }

    public void listarTotxEst() {
        DaoUsuarios daoUsuarios = new DaoUsuariosImpl();
        List<Usuarios> list = daoUsuarios.listarUsuarios();
        Double[] user = new Double[list.size()];

        for (int i = 0; i < list.size(); i++) {
            user[i] = 0.0;
        };

        Integer ID;

//        for (int i = 1; i < jtVentas.getRowCount(); i++) {
//            ID = Integer.parseInt(jtVentas.getModel().getValueAt(i, 5).toString()) - 2;
//            user[ID] += Double.parseDouble(jtVentas.getModel().getValueAt(i, 10).toString());
//        };
//        DefaultTableModel model = (DefaultTableModel) jtTotxEst.getModel();
//        Object[] row;
//
//        for (int i = 0; i < list.size(); i++) {
//            row = new Object[3];
//            row[0] = list.get(i).getUser_id();
//            row[1] = list.get(i).getUser_nombres();
//            if (user[i] == null) {
//                row[2] = 0.0;
//            } else {
//                row[2] = user[i];
//            }
//            model.addRow(row);
//        };
    }

//    public void listarTotxMet() {
//        DaoMetPago daoMetPago = new DaoMetPagoImpl();
//        List<Metodo_pago> list = daoMetPago.listarMetodoPago();
//        Double[] met = new Double[list.size()];
//
//        for (int i = 0; i < list.size(); i++) {
//            met[i] = 0.0;
//        };
//
//        Integer ID;
//
//        for (int i = 1; i < jtVentas.getRowCount(); i++) {
//            ID = Integer.parseInt(jtVentas.getModel().getValueAt(i, 7).toString()) - 1;
//            met[ID] += Double.parseDouble(jtVentas.getModel().getValueAt(i, 11).toString());
//        };
//
//        DefaultTableModel model = (DefaultTableModel) jtTotxMet.getModel();
//
//        Object[] row;
//
//        for (int i = 0; i < list.size(); i++) {
//            row = new Object[3];
//            row[0] = list.get(i).getMpag_id();
//            row[1] = list.get(i).getMpag_descripcion();   
//            if (met[i] == null) {
//                row[2] = 0.0;
//            } else {
//                row[2] = met[i];
//            }
//            model.addRow(row);
//        };
//    }
    public void listarTotxFec() {
        String fecNew = "";
        String fecLst = "";
        double tot = 0.0;
        int cnt = 0;

        for (int i = 1; i < jtVentas.getRowCount(); i++) {
            fecNew = jtVentas.getModel().getValueAt(i, 1).toString();
            if (fecNew != fecLst) {
                fecLst = fecNew;
                cnt++;
            } else {
                tot += Double.parseDouble(jtVentas.getModel().getValueAt(i, 11).toString());
            }
        };

        Double[] fec = new Double[cnt];

        Integer ID;

        for (int i = 1; i < jtVentas.getRowCount(); i++) {
            ID = Integer.parseInt(jtVentas.getModel().getValueAt(i, 1).toString());
            fec[ID] += Double.parseDouble(jtVentas.getModel().getValueAt(i, 11).toString());
        };

//        DefaultTableModel model = (DefaultTableModel) jtTotxMet.getModel();
//        Object[] row;
//        for (int i = 0; i < list.size(); i++) {
//            row = new Object[3];
//            row[0] = list.get(i).getMpag_id();
//            row[1] = list.get(i).getMpag_descripcion();   
//            if (fec[i] == null) {
//                row[2] = 0.0;
//            } else {
//                row[2] = met[i];
//            }
//            model.addRow(row);
//        };
    }

    public void listarColumnasTabla() {
        jtVentas.getColumnModel().getColumn(0).setMaxWidth(70);
        jtVentas.getColumnModel().getColumn(0).setMinWidth(70);
        jtVentas.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(70);
        jtVentas.getTableHeader().getColumnModel().getColumn(0).setMinWidth(70);

        jtVentas.getColumnModel().getColumn(1).setMaxWidth(0);
        jtVentas.getColumnModel().getColumn(1).setMinWidth(0);
        jtVentas.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
        jtVentas.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);

        jtVentas.getColumnModel().getColumn(2).setMaxWidth(0);
        jtVentas.getColumnModel().getColumn(2).setMinWidth(0);
        jtVentas.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(0);
        jtVentas.getTableHeader().getColumnModel().getColumn(2).setMinWidth(0);

        jtVentas.getColumnModel().getColumn(3).setMaxWidth(110);
        jtVentas.getColumnModel().getColumn(3).setMinWidth(110);
        jtVentas.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(110);
        jtVentas.getTableHeader().getColumnModel().getColumn(3).setMinWidth(110);

        jtVentas.getColumnModel().getColumn(4).setMaxWidth(0);
        jtVentas.getColumnModel().getColumn(4).setMinWidth(0);
        jtVentas.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(0);
        jtVentas.getTableHeader().getColumnModel().getColumn(4).setMinWidth(0);

        jtVentas.getColumnModel().getColumn(5).setMaxWidth(110);
        jtVentas.getColumnModel().getColumn(5).setMinWidth(110);
        jtVentas.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(110);
        jtVentas.getTableHeader().getColumnModel().getColumn(5).setMinWidth(110);

        jtVentas.getColumnModel().getColumn(6).setMaxWidth(0);
        jtVentas.getColumnModel().getColumn(6).setMinWidth(0);
        jtVentas.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
        jtVentas.getTableHeader().getColumnModel().getColumn(6).setMinWidth(0);

        jtVentas.getColumnModel().getColumn(7).setMaxWidth(0);
        jtVentas.getColumnModel().getColumn(7).setMinWidth(0);
        jtVentas.getTableHeader().getColumnModel().getColumn(7).setMaxWidth(0);
        jtVentas.getTableHeader().getColumnModel().getColumn(7).setMinWidth(0);

        jtVentas.getColumnModel().getColumn(8).setMaxWidth(0);
        jtVentas.getColumnModel().getColumn(8).setMinWidth(0);
        jtVentas.getTableHeader().getColumnModel().getColumn(8).setMaxWidth(0);
        jtVentas.getTableHeader().getColumnModel().getColumn(8).setMinWidth(0);

        jtVentas.getColumnModel().getColumn(9).setMaxWidth(0);
        jtVentas.getColumnModel().getColumn(9).setMinWidth(0);
        jtVentas.getTableHeader().getColumnModel().getColumn(9).setMaxWidth(0);
        jtVentas.getTableHeader().getColumnModel().getColumn(9).setMinWidth(0);

        jtVentas.getColumnModel().getColumn(10).setMaxWidth(0);
        jtVentas.getColumnModel().getColumn(10).setMinWidth(0);
        jtVentas.getTableHeader().getColumnModel().getColumn(10).setMaxWidth(0);
        jtVentas.getTableHeader().getColumnModel().getColumn(10).setMinWidth(0);

        jtVentas.getColumnModel().getColumn(11).setMaxWidth(80);
        jtVentas.getColumnModel().getColumn(11).setMinWidth(80);
        jtVentas.getTableHeader().getColumnModel().getColumn(11).setMaxWidth(80);
        jtVentas.getTableHeader().getColumnModel().getColumn(11).setMinWidth(80);

        jtVentas.getColumnModel().getColumn(12).setMaxWidth(80);
        jtVentas.getColumnModel().getColumn(12).setMinWidth(80);
        jtVentas.getTableHeader().getColumnModel().getColumn(12).setMaxWidth(80);
        jtVentas.getTableHeader().getColumnModel().getColumn(12).setMinWidth(80);

        jtVentas.getColumnModel().getColumn(13).setMaxWidth(80);
        jtVentas.getColumnModel().getColumn(13).setMinWidth(80);
        jtVentas.getTableHeader().getColumnModel().getColumn(13).setMaxWidth(80);
        jtVentas.getTableHeader().getColumnModel().getColumn(13).setMinWidth(80);

        jtVentas.getColumnModel().getColumn(14).setMaxWidth(0);
        jtVentas.getColumnModel().getColumn(14).setMinWidth(0);
        jtVentas.getTableHeader().getColumnModel().getColumn(14).setMaxWidth(0);
        jtVentas.getTableHeader().getColumnModel().getColumn(14).setMinWidth(0);

        jtVentas.getColumnModel().getColumn(15).setMaxWidth(80);
        jtVentas.getColumnModel().getColumn(15).setMinWidth(80);
        jtVentas.getTableHeader().getColumnModel().getColumn(15).setMaxWidth(80);
        jtVentas.getTableHeader().getColumnModel().getColumn(15).setMinWidth(80);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtVentas = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jdcInicio = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jdcFin = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jbBuscar = new javax.swing.JButton();
        jlCnt = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("REPORTE DE OPERACIONES");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jtVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nro. Item", "ID", "tope_id", "Tipo Operación", "mpag_id", "Método de Pago", "clie_id", "Cliente", "prov_id", "Proveedor", "Última mod.", "Mnt. Oper.", "Mnt. Cobr.", "Mnt. Pag.", "Mnt. Vto.", "Saldo", "Fecha Oper."
            }
        ));
        jtVentas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtVentas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtVentas.setShowGrid(true);
        jScrollPane1.setViewportView(jtVentas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 784, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 441, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel11.setText("Fecha Inicio:");

        jdcInicio.setDateFormatString("yyyy-MM-dd");

        jLabel1.setText("Fecha Fin:");

        jdcFin.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jdcInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jdcFin, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jdcFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdcInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbBuscar)
                .addGap(84, 84, 84))
        );

        jlCnt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jlCnt.setText("Nro. reg");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Total de registros:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jlCnt)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCnt)
                    .addComponent(jLabel3))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fecIni = "";
        String fecFin = "";

        try {
            fecIni = sdf.format(jdcInicio.getDate());
        } catch (NullPointerException e) {
            fecIni = "0001-01-01";
        }

        try {
            fecFin = sdf.format(jdcFin.getDate());
        } catch (NullPointerException e) {
            fecFin = "9999-12-31";
        }

        listarVentas(fecIni, fecFin);
    }//GEN-LAST:event_jbBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscar;
    private com.toedter.calendar.JDateChooser jdcFin;
    private com.toedter.calendar.JDateChooser jdcInicio;
    private javax.swing.JLabel jlCnt;
    private javax.swing.JTable jtVentas;
    // End of variables declaration//GEN-END:variables
}
