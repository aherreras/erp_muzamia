/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package erp_muzamia.ui;

import erp_muzamia.dao.DaoCategorias;
import erp_muzamia.dao.DaoClientes;
import erp_muzamia.dao.DaoDetOperacion;
import erp_muzamia.dao.DaoOperacion;
import erp_muzamia.dao.DaoServicios;
import erp_muzamia.dao.DaoUsuarios;
import erp_muzamia.dao.impl.DaoCategoriasImpl;
import erp_muzamia.dao.impl.DaoClientesImpl;
import erp_muzamia.dao.impl.DaoDetOperacionImpl;
import erp_muzamia.dao.impl.DaoOperacionImpl;
import erp_muzamia.dao.impl.DaoServiciosImpl;
import erp_muzamia.dao.impl.DaoUsuariosImpl;
import erp_muzamia.dto.Categorias;
import erp_muzamia.dto.Clientes;
import erp_muzamia.dto.DetOperacion;
import erp_muzamia.dto.Operacion;
import erp_muzamia.dto.Servicios;
import erp_muzamia.dto.Usuarios;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class VentasUI extends javax.swing.JFrame {

    /**
     * Creates new form VentasUI2
     */
    public VentasUI() {
        initComponents();
        listarColumnasTabla();
        listarCategorias();
        listarEstilistas();

        Date date = new Date();
        jdcFechaOpe.setDate(date);

        inicializarDatos();
    }

    public VentasUI(int idVenta) {
        initComponents();
        listarColumnasTabla();
        listarCategorias();
        listarEstilistas();
        inicializarDatos();
        cargarDatos(idVenta);
    }

    Integer accion = 0;
    Integer row = 0;
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

        habilita_Panel_Dat_Cliente(false);
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

    public void cargarDatos(int idVenta) {
        DaoOperacion daoOperacion = new DaoOperacionImpl();
        Object[] obj = daoOperacion.get_Operacion_2(idVenta);

        int met_pag = Integer.parseInt(obj[0].toString());

        switch (met_pag) {
            case 1:
                jchkbEfectivo.setSelected(true);
                break;
            case 2:
                jchkbConTarjeta.setSelected(true);
                break;
            case 3:
                jchkbTransferencia.setSelected(true);
                break;
            case 4:
                jchkbYape.setSelected(true);
                break;
            case 5:
                jchkbPlin.setSelected(true);
                break;
            default:
                buttonGroup1.clearSelection();
                break;
        }

        jtfClieID.setText(obj[1].toString());
        jtfNomClie.setText(obj[2].toString());
        jtfApeClie.setText(obj[3].toString());
        jtfDNI.setText(obj[4].toString());

        if (obj[5] == obj[6]) {
            jrbPagoTotal.setSelected(true);
            jtfPagoTotal.setText(obj[5].toString());
        } else {
            jrbPagoParcial.setSelected(true);
            jtfPagoParcial.setText(obj[6].toString());
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(obj[7].toString());
            jdcFechaOpe.setDate(date);
        } catch (Exception e) {

        }

        DaoDetOperacion daoDetOperacion = new DaoDetOperacionImpl();
        List<Object[]> list = daoDetOperacion.get_DetOperacion_2(idVenta);
        DefaultTableModel model = (DefaultTableModel) jtVentas.getModel();
        model.setRowCount(0);

        for (Object[] row : list) {
            model.addRow(row);
        }
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

    public void updDetalle(int row) {
        int ids = jcbServicios.getSelectedIndex() - 1;
        int idc = jcbCategorias.getSelectedIndex() - 1;
        int ide = jcbEstilistas.getSelectedIndex() - 1;

        jtVentas.getModel().setValueAt(Integer.parseInt(obj_serv[ids][1].toString()), row, 1);
        jtVentas.getModel().setValueAt(jcbServicios.getSelectedItem().toString(), row, 2);
        jtVentas.getModel().setValueAt(Integer.parseInt(obj_cate[idc][1].toString()), row, 3);
        jtVentas.getModel().setValueAt(jcbCategorias.getSelectedItem().toString(), row, 4);
        jtVentas.getModel().setValueAt(Integer.parseInt(obj_estl[ide][1].toString()), row, 5);
        jtVentas.getModel().setValueAt(jcbEstilistas.getSelectedItem().toString(), row, 6);

        Double precio = Double.parseDouble(jtfPrecio.getText());
        Integer cantidad = Integer.parseInt(jtfCantidad.getText());

        jtVentas.getModel().setValueAt(precio, row, 7);
        jtVentas.getModel().setValueAt(cantidad, row, 8);

        Double subTotal = precio * cantidad;

        jtVentas.getModel().setValueAt(subTotal, row, 9);
        jtVentas.getModel().setValueAt(jtfDescuento.getText(), row, 10);
        jtVentas.getModel().setValueAt(jtfTotal.getText(), row, 11);

        Double total = 0.0;
        for (int i = 0; i < jtVentas.getRowCount(); i++) {
            total += Double.parseDouble(jtVentas.getModel().getValueAt(i, 11).toString());
        }
        totalVenta = total;

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
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jtfNomClie = new javax.swing.JTextField();
        jbSearch = new javax.swing.JButton();
        jbAdd = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jtfDNI = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jtfClieID = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jtfApeClie = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jdcFechaOpe = new com.toedter.calendar.JDateChooser();
        jrbPagoTotal = new javax.swing.JRadioButton();
        jtfPagoTotal = new javax.swing.JTextField();
        jtfPagoParcial = new javax.swing.JTextField();
        jrbPagoParcial = new javax.swing.JRadioButton();

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
                .addGap(13, 13, 13)
                .addComponent(jbNuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jbLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jbGuardarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jbAgregarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jbPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jbFinalizarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jbCancelarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 255));
        jLabel15.setText("VENTA TOTAL:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Operación"));

        jLabel1.setText("Servicio:");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Categoría:");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtfCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCantidadKeyTyped(evt);
            }
        });

        jLabel13.setText("Cant.");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("S/.");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Descuento:");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtfDescuento.setMinimumSize(new java.awt.Dimension(63, 22));
        jtfDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfDescuentoKeyTyped(evt);
            }
        });

        jLabel6.setText("S/.");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setText("Total:");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setText("S/.");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtfTotal.setBackground(new java.awt.Color(51, 51, 255));

        jbCalcular.setText("Calcular");
        jbCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCalcularActionPerformed(evt);
            }
        });

        jLabel10.setText("Estilista:");
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jcbEstilistas, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jtfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbCalcular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtfDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jcbCategorias, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jcbServicios, 0, 251, Short.MAX_VALUE)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(5, 5, 5)
                                    .addComponent(jtfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jtfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbCategorias))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbServicios))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbCalcular, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jcbEstilistas)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jtVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nro. Item", "id_Servicio", "Servicio", "id_Categoria", "Categoria", "id_Estilista", "Estilista", "Precio", "Cant.", "Sub Total", "Dscto.", "Total"
            }
        ));
        jtVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtVentasMouseClicked(evt);
            }
        });
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
        jchkbEfectivo.setBorderPainted(true);

        jchkbConTarjeta.setBackground(new java.awt.Color(204, 204, 255));
        buttonGroup1.add(jchkbConTarjeta);
        jchkbConTarjeta.setText("Con tarjeta");
        jchkbConTarjeta.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jchkbConTarjeta.setBorderPainted(true);

        jchkbPlin.setBackground(new java.awt.Color(204, 204, 255));
        buttonGroup1.add(jchkbPlin);
        jchkbPlin.setText("Plin / IzipayYa");
        jchkbPlin.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jchkbPlin.setBorderPainted(true);

        jchkbYape.setBackground(new java.awt.Color(204, 204, 255));
        buttonGroup1.add(jchkbYape);
        jchkbYape.setText("Yape");
        jchkbYape.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jchkbYape.setBorderPainted(true);

        jchkbTransferencia.setBackground(new java.awt.Color(204, 204, 255));
        buttonGroup1.add(jchkbTransferencia);
        jchkbTransferencia.setText("Transferencia");
        jchkbTransferencia.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jchkbTransferencia.setBorderPainted(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jchkbYape, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jchkbTransferencia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jchkbConTarjeta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jchkbEfectivo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jchkbPlin, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jchkbEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jchkbConTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jchkbTransferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jchkbYape, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jchkbPlin, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Cliente"));

        jLabel11.setText("Nombres:");
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbSearch.setBackground(new java.awt.Color(204, 204, 255));
        jbSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp_muzamia/ui/imgs/icons8-find-48.png"))); // NOI18N
        jbSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSearchActionPerformed(evt);
            }
        });

        jbAdd.setBackground(new java.awt.Color(204, 255, 204));
        jbAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp_muzamia/ui/imgs/icons8-join-48.png"))); // NOI18N
        jbAdd.setEnabled(false);
        jbAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddActionPerformed(evt);
            }
        });

        jLabel12.setText("Doc. Identidad:");
        jLabel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtfDNI.setEnabled(false);

        jLabel14.setText("Nro. Cliente:");
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtfClieID.setEnabled(false);

        jLabel16.setText("Apellidos:");
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtfApeClie.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfApeClie))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfNomClie, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfClieID, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfNomClie, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfApeClie, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfClieID, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(5, 5, 5))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Operación"));

        jLabel9.setText("Fecha Oper:");
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jdcFechaOpe.setDateFormatString("yyyy-MM-dd");
        jdcFechaOpe.setMinimumSize(new java.awt.Dimension(120, 22));
        jdcFechaOpe.setPreferredSize(new java.awt.Dimension(120, 22));

        buttonGroup2.add(jrbPagoTotal);
        jrbPagoTotal.setText("Pago Total");
        jrbPagoTotal.setBorderPainted(true);
        jrbPagoTotal.setPreferredSize(new java.awt.Dimension(91, 25));
        jrbPagoTotal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrbPagoTotalMouseClicked(evt);
            }
        });

        buttonGroup2.add(jrbPagoParcial);
        jrbPagoParcial.setText("Pago Parcial");
        jrbPagoParcial.setBorderPainted(true);
        jrbPagoParcial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrbPagoParcialMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jrbPagoParcial)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdcFechaOpe, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jrbPagoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfPagoTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                    .addComponent(jtfPagoParcial))
                .addGap(15, 15, 15))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jrbPagoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfPagoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jdcFechaOpe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jrbPagoParcial, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jtfPagoParcial))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(32, 32, 32)
                .addComponent(jlTotalVenta)
                .addGap(53, 53, 53))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(5, 5, 5)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
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
        accion = 0;
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

        boolean calculado = false;
        Double precio = Double.parseDouble(jtfPrecio.getText());
        Integer cantidad = Integer.parseInt(jtfCantidad.getText());
        Double descuento = Double.parseDouble(jtfDescuento.getText());

        String auxTot = "" + calculaSubTotal(precio, cantidad, descuento);
        String auxTot2 = "" + jtfTotal.getText();

        if (!auxTot.equalsIgnoreCase(auxTot2)) {
            if (message == null) {
                message = "Validación de campos:\n";
            }
            message += "\n* El costo del servicio/producto calculado es menor al importe total del servicio/producto.";
            message += "\n   - Costo del servicio/producto calculado = " + auxTot;
            message += "\n   - Importe total del servicio/producto = " + auxTot2;
            message += "\n  Hacer clic en el botón 'Calcular' para poder 'Guardar'.";
        }

        if (jcbCategorias.getSelectedIndex() == 0) {
            if (message == null) {
                message = "Validación de campos:\n";
            }
            message += "\n* Seleccionar Categoría.";
        }

        if (jcbServicios.getSelectedIndex() == 0) {
            if (message == null) {
                message = "Validación de campos:\n";
            }
            message += "\n* Seleccionar Servicio.";
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
        }

        if (accion == 0) {
            addDetalle();
        } else if (accion == 1) {
            updDetalle(row);
        }

        habilita_Panel_Dat_Operacion(false);
        habilita_Panel_Met_Pago(false);
        habilita_Panel_Pago(false);

        jbLimpiar.setEnabled(false);
        jbGuardarVenta.setEnabled(false);
        jbAgregarServicio.setEnabled(true);
        jbPagar.setEnabled(true);
        jbCancelarVenta.setEnabled(true);
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
        accion = 0;

        inicializarDatos();

        jtfNomClie.setEnabled(true);
        jbSearch.setEnabled(true);
        jcbCategorias.setEnabled(true);

        jbNuevaVenta.setEnabled(false);
        jbLimpiar.setEnabled(true);
        jbCancelarVenta.setEnabled(true);
    }//GEN-LAST:event_jbNuevaVentaActionPerformed

    private void jbFinalizarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFinalizarVentaActionPerformed
        String message = null;
        double mnt_pagado = 0.0;
        double mnt_cobrado = 0.0;
        double mnt_saldo = 0.0;
        int clieID = 0;

        if (jtfClieID.getText().isBlank() || jtfClieID.getText().isEmpty()) {
            if (message == null) {
                message = "Validación de campos:\n";
            }
            message += "\n* Ingresar cliente.";
        } else {
            clieID = Integer.parseInt(jtfClieID.getText());
        }

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
                operacionBE.setClie_id(clieID);
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

    private void jbSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSearchActionPerformed
        DaoClientes daoClientes = new DaoClientesImpl();
        Clientes clientes = new Clientes();

//        List<Clientes> list = daoClientes.getClientePorNombre("%" + jtfNomClie.getText() + "%");
        List<Clientes> list = daoClientes.lstClientes_2();

        if (list.size() < 0) {
            return;
        } else if (list.size() == 0) {
            JOptionPane.showMessageDialog(null, "No se encontraron clientes.", "CLIENTES ENCONTRADOS", JOptionPane.INFORMATION_MESSAGE);
        } else {
            showClientes(list);
        }
    }//GEN-LAST:event_jbSearchActionPerformed

    private void jtVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtVentasMouseClicked
        accion = 1;
        row = jtVentas.getSelectedRow();

        Integer idCate = Integer.parseInt(jtVentas.getValueAt(row, 3).toString());
        Integer index = 0;

        for (int i = 0; i < obj_cate.length; i++) {
            index = Integer.parseInt(obj_cate[i][1].toString());
            if (index == idCate) {
                jcbCategorias.setSelectedIndex(i + 1);
            }
        }

        Integer idServ = Integer.parseInt(jtVentas.getValueAt(row, 1).toString());

        for (int i = 0; i < obj_serv.length; i++) {
            index = Integer.parseInt(obj_serv[i][1].toString());
            if (index == idServ) {
                jcbServicios.setSelectedIndex(i + 1);
            }
        }

        jtfPrecio.setText(jtVentas.getValueAt(row, 7).toString());
        jtfCantidad.setText(jtVentas.getValueAt(row, 8).toString());
        jtfDescuento.setText(jtVentas.getValueAt(row, 10).toString());
        jtfTotal.setText(jtVentas.getValueAt(row, 11).toString());

        Integer idEstl = Integer.parseInt(jtVentas.getValueAt(row, 5).toString());

        for (int i = 0; i < obj_estl.length; i++) {
            index = Integer.parseInt(obj_estl[i][1].toString());
            if (index == idEstl) {
                jcbEstilistas.setSelectedIndex(i + 1);
            }
        }

        jcbCategorias.setEnabled(true);
        jcbServicios.setEnabled(true);
        jtfPrecio.setEnabled(true);
        jtfCantidad.setEnabled(true);
        jtfDescuento.setEnabled(true);
        jbCalcular.setEnabled(true);
        jcbEstilistas.setEnabled(true);

        //Botones laterales
        jbLimpiar.setEnabled(true);
        jbGuardarVenta.setEnabled(true);
        jbAgregarServicio.setEnabled(false);
    }//GEN-LAST:event_jtVentasMouseClicked

    private void jbAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddActionPerformed
        addClientes();
    }//GEN-LAST:event_jbAddActionPerformed

    public void showClientes(List<Clientes> list) {
        JDialog jDialog = new javax.swing.JDialog();
        jDialog.setAlwaysOnTop(true);
        jDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialog.setLocationRelativeTo(null);

        Object[] columnNames = {"ID", "Nombres", "Apellidos", "DNI", "Estado"};
        Object[][] data = new Object[list.size()][5];

        int i = 0;
        for (Clientes cl : list) {
            data[i][0] = cl.getClie_id();
            data[i][1] = cl.getClie_nombres();
            data[i][2] = cl.getClie_apellidos();
            data[i][3] = cl.getClie_dni();
            data[i][4] = cl.getClie_estado();
            i++;
        }

        JTable table = new javax.swing.JTable(data, columnNames);
        table.setRowHeight(40);

        table.getColumnModel().getColumn(0).setMaxWidth(60);
        table.getColumnModel().getColumn(0).setMinWidth(60);
        table.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(60);
        table.getTableHeader().getColumnModel().getColumn(0).setMinWidth(60);

        table.getColumnModel().getColumn(1).setMaxWidth(145);
        table.getColumnModel().getColumn(1).setMinWidth(145);
        table.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(145);
        table.getTableHeader().getColumnModel().getColumn(1).setMinWidth(145);

        table.getColumnModel().getColumn(2).setMaxWidth(145);
        table.getColumnModel().getColumn(2).setMinWidth(145);
        table.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(145);
        table.getTableHeader().getColumnModel().getColumn(2).setMinWidth(145);

        table.getColumnModel().getColumn(3).setMaxWidth(70);
        table.getColumnModel().getColumn(3).setMinWidth(70);
        table.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(70);
        table.getTableHeader().getColumnModel().getColumn(3).setMinWidth(70);

        table.getColumnModel().getColumn(4).setMaxWidth(80);
        table.getColumnModel().getColumn(4).setMinWidth(80);
        table.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(80);
        table.getTableHeader().getColumnModel().getColumn(4).setMinWidth(80);

        int height = 0;
        if (list.size() <= 10) {
            height = list.size() * 40;
        } else {
            height = 10 * 40;
        }
        JScrollPane tableScrollPane = new javax.swing.JScrollPane(table);
        tableScrollPane.setPreferredSize(new java.awt.Dimension(400, height + 30));

        JPanel panel = new javax.swing.JPanel();
        panel.setPreferredSize(new java.awt.Dimension(500, height + 30));
        panel.setLayout(new java.awt.BorderLayout());
        panel.add(tableScrollPane, java.awt.BorderLayout.NORTH);

        JOptionPane.showMessageDialog(jDialog, panel, "CLIENTES ENCONTRADOS", javax.swing.JOptionPane.PLAIN_MESSAGE);

        int row = table.getSelectedRow();

        if (row < 0) {
            return;
        }

        jtfNomClie.setText(table.getModel().getValueAt(row, 1).toString());
        jtfApeClie.setText(table.getModel().getValueAt(row, 2).toString());
        jtfDNI.setText(table.getModel().getValueAt(row, 3).toString());
        jtfClieID.setText(table.getModel().getValueAt(row, 0).toString());
    }

    public void addClientes() {
        JDialog jDialog = new javax.swing.JDialog();
        jDialog.setAlwaysOnTop(true);
        jDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialog.setLocationRelativeTo(null);

        JLabel jlID = new JLabel();
        jlID.setBounds(5, 5, 27, 131);
        jlID.setText("ID:");

        JTextField jtfID = new JTextField();
        jtfID.setBounds(141, 37, 27, 151);
        jtfID.setText("");

        JTextField jtfNom;
        JTextField jtfApe;
        JTextField jtfDNI;
        JComboBox jcbEst;

        JPanel panel = new javax.swing.JPanel();
        panel.setPreferredSize(new java.awt.Dimension(500, 200));
        panel.setLayout(new java.awt.BorderLayout());
        panel.add(jlID);
        panel.add(jtfID);

        JOptionPane.showMessageDialog(jDialog, panel, "NUEVO CLIENTE", javax.swing.JOptionPane.PLAIN_MESSAGE);
    }

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
            java.util.logging.Logger.getLogger(VentasUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentasUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentasUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentasUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentasUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAdd;
    private javax.swing.JButton jbAgregarServicio;
    private javax.swing.JButton jbCalcular;
    private javax.swing.JButton jbCancelarVenta;
    private javax.swing.JButton jbFinalizarVenta;
    private javax.swing.JButton jbGuardarVenta;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JButton jbNuevaVenta;
    private javax.swing.JButton jbPagar;
    private javax.swing.JButton jbSearch;
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
    private javax.swing.JTextField jtfApeClie;
    private javax.swing.JTextField jtfCantidad;
    private javax.swing.JTextField jtfClieID;
    private javax.swing.JTextField jtfDNI;
    private javax.swing.JTextField jtfDescuento;
    private javax.swing.JTextField jtfNomClie;
    private javax.swing.JTextField jtfPagoParcial;
    private javax.swing.JTextField jtfPagoTotal;
    private javax.swing.JTextField jtfPrecio;
    private javax.swing.JTextField jtfTotal;
    // End of variables declaration//GEN-END:variables

    public void limpiarDatos() {
        // Datos Cliente
        jtfNomClie.setText("");
        jtfApeClie.setText("");
        jtfDNI.setText("");
        jtfClieID.setText("");

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

    public void habilita_Panel_Dat_Cliente(boolean estado) {
        jtfNomClie.setEnabled(estado);
        jbSearch.setEnabled(estado);
//        jbAdd.setEnabled(estado);
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
