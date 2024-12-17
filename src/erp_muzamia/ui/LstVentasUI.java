/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package erp_muzamia.ui;

import erp_muzamia.dao.DaoOperacion;
import erp_muzamia.dao.impl.DaoOperacionImpl;
import erp_muzamia.dao.DaoCaja;
import erp_muzamia.dao.DaoMetodoPago;
import erp_muzamia.dao.DaoTipoOperacion;
import erp_muzamia.dao.impl.DaoCajaImpl;
import erp_muzamia.dao.impl.DaoMetodoPagoImpl;
import erp_muzamia.dao.impl.DaoTipoOperacionImpl;
import erp_muzamia.dto.Caja;
import erp_muzamia.dto.MetodoPago;
import erp_muzamia.dto.TipoOperacion;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class LstVentasUI extends javax.swing.JInternalFrame {

    /**
     * Creates new form LstVentasIU
     */
    public LstVentasUI() {
        initComponents();
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        double with = screenSize.getWidth();
//        double height = screenSize.getHeight();
//        this.setBounds(0, 0, (int) with * 2 / 3, (int) height);
//        try {
//            this.setMaximum(true);
//        } catch (Exception e) {
//
//        }
        listarColumnasTabla();
        listarVentas();
        listarCajas();
        listarMetodosDePago();
        listarTiposOperacion();
    }

    Object[][] obj_caja;
    Object[][] obj_met_pago;
    Object[][] obj_tip_operacion;

    public void listarColumnasTabla() {
        jtVentas.getColumnModel().getColumn(0).setMaxWidth(50);
        jtVentas.getColumnModel().getColumn(0).setMinWidth(50);
        jtVentas.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(50);
        jtVentas.getTableHeader().getColumnModel().getColumn(0).setMinWidth(50);

        jtVentas.getColumnModel().getColumn(1).setMaxWidth(65);
        jtVentas.getColumnModel().getColumn(1).setMinWidth(65);
        jtVentas.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(65);
        jtVentas.getTableHeader().getColumnModel().getColumn(1).setMinWidth(65);

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

        jtVentas.getColumnModel().getColumn(7).setMaxWidth(150);
        jtVentas.getColumnModel().getColumn(7).setMinWidth(150);
        jtVentas.getTableHeader().getColumnModel().getColumn(7).setMaxWidth(150);
        jtVentas.getTableHeader().getColumnModel().getColumn(7).setMinWidth(150);

        jtVentas.getColumnModel().getColumn(8).setMaxWidth(0);
        jtVentas.getColumnModel().getColumn(8).setMinWidth(0);
        jtVentas.getTableHeader().getColumnModel().getColumn(8).setMaxWidth(0);
        jtVentas.getTableHeader().getColumnModel().getColumn(8).setMinWidth(0);

        jtVentas.getColumnModel().getColumn(9).setMaxWidth(150);
        jtVentas.getColumnModel().getColumn(9).setMinWidth(150);
        jtVentas.getTableHeader().getColumnModel().getColumn(9).setMaxWidth(150);
        jtVentas.getTableHeader().getColumnModel().getColumn(9).setMinWidth(150);

        jtVentas.getColumnModel().getColumn(10).setMaxWidth(0);
        jtVentas.getColumnModel().getColumn(10).setMinWidth(0);
        jtVentas.getTableHeader().getColumnModel().getColumn(10).setMaxWidth(0);
        jtVentas.getTableHeader().getColumnModel().getColumn(10).setMinWidth(0);

        jtVentas.getColumnModel().getColumn(11).setMaxWidth(80);
        jtVentas.getColumnModel().getColumn(11).setMinWidth(80);
        jtVentas.getTableHeader().getColumnModel().getColumn(11).setMaxWidth(80);
        jtVentas.getTableHeader().getColumnModel().getColumn(11).setMinWidth(80);

        jtVentas.getColumnModel().getColumn(12).setMaxWidth(0);
        jtVentas.getColumnModel().getColumn(12).setMinWidth(0);
        jtVentas.getTableHeader().getColumnModel().getColumn(12).setMaxWidth(0);
        jtVentas.getTableHeader().getColumnModel().getColumn(12).setMinWidth(0);

        jtVentas.getColumnModel().getColumn(13).setMaxWidth(80);
        jtVentas.getColumnModel().getColumn(13).setMinWidth(80);
        jtVentas.getTableHeader().getColumnModel().getColumn(13).setMaxWidth(80);
        jtVentas.getTableHeader().getColumnModel().getColumn(13).setMinWidth(80);

        jtVentas.getColumnModel().getColumn(14).setMaxWidth(0);
        jtVentas.getColumnModel().getColumn(14).setMinWidth(0);
        jtVentas.getTableHeader().getColumnModel().getColumn(14).setMaxWidth(0);
        jtVentas.getTableHeader().getColumnModel().getColumn(14).setMinWidth(0);

        jtVentas.getColumnModel().getColumn(15).setMaxWidth(0);
        jtVentas.getColumnModel().getColumn(15).setMinWidth(0);
        jtVentas.getTableHeader().getColumnModel().getColumn(15).setMaxWidth(0);
        jtVentas.getTableHeader().getColumnModel().getColumn(15).setMinWidth(0);

        jtVentas.getColumnModel().getColumn(16).setMaxWidth(100);
        jtVentas.getColumnModel().getColumn(16).setMinWidth(100);
        jtVentas.getTableHeader().getColumnModel().getColumn(16).setMaxWidth(100);
        jtVentas.getTableHeader().getColumnModel().getColumn(16).setMinWidth(100);

        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                if (jtVentas.isEditing()) {
                    jtVentas.getCellEditor().stopCellEditing();
                }
                int idVenta = Integer.parseInt(jtVentas.getModel().getValueAt(row, 1).toString());
                VentasUI ventasUI = new VentasUI(idVenta);
                ventasUI.pack();
                ventasUI.setLocationRelativeTo(null);
                ventasUI.setVisible(true);
            }

            @Override
            public void onDelete(int row) {
                if (jtVentas.isEditing()) {
                    jtVentas.getCellEditor().stopCellEditing();
                }

                int Ok = JOptionPane.showConfirmDialog(null, "¿Desea eliminar registro de Venta?", "Eliminar Venta", JOptionPane.YES_NO_OPTION);

                if (Ok == 0) {

                }

                return;
            }

            @Override
            public void onView(int row) {
                if (jtVentas.isEditing()) {
                    jtVentas.getCellEditor().stopCellEditing();
                }

                int idVenta = Integer.parseInt(jtVentas.getModel().getValueAt(row, 1).toString());

            }
        };

        jtVentas.getColumnModel()
                .getColumn(17).setCellRenderer(new TableActionCellRender());
        jtVentas.getColumnModel()
                .getColumn(17).setCellEditor(new TableActionCellEditor(event));
        
        jtVentas.getColumnModel().getColumn(17).setMaxWidth(200);
        jtVentas.getColumnModel().getColumn(17).setMinWidth(200);
        jtVentas.getTableHeader().getColumnModel().getColumn(17).setMaxWidth(200);
        jtVentas.getTableHeader().getColumnModel().getColumn(17).setMinWidth(200);
    }

    public void listarCajas() {
        DaoCaja daoCaja = new DaoCajaImpl();
        List<Caja> list = daoCaja.lstCajas_2();

        obj_caja = new Integer[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            jcbCaja.addItem(list.get(i).getCaja_descripcion());
            obj_caja[i][0] = i;
            obj_caja[i][1] = list.get(i).getCaja_id();
        };
    }

    public void listarMetodosDePago() {
        DaoMetodoPago daoMetodoPago = new DaoMetodoPagoImpl();
        List<MetodoPago> list = daoMetodoPago.lstMetodosPago_2();

        obj_met_pago = new Integer[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            jcbMetodoPago.addItem(list.get(i).getMpag_descripcion());
            obj_met_pago[i][0] = i;
            obj_met_pago[i][1] = list.get(i).getMpag_id();
        };
    }

    public void listarTiposOperacion() {
        DaoTipoOperacion daoTipoOperacion = new DaoTipoOperacionImpl();
        List<TipoOperacion> list = daoTipoOperacion.lstTiposOperacion_2();

        obj_tip_operacion = new Integer[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            jcbTipoOperacion.addItem(list.get(i).getTope_descripcion());
            obj_tip_operacion[i][0] = i;
            obj_tip_operacion[i][1] = list.get(i).getTope_id();
        };
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
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtVentas = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcbTipoOperacion = new javax.swing.JComboBox<>();
        jcbMetodoPago = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jbNuevaVenta = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtfMayorQ = new javax.swing.JTextField();
        jtfMenorQ = new javax.swing.JTextField();
        jcbCaja = new javax.swing.JComboBox<>();
        jbFiltro = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jtfRazSocProv = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jtfNomCliente = new javax.swing.JTextField();
        jdcInicio = new com.toedter.calendar.JDateChooser();
        jdcFin = new com.toedter.calendar.JDateChooser();
        jbRefresh = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setTitle("VENTAS");

        jtVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "ID Venta", "ID Oper.", "Tipo Operación", "ID Mét.", "Método de Pago", "ID Cli.", "Cliente", "ID Prov.", "Proveedor", "Última mod.", "Mnt. Oper.", "Mnt. Cobr.", "Mnt. Pag.", "Mnt. Vto.", "Saldo", "Fecha Oper.", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtVentas.setRowHeight(40);
        jtVentas.setSelectionBackground(new java.awt.Color(57, 137, 97));
        jtVentas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtVentas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtVentas.setShowGrid(true);
        jScrollPane1.setViewportView(jtVentas);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Periodo:");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setEnabled(false);

        jLabel2.setText("Método de pago:");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel2.setEnabled(false);

        jLabel3.setText("Tipo de operación:");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel3.setEnabled(false);

        jcbTipoOperacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar tipo de operación ..." }));
        jcbTipoOperacion.setEnabled(false);

        jcbMetodoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar método de pago ..." }));
        jcbMetodoPago.setEnabled(false);

        jLabel9.setText("Monto mayor que:");
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel9.setEnabled(false);

        jbNuevaVenta.setBackground(new java.awt.Color(153, 153, 255));
        jbNuevaVenta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbNuevaVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp_muzamia/ui/imgs/icons8-add-shopping-cart-48.png"))); // NOI18N
        jbNuevaVenta.setText("Nuevo");
        jbNuevaVenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbNuevaVenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbNuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevaVentaActionPerformed(evt);
            }
        });

        jLabel10.setText("Monto menor que:");
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel10.setEnabled(false);

        jLabel11.setText("Fecha ope. Fin:");
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtfMayorQ.setEnabled(false);

        jtfMenorQ.setEnabled(false);

        jcbCaja.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar periodo ..." }));
        jcbCaja.setEnabled(false);

        jbFiltro.setBackground(new java.awt.Color(153, 255, 255));
        jbFiltro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbFiltro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp_muzamia/ui/imgs/icons8-filter-48.png"))); // NOI18N
        jbFiltro.setText("Filtro");
        jbFiltro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbFiltro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFiltroActionPerformed(evt);
            }
        });

        jLabel12.setText("Nombre cliente:");
        jLabel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel12.setEnabled(false);

        jLabel13.setText("Fecha ope. Ini:");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtfRazSocProv.setEnabled(false);

        jLabel14.setText("Raz. Soc. proveedor:");
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel14.setEnabled(false);

        jtfNomCliente.setEnabled(false);

        jdcInicio.setDateFormatString("yyyy-MM-dd");
        jdcInicio.setMinimumSize(new java.awt.Dimension(120, 22));
        jdcInicio.setPreferredSize(new java.awt.Dimension(120, 22));

        jdcFin.setDateFormatString("yyyy-MM-dd");
        jdcFin.setMinimumSize(new java.awt.Dimension(120, 22));
        jdcFin.setPreferredSize(new java.awt.Dimension(120, 22));

        jbRefresh.setBackground(new java.awt.Color(153, 153, 255));
        jbRefresh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp_muzamia/ui/imgs/icons8-refresh-48.png"))); // NOI18N
        jbRefresh.setText("Refresh");
        jbRefresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbRefresh.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jcbMetodoPago, 0, 1, Short.MAX_VALUE)
                    .addComponent(jcbTipoOperacion, 0, 1, Short.MAX_VALUE)
                    .addComponent(jcbCaja, 0, 165, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfNomCliente)
                    .addComponent(jtfRazSocProv)
                    .addComponent(jdcInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfMayorQ, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .addComponent(jtfMenorQ, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .addComponent(jdcFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jbFiltro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbNuevaVenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbRefresh)
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfMayorQ))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfMenorQ))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jdcFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jbNuevaVenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbTipoOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jbFiltro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfRazSocProv))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfNomCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jdcInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jbRefresh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbNuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevaVentaActionPerformed
        VentasUI ventaUI = new VentasUI();
        ventaUI.pack();
        ventaUI.setLocationRelativeTo(null);
        ventaUI.setVisible(true);
    }//GEN-LAST:event_jbNuevaVentaActionPerformed

    private void jbFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFiltroActionPerformed
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
    }//GEN-LAST:event_jbFiltroActionPerformed

    private void jbRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRefreshActionPerformed
        listarVentas();
    }//GEN-LAST:event_jbRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbFiltro;
    private javax.swing.JButton jbNuevaVenta;
    private javax.swing.JButton jbRefresh;
    private javax.swing.JComboBox<String> jcbCaja;
    private javax.swing.JComboBox<String> jcbMetodoPago;
    private javax.swing.JComboBox<String> jcbTipoOperacion;
    private com.toedter.calendar.JDateChooser jdcFin;
    private com.toedter.calendar.JDateChooser jdcInicio;
    private javax.swing.JTable jtVentas;
    private javax.swing.JTextField jtfMayorQ;
    private javax.swing.JTextField jtfMenorQ;
    private javax.swing.JTextField jtfNomCliente;
    private javax.swing.JTextField jtfRazSocProv;
    // End of variables declaration//GEN-END:variables
}