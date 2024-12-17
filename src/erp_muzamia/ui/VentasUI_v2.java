/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package erp_muzamia.ui;

import erp_muzamia.dao.DaoCategorias;
import erp_muzamia.dao.DaoDetOperacion;
import erp_muzamia.dao.DaoOperacion;
import erp_muzamia.dao.DaoServicios;
import erp_muzamia.dao.DaoUsuarios;
import erp_muzamia.dao.impl.DaoCategoriasImpl;
import erp_muzamia.dao.impl.DaoDetOperacionImpl;
import erp_muzamia.dao.impl.DaoOperacionImpl;
import erp_muzamia.dao.impl.DaoServiciosImpl;
import erp_muzamia.dao.impl.DaoUsuariosImpl;
import erp_muzamia.dto.Categorias;
import erp_muzamia.dto.DetOperacion;
import erp_muzamia.dto.Operacion;
import erp_muzamia.dto.Servicios;
import erp_muzamia.dto.Usuarios;
import java.awt.GraphicsEnvironment;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class VentasUI_v2 extends javax.swing.JFrame {

    /**
     * Creates new form VentasUI2
     */
    public VentasUI_v2() {
        initComponents();
        listarCategorias();
        listarColumnasTabla();
        listarEstilistas();

        Date date = new Date();
        jdcFechaOpe.setDate(date);

        inicializarDatos();
    }
    
    public VentasUI_v2(int idVenta) {
        initComponents();
        listarCategorias();
        listarColumnasTabla();
        listarEstilistas();

        Date date = new Date();
        jdcFechaOpe.setDate(date);

        inicializarDatos();
    }

    Object[][] obj_cate;
    Object[][] obj_serv;
    Object[][] obj_estl;
    Double subTotalVenta;
    Double descuentoVenta;
    Double totalVenta;
    int met_pago_id;
    public static String nom = "";

    public void inicializarDatos() {
        limpiarDatos();

        habilita_Panel_Dat_Operacion(false);
        habilita_Panel_Met_Pago(false);
        habilita_Panel_Pago(false);

// Botones laterales
        jbNuevaVenta.setEnabled(true);
        jbLimpiar.setEnabled(false);
        jbGuardarVenta.setEnabled(false);
        jbAgregarServicio.setEnabled(false);
        jbPagar.setEnabled(false);
        jbFinalizarVenta.setEnabled(false);
        jbCancelarVenta.setEnabled(false);

        DefaultTableModel model = (DefaultTableModel) jtVentas.getModel();
        model.setRowCount(0);

        subTotalVenta = 0.0;
        descuentoVenta = 0.0;
        totalVenta = 0.0;
        jlTotalVenta.setText("S/. 0.0");
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

        jtVentas.getColumnModel().getColumn(2).setMaxWidth(120);
        jtVentas.getColumnModel().getColumn(2).setMinWidth(120);
        jtVentas.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(120);
        jtVentas.getTableHeader().getColumnModel().getColumn(2).setMinWidth(120);

        jtVentas.getColumnModel().getColumn(3).setMaxWidth(0);
        jtVentas.getColumnModel().getColumn(3).setMinWidth(0);
        jtVentas.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(0);
        jtVentas.getTableHeader().getColumnModel().getColumn(3).setMinWidth(0);

        jtVentas.getColumnModel().getColumn(4).setMaxWidth(120);
        jtVentas.getColumnModel().getColumn(4).setMinWidth(120);
        jtVentas.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(120);
        jtVentas.getTableHeader().getColumnModel().getColumn(4).setMinWidth(120);

        jtVentas.getColumnModel().getColumn(5).setMaxWidth(0);
        jtVentas.getColumnModel().getColumn(5).setMinWidth(0);
        jtVentas.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
        jtVentas.getTableHeader().getColumnModel().getColumn(5).setMinWidth(0);

        jtVentas.getColumnModel().getColumn(6).setMaxWidth(150);
        jtVentas.getColumnModel().getColumn(6).setMinWidth(150);
        jtVentas.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(150);
        jtVentas.getTableHeader().getColumnModel().getColumn(6).setMinWidth(150);

        jtVentas.getColumnModel().getColumn(7).setMaxWidth(70);
        jtVentas.getColumnModel().getColumn(7).setMinWidth(70);
        jtVentas.getTableHeader().getColumnModel().getColumn(7).setMaxWidth(70);
        jtVentas.getTableHeader().getColumnModel().getColumn(7).setMinWidth(70);

        jtVentas.getColumnModel().getColumn(8).setMaxWidth(70);
        jtVentas.getColumnModel().getColumn(8).setMinWidth(70);
        jtVentas.getTableHeader().getColumnModel().getColumn(8).setMaxWidth(70);
        jtVentas.getTableHeader().getColumnModel().getColumn(8).setMinWidth(70);

        jtVentas.getColumnModel().getColumn(9).setMaxWidth(70);
        jtVentas.getColumnModel().getColumn(9).setMinWidth(70);
        jtVentas.getTableHeader().getColumnModel().getColumn(9).setMaxWidth(70);
        jtVentas.getTableHeader().getColumnModel().getColumn(9).setMinWidth(70);

        jtVentas.getColumnModel().getColumn(10).setMaxWidth(70);
        jtVentas.getColumnModel().getColumn(10).setMinWidth(70);
        jtVentas.getTableHeader().getColumnModel().getColumn(10).setMaxWidth(70);
        jtVentas.getTableHeader().getColumnModel().getColumn(10).setMinWidth(70);
    }

    public void listarCategorias() {
        DaoCategorias daoCategorias = new DaoCategoriasImpl();
        List<Categorias> list = daoCategorias.lst_Categorias_2();
        obj_cate = new Integer[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            jcbCategorias.addItem(list.get(i).getCate_descripcion());
            obj_cate[i][0] = i;
            obj_cate[i][1] = list.get(i).getCate_id();
        };
    }

    public void listarServicios(Integer id) {
        DaoServicios daoServicios = new DaoServiciosImpl();
        List<Servicios> list = daoServicios.lst_Servicios_x_Cate_2(id);
        obj_serv = new Integer[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            jcbServicios.addItem(list.get(i).getServ_nombre());
            obj_serv[i][0] = i;
            obj_serv[i][1] = list.get(i).getServ_id();
        };
    }

    public void listarEstilistas() {
        DaoUsuarios daoUsuarios = new DaoUsuariosImpl();
        List<Usuarios> list = daoUsuarios.listarUsuarios();
        obj_estl = new Integer[list.size()][2];
        String nombre = "";

        for (int i = 0; i < list.size(); i++) {
            nombre = list.get(i).getUser_nombres() + " " + list.get(i).getUser_apellidos();
            jcbEstilistas.addItem(nombre);
            obj_estl[i][0] = i;
            obj_estl[i][1] = list.get(i).getUser_id();
        };
    }

    public Double calculaSubTotal(Double precio, Integer cantidad, Double descuento) {
        Double subTotal = null;
        subTotal = (precio * cantidad) - descuento;
        return subTotal;
    }

    public void addDetalle() {
        Double precio = 0.0;
        Integer cantidad = 0;
        Double subTotal = 0.0;
        Double descuento = 0.0;
        Double total = 0.0;
        DefaultTableModel model = (DefaultTableModel) jtVentas.getModel();

        Object[] row = new Object[12];

        row[0] = model.getRowCount() + 1;

        int ids = jcbServicios.getSelectedIndex() - 1;
        row[1] = Integer.parseInt(obj_serv[ids][1].toString());
        row[2] = jcbServicios.getSelectedItem().toString();

        int idc = jcbCategorias.getSelectedIndex() - 1;
        row[3] = Integer.parseInt(obj_cate[idc][1].toString());
        row[4] = jcbCategorias.getSelectedItem().toString();

        int ide = jcbEstilistas.getSelectedIndex() - 1;
        row[5] = Integer.parseInt(obj_estl[ide][1].toString());
        row[6] = jcbEstilistas.getSelectedItem().toString();

        precio = Double.parseDouble(jtfPrecio.getText());
        row[7] = precio;

        cantidad = Integer.parseInt(jtfCantidad.getText());
        row[8] = cantidad;

        subTotal = precio * cantidad;
        row[9] = subTotal;
        subTotalVenta += subTotal;

        descuento = Double.parseDouble(jtfDescuento.getText());
        row[10] = descuento;
        descuentoVenta += descuento;

        total = Double.parseDouble(jtfTotal.getText());
        row[11] = total;
        totalVenta += total;

        model.addRow(row);

        jlTotalVenta.setText(" S/. " + totalVenta.toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jbAgregarServicio = new javax.swing.JButton();
        jbPagar = new javax.swing.JButton();
        jbGuardarVenta = new javax.swing.JButton();
        jbCancelarVenta = new javax.swing.JButton();
        jbLimpiar = new javax.swing.JButton();
        jbNuevaVenta = new javax.swing.JButton();
        jbFinalizarVenta = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jdcFechaOpe = new com.toedter.calendar.JDateChooser();
        jtfPagoTotal = new javax.swing.JTextField();
        jrbPagoTotal = new javax.swing.JRadioButton();
        jrbPagoParcial = new javax.swing.JRadioButton();
        jtfPagoParcial = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jcbCategorias = new javax.swing.JComboBox<>();
        jcbServicios = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jtfPrecio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfCantidad = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfDescuento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtfTotal = new javax.swing.JTextField();
        jbAplicar = new javax.swing.JButton();
        jbCalcular = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jcbEstilistas = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtVentas = new javax.swing.JTable();
        jlTotalVenta = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jchkbEfectivo = new javax.swing.JCheckBox();
        jchkbConTarjeta = new javax.swing.JCheckBox();
        jchkbPlin = new javax.swing.JCheckBox();
        jchkbYape = new javax.swing.JCheckBox();
        jchkbTransferencia = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REGISTRO DE VENTAS");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Acción"));

        jbAgregarServicio.setBackground(new java.awt.Color(255, 204, 204));
        jbAgregarServicio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbAgregarServicio.setText("Agregar");
        jbAgregarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarServicioActionPerformed(evt);
            }
        });

        jbPagar.setBackground(new java.awt.Color(0, 255, 255));
        jbPagar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbPagar.setText("Pagar");
        jbPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPagarActionPerformed(evt);
            }
        });

        jbGuardarVenta.setBackground(new java.awt.Color(51, 153, 255));
        jbGuardarVenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbGuardarVenta.setForeground(new java.awt.Color(255, 255, 255));
        jbGuardarVenta.setText("Guardar");
        jbGuardarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarVentaActionPerformed(evt);
            }
        });

        jbCancelarVenta.setBackground(new java.awt.Color(255, 153, 0));
        jbCancelarVenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbCancelarVenta.setText("Cancelar Venta");
        jbCancelarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarVentaActionPerformed(evt);
            }
        });

        jbLimpiar.setBackground(new java.awt.Color(204, 204, 255));
        jbLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbLimpiar.setText("Limpiar");
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });

        jbNuevaVenta.setBackground(new java.awt.Color(51, 51, 255));
        jbNuevaVenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbNuevaVenta.setForeground(new java.awt.Color(255, 255, 255));
        jbNuevaVenta.setText("Nueva Venta");
        jbNuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevaVentaActionPerformed(evt);
            }
        });

        jbFinalizarVenta.setBackground(new java.awt.Color(0, 116, 59));
        jbFinalizarVenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbFinalizarVenta.setForeground(new java.awt.Color(255, 255, 255));
        jbFinalizarVenta.setText("Finalizar Venta");
        jbFinalizarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFinalizarVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbNuevaVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbGuardarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbAgregarServicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbCancelarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbFinalizarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jbNuevaVenta)
                .addGap(15, 15, 15)
                .addComponent(jbLimpiar)
                .addGap(15, 15, 15)
                .addComponent(jbGuardarVenta)
                .addGap(15, 15, 15)
                .addComponent(jbAgregarServicio)
                .addGap(15, 15, 15)
                .addComponent(jbPagar)
                .addGap(15, 15, 15)
                .addComponent(jbFinalizarVenta)
                .addGap(15, 15, 15)
                .addComponent(jbCancelarVenta)
                .addGap(5, 5, 5))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Pago"));

        jLabel9.setText("Fecha Oper:");

        jdcFechaOpe.setDateFormatString("yyyy-MM-dd");
        jdcFechaOpe.setMinimumSize(new java.awt.Dimension(120, 22));
        jdcFechaOpe.setPreferredSize(new java.awt.Dimension(120, 22));

        buttonGroup2.add(jrbPagoTotal);
        jrbPagoTotal.setText("Pago Total");
        jrbPagoTotal.setPreferredSize(new java.awt.Dimension(91, 25));
        jrbPagoTotal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrbPagoTotalMouseClicked(evt);
            }
        });

        buttonGroup2.add(jrbPagoParcial);
        jrbPagoParcial.setText("Pago Parcial");
        jrbPagoParcial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrbPagoParcialMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jdcFechaOpe, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jrbPagoParcial)
                        .addGap(8, 8, 8)
                        .addComponent(jtfPagoParcial, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jrbPagoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jtfPagoTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)))
                .addGap(50, 50, 50))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfPagoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jrbPagoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jdcFechaOpe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbPagoParcial)
                    .addComponent(jtfPagoParcial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 255));
        jLabel15.setText("VENTA TOTAL:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Operación"));

        jLabel1.setText("Servicio:");

        jcbCategorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar una Categoría ..." }));
        jcbCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCategoriasActionPerformed(evt);
            }
        });

        jcbServicios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar un Servicio/Producto ..." }));
        jcbServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbServiciosActionPerformed(evt);
            }
        });

        jLabel2.setText("Precio:");

        jLabel3.setText("Categoría:");

        jtfCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCantidadKeyTyped(evt);
            }
        });

        jLabel13.setText("Cant.");

        jLabel5.setText("S/.");

        jLabel4.setText("Descuento:");

        jtfDescuento.setMinimumSize(new java.awt.Dimension(63, 22));
        jtfDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfDescuentoKeyTyped(evt);
            }
        });

        jLabel6.setText("S/.");

        jLabel7.setText("Total:");

        jLabel8.setText("S/.");

        jbAplicar.setText("Aplicar");
        jbAplicar.setEnabled(false);
        jbAplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAplicarActionPerformed(evt);
            }
        });

        jbCalcular.setText("Calcular");
        jbCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCalcularActionPerformed(evt);
            }
        });

        jLabel10.setText("Estilista:");

        jcbEstilistas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar una estilista ..." }));
        jcbEstilistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEstilistasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(36, 36, 36)
                        .addComponent(jcbCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(46, 46, 46)
                        .addComponent(jcbServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(54, 54, 54)
                        .addComponent(jtfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addGap(10, 10, 10)
                        .addComponent(jtfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(31, 31, 31)
                        .addComponent(jtfDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel6)
                        .addGap(16, 16, 16)
                        .addComponent(jbAplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbEstilistas, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jtfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel8)
                                .addGap(16, 16, 16)
                                .addComponent(jbCalcular)))))
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(jLabel6)
                    .addComponent(jbAplicar))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addComponent(jLabel8)
                    .addComponent(jbCalcular))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbEstilistas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(5, 5, 5))
        );

        jtVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nro. Item", "id_Servicio", "Servicio", "id_Categoria", "Categoria", "id_Estilista", "Estilista", "Precio", "Cant.", "Sub Total", "Dscto.", "Total"
            }
        ));
        jScrollPane1.setViewportView(jtVentas);

        jlTotalVenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jlTotalVenta.setForeground(new java.awt.Color(0, 0, 255));
        jlTotalVenta.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jlTotalVenta.setText("S/. 0.0");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Método de Pago"));

        jchkbEfectivo.setBackground(new java.awt.Color(204, 204, 255));
        buttonGroup1.add(jchkbEfectivo);
        jchkbEfectivo.setText("Efectivo");
        jchkbEfectivo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jchkbConTarjeta.setBackground(new java.awt.Color(204, 204, 255));
        buttonGroup1.add(jchkbConTarjeta);
        jchkbConTarjeta.setText("Con tarjeta");
        jchkbConTarjeta.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jchkbPlin.setBackground(new java.awt.Color(204, 204, 255));
        buttonGroup1.add(jchkbPlin);
        jchkbPlin.setText("Plin/IzipayYa");
        jchkbPlin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jchkbYape.setBackground(new java.awt.Color(204, 204, 255));
        buttonGroup1.add(jchkbYape);
        jchkbYape.setText("Yape");
        jchkbYape.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jchkbTransferencia.setBackground(new java.awt.Color(204, 204, 255));
        buttonGroup1.add(jchkbTransferencia);
        jchkbTransferencia.setText("Transferencia");
        jchkbTransferencia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jchkbEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jchkbConTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jchkbTransferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jchkbYape, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jchkbPlin, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jchkbEfectivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jchkbConTarjeta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jchkbTransferencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jchkbYape)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jchkbPlin)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(32, 32, 32)
                .addComponent(jlTotalVenta)
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jlTotalVenta))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAgregarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarServicioActionPerformed
        jcbCategorias.setEnabled(true);
        jcbServicios.setEnabled(true);
        jtfPrecio.setEnabled(true);
        jtfCantidad.setEnabled(true);
        jtfDescuento.setEnabled(true);
        //        jbAplicar.setEnabled(true);
        jbCalcular.setEnabled(true);
        jcbEstilistas.setEnabled(true);

        //Botones laterales
        jbLimpiar.setEnabled(true);
        jbGuardarVenta.setEnabled(true);
        jbAgregarServicio.setEnabled(false);
    }//GEN-LAST:event_jbAgregarServicioActionPerformed

    private void jbPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPagarActionPerformed
        habilita_Panel_Dat_Operacion(false);
        habilita_Panel_Met_Pago(true);
        habilita_Panel_Pago(true);

        jtfPagoTotal.setEnabled(false);
        jtfPagoTotal.setText("" + totalVenta);
        jtfPagoParcial.setText("");

        jbLimpiar.setEnabled(false);
        jbGuardarVenta.setEnabled(false);
        jbAgregarServicio.setEnabled(false);
        jbPagar.setEnabled(false);
        jbFinalizarVenta.setEnabled(true);
    }//GEN-LAST:event_jbPagarActionPerformed

    private void jbGuardarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarVentaActionPerformed
        String message = null;

        if (jtfCantidad.getText().isEmpty()) {
            if (message == null) {
                message = "Validación de campos:\n";
            }
            message += "\n* Ingresar cantidad.";
        }

        if (jtfTotal.getText().isEmpty()) {
            if (message == null) {
                message = "Validación de campos:\n";
            }
            message += "\n* Debe 'Calcular' monto a pagar.";
        }

        if (jcbEstilistas.getSelectedIndex() == 0) {
            if (message == null) {
                message = "Validación de campos:\n";
            }
            message += "\n* Seleccionar Estilista.";
        }

        if (message != null) {
            JOptionPane.showMessageDialog(null, message, "Alerta", JOptionPane.INFORMATION_MESSAGE);
            return;
        } else {
            addDetalle();

            habilita_Panel_Dat_Operacion(false);
            habilita_Panel_Met_Pago(false);
            habilita_Panel_Pago(false);

            jbLimpiar.setEnabled(false);
            jbGuardarVenta.setEnabled(false);
            jbAgregarServicio.setEnabled(true);
            jbPagar.setEnabled(true);
            jbCancelarVenta.setEnabled(true);
        }
    }//GEN-LAST:event_jbGuardarVentaActionPerformed

    private void jbCancelarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarVentaActionPerformed
        inicializarDatos();
    }//GEN-LAST:event_jbCancelarVentaActionPerformed

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
        limpiarDatos();
        jcbCategorias.requestFocus();
        jbGuardarVenta.setEnabled(false);
    }//GEN-LAST:event_jbLimpiarActionPerformed

    private void jbNuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevaVentaActionPerformed
        inicializarDatos();
        jcbCategorias.setEnabled(true);
        jbLimpiar.setEnabled(true);
        jbCancelarVenta.setEnabled(true);

        jbNuevaVenta.setEnabled(false);
    }//GEN-LAST:event_jbNuevaVentaActionPerformed

    private void jbFinalizarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFinalizarVentaActionPerformed
        String message = null;
        double mnt_pagado = 0.0;
        double mnt_cobrado = 0.0;
        double mnt_saldo = 0.0;

        if (jchkbEfectivo.isSelected()) {
            met_pago_id = 1;
        } else if (jchkbConTarjeta.isSelected()) {
            met_pago_id = 2;
        } else if (jchkbTransferencia.isSelected()) {
            met_pago_id = 3;
        } else if (jchkbYape.isSelected()) {
            met_pago_id = 4;
        } else if (jchkbPlin.isSelected()) {
            met_pago_id = 5;
        } else {
            if (message == null) {
                message = "Validación de campos:\n";
            }
            message += "\n* Seleccionar Método de Pago.";
        }

        if (jrbPagoTotal.isSelected()) {
            mnt_pagado = Double.parseDouble(jtfPagoTotal.getText());
        } else if (jrbPagoParcial.isSelected()) {
            mnt_pagado = Double.parseDouble(jtfPagoParcial.getText());
        } else {
            if (message == null) {
                message = "Validación de campos:\n";
            }
            message += "\n* Seleccionar Monto a Pagar.";
        }

        if (message != null) {
            JOptionPane.showMessageDialog(null, message, "Alerta", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int Ok = JOptionPane.showConfirmDialog(null, "El monto a pagar es " + totalVenta + ".\n\n¿Desea finalizar la venta?", "Finalizar Operación", JOptionPane.YES_NO_OPTION);

        if (Ok == 0) {
            try {
                Operacion operacionBE = new Operacion();

                // temporal
                mnt_cobrado = mnt_pagado;
                mnt_saldo = totalVenta - mnt_pagado;

                operacionBE.setTope_id(1);
                operacionBE.setMpag_id(met_pago_id);
                operacionBE.setCaja_id(null);
                operacionBE.setUser_id(2);
                operacionBE.setClie_id(1);
                operacionBE.setProv_id(null);
                operacionBE.setOper_timestamp(null);
                operacionBE.setOper_monto(totalVenta);
                operacionBE.setOper_pagado(mnt_pagado);
                operacionBE.setOper_vuelto(0.0);
                operacionBE.setOper_cobrado(mnt_cobrado);
                operacionBE.setOper_saldo(mnt_saldo);

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                operacionBE.setOper_fecha(sdf.format(jdcFechaOpe.getDate()));

                DaoOperacion daoOperacion = new DaoOperacionImpl();

                int idOpe = daoOperacion.registrarOperacion(operacionBE);

                DetOperacion detOperacionBE = null;
                DaoDetOperacion daoDetOperacion = new DaoDetOperacionImpl();
                List<DetOperacion> list = new ArrayList<DetOperacion>();

                for (int i = 0; i < jtVentas.getRowCount(); i++) {
                    detOperacionBE = new DetOperacion();
                    detOperacionBE.setOper_id(idOpe);
                    detOperacionBE.setUser_id(Integer.parseInt(jtVentas.getModel().getValueAt(i, 5).toString()));
                    detOperacionBE.setServ_id(Integer.parseInt(jtVentas.getModel().getValueAt(i, 1).toString()));
                    detOperacionBE.setProd_id(null);
                    detOperacionBE.setDope_s_p(jtVentas.getModel().getValueAt(i, 2).toString());
                    detOperacionBE.setDope_precio(Double.parseDouble(jtVentas.getModel().getValueAt(i, 7).toString()));
                    detOperacionBE.setDope_cantidad(Integer.parseInt(jtVentas.getModel().getValueAt(i, 8).toString()));
                    detOperacionBE.setDope_subtotal(Double.parseDouble(jtVentas.getModel().getValueAt(i, 9).toString()));
                    detOperacionBE.setDope_descuento(Double.parseDouble(jtVentas.getModel().getValueAt(i, 10).toString()));
                    detOperacionBE.setDope_total(Double.parseDouble(jtVentas.getModel().getValueAt(i, 11).toString()));
                    detOperacionBE.setDope_timestamp(null);
                    message = daoDetOperacion.registrarDetOperacion(detOperacionBE);
                    list.add(detOperacionBE);
                }

                if (message == null && idOpe > 0) {
                    JOptionPane.showMessageDialog(null, "Venta registrada satisfactoriamente.", "En hora buena!", JOptionPane.INFORMATION_MESSAGE);
                    inicializarDatos();
                    //                BoletaUI boletaUI = new BoletaUI(operacionBE, list);
                    //                boletaUI.setVisible(true);
                    //                PrintUI2 printUI = new PrintUI2(operacionBE, list);
                    //                printUI.setVisible(true);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Fatal Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            return;
        }
    }//GEN-LAST:event_jbFinalizarVentaActionPerformed

    private void jrbPagoTotalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrbPagoTotalMouseClicked
        jtfPagoParcial.setEnabled(false);
    }//GEN-LAST:event_jrbPagoTotalMouseClicked

    private void jrbPagoParcialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrbPagoParcialMouseClicked
        jtfPagoParcial.setEnabled(true);
    }//GEN-LAST:event_jrbPagoParcialMouseClicked

    private void jcbCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCategoriasActionPerformed
        Integer id = jcbCategorias.getSelectedIndex();
        jcbServicios.removeAllItems();
        jcbServicios.addItem("Seleccionar un servicio ...");
        if (id > 0) {
            Integer index = Integer.parseInt(obj_cate[id - 1][1].toString());
            listarServicios(index);
            jcbServicios.setEnabled(true);
            jtfPrecio.setText("");
            jtfCantidad.setText("");
            jtfDescuento.setText("");
            jtfTotal.setText("");

            jbLimpiar.setEnabled(true);
        } else if (jcbServicios.isEnabled() == true) {
            jcbServicios.setEnabled(false);
            jtfPrecio.setEnabled(false);
            jtfCantidad.setEnabled(false);
            jtfDescuento.setEnabled(false);
            jbCalcular.setEnabled(false);
            jcbEstilistas.setEnabled(false);

            habilita_Panel_Met_Pago(false);
        }
    }//GEN-LAST:event_jcbCategoriasActionPerformed

    private void jcbServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbServiciosActionPerformed
        Double precio = null;
        Integer id = jcbServicios.getSelectedIndex();
        DaoServicios daoServicios = new DaoServiciosImpl();
        //      Validator combobox

        if (id > 0) {
            Integer index = Integer.parseInt(obj_serv[id - 1][1].toString());
            precio = daoServicios.get_Precio_Servicio(index);

            if (precio == null) {
                jtfPrecio.setText("");
                jtfCantidad.setText("");
            } else {
                jtfPrecio.setText(precio.toString());
                jtfCantidad.setText("1");
                jtfDescuento.setText("0.0");
                jtfTotal.setText("");
            }

            jtfPrecio.setEnabled(true);
            jtfCantidad.setEnabled(true);
            jtfDescuento.setEnabled(true);
            jbCalcular.setEnabled(true);
            jcbEstilistas.setEnabled(true);
        }
    }//GEN-LAST:event_jcbServiciosActionPerformed

    private void jtfCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCantidadKeyTyped
        char key = evt.getKeyChar();
        if (Character.isLetter(key)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingresar solo números.", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jtfCantidadKeyTyped

    private void jtfDescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDescuentoKeyTyped
        char key = evt.getKeyChar();
        if (Character.isLetter(key)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingresar solo números.", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jtfDescuentoKeyTyped

    private void jbAplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAplicarActionPerformed
        jtfDescuento.setEnabled(true);
    }//GEN-LAST:event_jbAplicarActionPerformed

    private void jbCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCalcularActionPerformed
        try {
            Double precio = Double.parseDouble(jtfPrecio.getText());
            Integer cantidad = Integer.parseInt(jtfCantidad.getText());

            Double descuento = Double.parseDouble(jtfDescuento.getText());
            Double subtotal = calculaSubTotal(precio, cantidad, descuento);
            jtfTotal.setText(subtotal.toString());

            jbGuardarVenta.setEnabled(true);
        } catch (NumberFormatException e) {
            if (jtfPrecio.getText() == null || jtfPrecio.getText() == "" || jtfPrecio.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingresar Precio.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            if (jtfCantidad.getText() == null || jtfCantidad.getText() == "" || jtfCantidad.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingresar Cantidad.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbCalcularActionPerformed

    private void jcbEstilistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEstilistasActionPerformed
        Integer id = jcbEstilistas.getSelectedIndex();
        if (id > 0) {
            Integer index = Integer.parseInt(obj_estl[id - 1][1].toString());
        }
    }//GEN-LAST:event_jcbEstilistasActionPerformed

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
            java.util.logging.Logger.getLogger(VentasUI_v2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentasUI_v2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentasUI_v2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentasUI_v2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentasUI_v2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAgregarServicio;
    private javax.swing.JButton jbAplicar;
    private javax.swing.JButton jbCalcular;
    private javax.swing.JButton jbCancelarVenta;
    private javax.swing.JButton jbFinalizarVenta;
    private javax.swing.JButton jbGuardarVenta;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JButton jbNuevaVenta;
    private javax.swing.JButton jbPagar;
    private javax.swing.JComboBox<String> jcbCategorias;
    private javax.swing.JComboBox<String> jcbEstilistas;
    private javax.swing.JComboBox<String> jcbServicios;
    private javax.swing.JCheckBox jchkbConTarjeta;
    private javax.swing.JCheckBox jchkbEfectivo;
    private javax.swing.JCheckBox jchkbPlin;
    private javax.swing.JCheckBox jchkbTransferencia;
    private javax.swing.JCheckBox jchkbYape;
    private com.toedter.calendar.JDateChooser jdcFechaOpe;
    private javax.swing.JLabel jlTotalVenta;
    private javax.swing.JRadioButton jrbPagoParcial;
    private javax.swing.JRadioButton jrbPagoTotal;
    private javax.swing.JTable jtVentas;
    private javax.swing.JTextField jtfCantidad;
    private javax.swing.JTextField jtfDescuento;
    private javax.swing.JTextField jtfPagoParcial;
    private javax.swing.JTextField jtfPagoTotal;
    private javax.swing.JTextField jtfPrecio;
    private javax.swing.JTextField jtfTotal;
    // End of variables declaration//GEN-END:variables

    public void limpiarDatos() {
        jcbCategorias.setSelectedIndex(0);
        jcbServicios.setSelectedIndex(0);
        jtfPrecio.setText("");
        jtfCantidad.setText("");
        jtfDescuento.setText("");
        jtfTotal.setText("");
        buttonGroup1.clearSelection();
        jcbEstilistas.setSelectedIndex(0);
        buttonGroup2.clearSelection();
        jtfPagoTotal.setText("");
        jtfPagoParcial.setText("");
    }

    public void habilita_Panel_Met_Pago(boolean estado) {
        jchkbEfectivo.setEnabled(estado);
        jchkbConTarjeta.setEnabled(estado);
        jchkbTransferencia.setEnabled(estado);
        jchkbYape.setEnabled(estado);
        jchkbPlin.setEnabled(estado);
    }

    public void habilita_Panel_Dat_Operacion(boolean estado) {
        jcbCategorias.setEnabled(estado);
        jcbServicios.setEnabled(estado);
        jtfPrecio.setEnabled(estado);
        jtfCantidad.setEnabled(estado);
        jtfDescuento.setEnabled(estado);
        jtfTotal.setEnabled(estado);
//        jbAplicar.setEnabled(estado);
        jbCalcular.setEnabled(estado);
        jcbEstilistas.setEnabled(estado);
    }

    public void habilita_Panel_Pago(boolean estado) {
        jdcFechaOpe.setEnabled(estado);
        jrbPagoTotal.setEnabled(estado);
        jrbPagoParcial.setEnabled(estado);
        jtfPagoTotal.setEnabled(estado);
        jtfPagoParcial.setEnabled(estado);
    }
}
