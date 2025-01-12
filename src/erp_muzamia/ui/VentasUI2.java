/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package erp_muzamia.ui;

import erp_muzamia.dao.DaoClientes;
import erp_muzamia.dao.DaoOperacion;
import erp_muzamia.dao.DaoPeriodos;
import erp_muzamia.dao.DaoProductos;
import erp_muzamia.dao.DaoServicios;
import erp_muzamia.dao.DaoUsuarios;
import erp_muzamia.dao.impl.DaoClientesImpl;
import erp_muzamia.dao.impl.DaoDetalleOperacionImpl;
import erp_muzamia.dao.impl.DaoOperacionImpl;
import erp_muzamia.dao.impl.DaoPeriodosImpl;
import erp_muzamia.dao.impl.DaoProductosImpl;
import erp_muzamia.dao.impl.DaoServiciosImpl;
import erp_muzamia.dao.impl.DaoUsuariosImpl;
import erp_muzamia.dto.Clientes;
import erp_muzamia.dto.DetalleOperacion;
import erp_muzamia.dto.Operaciones;
import erp_muzamia.dto.Periodos;
import erp_muzamia.dto.Productos;
import erp_muzamia.dto.Servicios;
import erp_muzamia.dto.Usuarios;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import erp_muzamia.dao.DaoDetalleOperacion;

/**
 *
 * @author User
 */
public class VentasUI2 extends javax.swing.JInternalFrame {

    /**
     * Creates new form VentasUI_Iframe
     */
    public VentasUI2() {
        initComponents();
        listarColumnasTabla();
        listarEstilistas();
        listarPeriodos();

        Date date = new Date();
        jdcFechaOpe.setDate(date);

        inicializarDatos();

// Botones laterales
        jbNuevaVenta.setEnabled(true);
        jbLimpiar.setEnabled(false);
        jbGuardarVenta.setEnabled(false);
        jbAgregarServicio.setEnabled(false);
        jbPagar.setEnabled(false);
        jbFinalizarVenta.setEnabled(false);
        jbComprobante.setEnabled(false);
        jbCancelarVenta.setEnabled(false);

        jbFndProducto.setEnabled(false);
        jbFndServicio.setEnabled(false);
    }

    Integer accion;
    Integer row;
    Object[][] obj_estl;
    Object[][] obj_peri;
    Double subTotalVenta;
    Double descuentoVenta;
    Double totalVenta;
    int forma_pago_id;
    int vnta;

    Clientes clientesBE;
    Servicios serviciosBE;
    Productos productosBE;
    ArrayList<DetalleOperacion>[] listDetOpe;

    public static String nom = "";

    public void inicializarDatos() {
        limpiar_Datos();

        habilita_Panel_Datos_Cliente(false);
        habilita_Panel_Venta(false);
        habilita_Panel_Datos_Venta(false);
        habilita_Panel_Formas_Pago(false);
        habilita_Panel_Pag(false);

        jbNuevaVenta.setEnabled(true);
        jbLimpiar.setEnabled(false);
        jbGuardarVenta.setEnabled(false);
        jbAgregarServicio.setEnabled(false);
        jbPagar.setEnabled(false);
        jbFinalizarVenta.setEnabled(false);
        jbComprobante.setEnabled(false);
        jbCancelarVenta.setEnabled(false);

        DefaultTableModel model = (DefaultTableModel) jtVentas.getModel();
        model.setRowCount(0);
        clientesBE = null;
        serviciosBE = null;
        productosBE = null;

        vnta = 0;
        forma_pago_id = 0;
        accion = 0;
        row = 0;

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

    public void listarEstilistas() {
        DaoUsuarios daoUsuarios = new DaoUsuariosImpl();
        List<Usuarios> list = daoUsuarios.lst_Usuarios_2_1();
        obj_estl = new Integer[list.size()][2];
        String nombre = "";

        for (int i = 0; i < list.size(); i++) {
            nombre = list.get(i).getUser_nombres() + " " + list.get(i).getUser_apellidos();
            jcbEstilistas.addItem(nombre);
            obj_estl[i][0] = i;
            obj_estl[i][1] = list.get(i).getUser_id();
        };
    }

    public void listarPeriodos() {
        DaoPeriodos daoPeriodos = new DaoPeriodosImpl();
        List<Periodos> list = daoPeriodos.lst_Periodos_2();
        obj_peri = new Integer[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            jcbPeriodo.addItem(list.get(i).getPeri_descripcion());
            obj_peri[i][0] = i;
            obj_peri[i][1] = list.get(i).getPeri_id();
        };
    }

    public Double calculaSubTotal(Double precio, Integer cantidad, Double descuento) {
        Double subTotal = null;
        subTotal = (precio * cantidad) - descuento;
        return subTotal;
    }

    public void addDetalle(int sw_tipo) {
        Double precio = 0.0;
        Integer cantidad = 0;
        Double subTotal = 0.0;
        Double descuento = 0.0;
        Double total = 0.0;
        DefaultTableModel model = (DefaultTableModel) jtVentas.getModel();

        Object[] row = new Object[12];

        row[0] = model.getRowCount() + 1;

        if (sw_tipo == 0) {
            row[1] = serviciosBE.getServ_id();
            row[2] = serviciosBE.getServ_nombre();
            row[3] = null;
            row[4] = null;
            int id = jcbEstilistas.getSelectedIndex() - 1;
            row[5] = Integer.parseInt(obj_estl[id][1].toString());
            row[6] = jcbEstilistas.getSelectedItem().toString();
        } else {
            row[1] = null;
            row[2] = null;
            row[3] = productosBE.getProd_id();
            row[4] = productosBE.getProd_nombre();
            row[5] = null;
            row[6] = null;
        }

        precio = Double.parseDouble(jtfPrecioVenta.getText());
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
        int ide = jcbEstilistas.getSelectedIndex() - 1;

        jtVentas.getModel().setValueAt(serviciosBE.getServ_id(), row, 1);
        jtVentas.getModel().setValueAt(serviciosBE.getServ_nombre(), row, 2);
        jtVentas.getModel().setValueAt(Integer.parseInt(obj_estl[ide][1].toString()), row, 5);
        jtVentas.getModel().setValueAt(jcbEstilistas.getSelectedItem().toString(), row, 6);

        Double precio = Double.parseDouble(jtfPrecioVenta.getText());
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

    public void lstClientes(List<Clientes> list) {
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
            data[i][4] = cl.isClie_estado();
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

        JOptionPane.showMessageDialog(jDialog, panel, "LISTADO DE CLIENTES", javax.swing.JOptionPane.PLAIN_MESSAGE);

        int row = table.getSelectedRow();

        if (row < 0) {
            return;
        }

        clientesBE = new Clientes();
        clientesBE.setClie_id(Integer.parseInt(table.getModel().getValueAt(row, 0).toString()));
        clientesBE.setClie_nombres(table.getModel().getValueAt(row, 1).toString());
        clientesBE.setClie_apellidos(table.getModel().getValueAt(row, 2).toString());
        clientesBE.setClie_dni(Integer.parseInt(table.getModel().getValueAt(row, 3).toString()));

        jtfNomClie.setEnabled(true);
        jtfNomClie.setText(clientesBE.getClie_nombres());
        jtfApeClie.setEnabled(true);
        jtfApeClie.setText(clientesBE.getClie_apellidos());
        jtfDNI.setEnabled(true);
        jtfDNI.setText("" + clientesBE.getClie_dni());
        jtfClieID.setEnabled(true);
        jtfClieID.setText("" + clientesBE.getClie_id());
    }

    public void lstServicios(List<Servicios> list) {
        JDialog jDialog = new javax.swing.JDialog();
        jDialog.setAlwaysOnTop(true);
        jDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialog.setLocationRelativeTo(null);

        Object[] columnNames = {"ID", "Nombre", "Descripcion", "Precio (S/.)", "cate_id"};
        Object[][] data = new Object[list.size()][6];

        int i = 0;
        for (Servicios sv : list) {
            data[i][0] = sv.getServ_id();
            data[i][1] = sv.getServ_nombre();
            data[i][2] = sv.getServ_descripcion();
            data[i][3] = sv.getServ_precio();
            data[i][4] = sv.getCate_id();
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

        table.getColumnModel().getColumn(3).setMaxWidth(100);
        table.getColumnModel().getColumn(3).setMinWidth(100);
        table.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(100);
        table.getTableHeader().getColumnModel().getColumn(3).setMinWidth(100);

        table.getColumnModel().getColumn(4).setMaxWidth(0);
        table.getColumnModel().getColumn(4).setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(4).setMinWidth(0);

        int height = 0;
        if (list.size() <= 10) {
            height = list.size() * 40;
        } else {
            height = 10 * 40;
        }
        JScrollPane tableScrollPane = new javax.swing.JScrollPane(table);
        tableScrollPane.setPreferredSize(new java.awt.Dimension(350, height + 30));

        JPanel panel = new javax.swing.JPanel();
        panel.setPreferredSize(new java.awt.Dimension(450, height + 30));
        panel.setLayout(new java.awt.BorderLayout());
        panel.add(tableScrollPane, java.awt.BorderLayout.NORTH);

        JOptionPane.showMessageDialog(jDialog, panel, "LISTADO DE SERVICIOS", javax.swing.JOptionPane.PLAIN_MESSAGE);

        int row = table.getSelectedRow();

        if (row < 0) {
            return;
        }

        serviciosBE = new Servicios();
        serviciosBE.setServ_id(Integer.parseInt(table.getModel().getValueAt(row, 0).toString()));
        serviciosBE.setServ_nombre(table.getModel().getValueAt(row, 1).toString());
        serviciosBE.setServ_descripcion(table.getModel().getValueAt(row, 2).toString());
        serviciosBE.setServ_precio(Double.parseDouble(table.getModel().getValueAt(row, 3).toString()));
        serviciosBE.setCate_id(Integer.parseInt(table.getModel().getValueAt(row, 4).toString()));

        jtfServicio.setText(serviciosBE.getServ_nombre());
        jtfPrecioPizarraServ.setText("" + serviciosBE.getServ_precio());
        jtfPrecioVenta.setText("");
        jtfCantidad.setText("");
        jtfDescuento.setText("");
        jtfTotal.setText("");

        habilita_Panel_Datos_Venta(true);
        jtfServicio.setEnabled(true);
        jtfPrecioPizarraServ.setEnabled(true);
        jbGuardarVenta.setEnabled(true);
    }

    public void lstProductos(List<Productos> list) {
        JDialog jDialog = new javax.swing.JDialog();
        jDialog.setAlwaysOnTop(true);
        jDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialog.setLocationRelativeTo(null);

        Object[] columnNames = {"ID", "Nombre", "Descripcion", "Costo (S/.)", "cpro_id"};
        Object[][] data = new Object[list.size()][6];

        int i = 0;
        for (Productos pr : list) {
            data[i][0] = pr.getProd_id();
            data[i][1] = pr.getProd_nombre();
            data[i][2] = pr.getProd_descripcion();
            data[i][3] = pr.getProd_precio();
            data[i][4] = pr.getCpro_id();
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

        table.getColumnModel().getColumn(3).setMaxWidth(100);
        table.getColumnModel().getColumn(3).setMinWidth(100);
        table.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(100);
        table.getTableHeader().getColumnModel().getColumn(3).setMinWidth(100);

        table.getColumnModel().getColumn(4).setMaxWidth(0);
        table.getColumnModel().getColumn(4).setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(4).setMinWidth(0);

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

        JOptionPane.showMessageDialog(jDialog, panel, "LISTADO DE PRODUCTOS", javax.swing.JOptionPane.PLAIN_MESSAGE);

        int row = table.getSelectedRow();

        if (row < 0) {
            return;
        }

        productosBE = new Productos();
        productosBE.setProd_id(Integer.parseInt(table.getModel().getValueAt(row, 0).toString()));
        productosBE.setProd_nombre(table.getModel().getValueAt(row, 1).toString());
        productosBE.setProd_descripcion(table.getModel().getValueAt(row, 2).toString());
        productosBE.setProd_precio(Double.parseDouble(table.getModel().getValueAt(row, 3).toString()));
        productosBE.setCpro_id(Integer.parseInt(table.getModel().getValueAt(row, 4).toString()));

        jtfProducto.setText(productosBE.getProd_nombre());
        jtfPrecioCostoProd.setText("" + productosBE.getProd_precio());

        habilita_Panel_Datos_Venta(true);
        jtfProducto.setEnabled(true);
        jtfPrecioCostoProd.setEnabled(true);
        jbGuardarVenta.setEnabled(true);
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
        jtfID.setBounds(141, 5, 27, 151);
        jtfID.setText("testing nuevo cliente");

        JTextField jtfNom;
        JTextField jtfApe;
        JTextField jtfDNI;
        JComboBox jcbEst;

        JPanel panel = new javax.swing.JPanel();
        panel.setPreferredSize(new java.awt.Dimension(500, 100));
        panel.setLayout(new java.awt.BorderLayout());
        panel.add(jlID);
        panel.add(jtfID);

        JOptionPane.showMessageDialog(jDialog, panel, "NUEVO CLIENTE", javax.swing.JOptionPane.PLAIN_MESSAGE);
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
        buttonGroup3 = new javax.swing.ButtonGroup();
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
        jLabel17 = new javax.swing.JLabel();
        jcbPeriodo = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtVentas = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jlTotalVenta = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfPrecioPizarraServ = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jtfServicio = new javax.swing.JTextField();
        jbFndServicio = new javax.swing.JButton();
        jtfProducto = new javax.swing.JTextField();
        jbFndProducto = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jtfPrecioCostoProd = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jrbProducto = new javax.swing.JRadioButton();
        jrbServicio = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jchkbEfectivo = new javax.swing.JCheckBox();
        jchkbConTarjeta = new javax.swing.JCheckBox();
        jchkbPlin = new javax.swing.JCheckBox();
        jchkbYape = new javax.swing.JCheckBox();
        jchkbTransferencia = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jbAgregarServicio = new javax.swing.JButton();
        jbPagar = new javax.swing.JButton();
        jbGuardarVenta = new javax.swing.JButton();
        jbCancelarVenta = new javax.swing.JButton();
        jbLimpiar = new javax.swing.JButton();
        jbNuevaVenta = new javax.swing.JButton();
        jbFinalizarVenta = new javax.swing.JButton();
        jbComprobante = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jtfDescuento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfTotal = new javax.swing.JTextField();
        jtfPrecioVenta = new javax.swing.JTextField();
        jbCalcular = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jtfCantidad = new javax.swing.JTextField();
        jcbEstilistas = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("REGISTRO DE VENTAS");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Cliente"));

        jLabel11.setText("Nombres:");
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtfNomClie.setEditable(false);

        jbSearch.setBackground(new java.awt.Color(204, 204, 255));
        jbSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp_muzamia/ui/imgs/icons8-find-48.png"))); // NOI18N
        jbSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSearchActionPerformed(evt);
            }
        });

        jbAdd.setBackground(new java.awt.Color(204, 255, 204));
        jbAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp_muzamia/ui/imgs/icons8-join-48.png"))); // NOI18N
        jbAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddActionPerformed(evt);
            }
        });

        jLabel12.setText("Doc. Identidad:");
        jLabel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtfDNI.setEditable(false);

        jLabel14.setText("Nro. Cliente:");
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtfClieID.setEditable(false);

        jLabel16.setText("Apellidos:");
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtfApeClie.setEditable(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfApeClie, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfNomClie, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfClieID, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
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

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Facturación"));

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

        jtfPagoTotal.setEditable(false);

        buttonGroup2.add(jrbPagoParcial);
        jrbPagoParcial.setText("Pago Parcial");
        jrbPagoParcial.setBorderPainted(true);
        jrbPagoParcial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrbPagoParcialMouseClicked(evt);
            }
        });

        jLabel17.setText("Periodo:");
        jLabel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jcbPeriodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Periodo ..." }));

        jLabel28.setText("S/.");
        jLabel28.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel29.setText("S/.");
        jLabel29.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jrbPagoTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jrbPagoParcial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtfPagoParcial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(jtfPagoTotal, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jdcFechaOpe, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jdcFechaOpe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbPagoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfPagoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbPagoParcial)
                    .addComponent(jtfPagoParcial, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jtVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nro. Item", "serv_id", "Servicio", "prod_id", "Producto", "id_Estilista", "Estilista", "Precio", "Cant.", "Sub Total", "Dscto.", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, true, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtVentasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtVentas);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 255));
        jLabel15.setText("VENTA TOTAL:");

        jlTotalVenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jlTotalVenta.setForeground(new java.awt.Color(0, 0, 255));
        jlTotalVenta.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jlTotalVenta.setText("S/. 0.0");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Venta"));

        jLabel1.setText("Precio Pizarra:");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtfPrecioPizarraServ.setEditable(false);

        jLabel27.setText("S/.");
        jLabel27.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtfServicio.setEditable(false);

        jbFndServicio.setBackground(new java.awt.Color(255, 153, 255));
        jbFndServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp_muzamia/ui/imgs/icons8-barber-scissors-20.png"))); // NOI18N
        jbFndServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFndServicioActionPerformed(evt);
            }
        });

        jtfProducto.setEditable(false);

        jbFndProducto.setBackground(new java.awt.Color(0, 255, 204));
        jbFndProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp_muzamia/ui/imgs/icons8-shampoo-20.png"))); // NOI18N
        jbFndProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFndProductoActionPerformed(evt);
            }
        });

        jLabel30.setText("S/.");
        jLabel30.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtfPrecioCostoProd.setEditable(false);

        jLabel18.setText("Precio Costo:");
        jLabel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jrbProducto.setBackground(new java.awt.Color(0, 255, 204));
        buttonGroup3.add(jrbProducto);
        jrbProducto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jrbProducto.setText("Producto");
        jrbProducto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jrbProducto.setBorderPainted(true);
        jrbProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrbProductoMouseClicked(evt);
            }
        });
        jrbProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbProductoActionPerformed(evt);
            }
        });

        jrbServicio.setBackground(new java.awt.Color(255, 153, 255));
        buttonGroup3.add(jrbServicio);
        jrbServicio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jrbServicio.setText("Servicio");
        jrbServicio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jrbServicio.setBorderPainted(true);
        jrbServicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrbServicioMouseClicked(evt);
            }
        });
        jrbServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbServicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrbServicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jtfPrecioPizarraServ, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jtfServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbFndServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jrbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfPrecioCostoProd, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jbFndProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jbFndServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jrbServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jrbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jbFndProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfPrecioPizarraServ, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfPrecioCostoProd, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Formas de Pago"));

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
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jchkbTransferencia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jchkbEfectivo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jchkbPlin, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jchkbConTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jchkbYape, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jchkbEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jchkbConTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jchkbTransferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jchkbYape, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jchkbPlin, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Botones Acción"));

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

        jbComprobante.setBackground(new java.awt.Color(255, 0, 255));
        jbComprobante.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbComprobante.setForeground(new java.awt.Color(255, 255, 255));
        jbComprobante.setText("Comprobante");
        jbComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbComprobanteActionPerformed(evt);
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
                    .addComponent(jbFinalizarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbComprobante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jbNuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jbLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jbGuardarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jbAgregarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jbPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jbFinalizarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jbComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jbCancelarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Venta"));

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

        jLabel2.setText("Precio Venta:");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtfTotal.setEditable(false);
        jtfTotal.setBackground(new java.awt.Color(51, 51, 255));
        jtfTotal.setForeground(new java.awt.Color(255, 255, 255));

        jbCalcular.setText("Calcular");
        jbCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCalcularActionPerformed(evt);
            }
        });

        jLabel10.setText("Estilista:");
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtfCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCantidadKeyTyped(evt);
            }
        });

        jcbEstilistas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar una estilista ..." }));
        jcbEstilistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEstilistasActionPerformed(evt);
            }
        });

        jLabel13.setText("Cant.");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("S/.");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbEstilistas, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jtfPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbEstilistas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbCalcular, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(734, 734, 734)
                        .addComponent(jLabel15)
                        .addGap(32, 32, 32)
                        .addComponent(jlTotalVenta))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

    private void jbSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSearchActionPerformed
        DaoClientes daoClientes = new DaoClientesImpl();
        Clientes clientes = new Clientes();

        List<Clientes> list = daoClientes.lst_Clientes_2();

        if (list.size() < 0) {
            return;
        } else if (list.size() == 0) {
            JOptionPane.showMessageDialog(null, "No se encontraron clientes.", "LISTADO DE CLIENTES", JOptionPane.INFORMATION_MESSAGE);
        } else {
            lstClientes(list);
        }
    }//GEN-LAST:event_jbSearchActionPerformed

    private void jbAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddActionPerformed
        addClientes();
    }//GEN-LAST:event_jbAddActionPerformed

    private void jrbPagoTotalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrbPagoTotalMouseClicked
        jtfPagoParcial.setEnabled(false);
    }//GEN-LAST:event_jrbPagoTotalMouseClicked

    private void jrbPagoParcialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrbPagoParcialMouseClicked
        jtfPagoParcial.setEnabled(true);
    }//GEN-LAST:event_jrbPagoParcialMouseClicked

    private void jtVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtVentasMouseClicked
        accion = 1;
        row = jtVentas.getSelectedRow();

        Integer idCate = Integer.parseInt(jtVentas.getValueAt(row, 3).toString());
        Integer index = 0;

//        for (int i = 0; i < obj_cate.length; i++) {
//            index = Integer.parseInt(obj_cate[i][1].toString());
//            if (index == idCate) {
//                jcbCategoriaServicios.setSelectedIndex(i + 1);
//            }
//        }
//
//        Integer idServ = Integer.parseInt(jtVentas.getValueAt(row, 1).toString());
//
//        for (int i = 0; i < obj_serv.length; i++) {
//            index = Integer.parseInt(obj_serv[i][1].toString());
//            if (index == idServ) {
//                jcbServicios.setSelectedIndex(i + 1);
//            }
//        }
        jtfPrecioVenta.setText(jtVentas.getValueAt(row, 7).toString());
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

        habilita_Panel_Datos_Venta(true);

        //Botones laterales
        jbLimpiar.setEnabled(true);
        jbGuardarVenta.setEnabled(true);
        jbAgregarServicio.setEnabled(false);
    }//GEN-LAST:event_jtVentasMouseClicked

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
            String message = null;

            if (jtfPrecioVenta.getText() == null || jtfPrecioVenta.getText() == "" || jtfPrecioVenta.getText().isEmpty()) {
                if (message == null) {
                    message = "Validación de campos:\n";
                }
                message += "\n* Ingresar Precio de Venta.";
            }

            if (jtfCantidad.getText() == null || jtfCantidad.getText() == "" || jtfCantidad.getText().isEmpty()) {
                if (message == null) {
                    message = "Validación de campos:\n";
                }
                message += "\n* Ingresar Cantidad.";
            }

            if (message != null) {
                JOptionPane.showMessageDialog(null, message, "Alerta", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            Double precio = Double.parseDouble(jtfPrecioVenta.getText());
            Integer cantidad = Integer.parseInt(jtfCantidad.getText());

            Double descuento = Double.parseDouble(jtfDescuento.getText());
            Double subtotal = calculaSubTotal(precio, cantidad, descuento);
            jtfTotal.setText(subtotal.toString());

        } catch (NumberFormatException e) {
            StringBuilder err = new StringBuilder();
            err.append("Los siguientes campos solo deben contener números:\n")
                    .append("* Previo Venta\n")
                    .append("* Cantidad\n")
                    .append("* Descuento");

            JOptionPane.showMessageDialog(null, err, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbCalcularActionPerformed

    private void jcbEstilistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEstilistasActionPerformed
        Integer id = jcbEstilistas.getSelectedIndex();
        if (id > 0) {
            Integer index = Integer.parseInt(obj_estl[id - 1][1].toString());
        }
    }//GEN-LAST:event_jcbEstilistasActionPerformed

    private void jbAgregarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarServicioActionPerformed
        accion = 0;

        if (vnta == 1) {
            habilita_Panel_Venta_Servicios(true);
            jrbProducto.setEnabled(true);
        } else if (vnta == 2) {
            habilita_Panel_Venta_Productos(true);
            jrbServicio.setEnabled(true);
        }
        habilita_Panel_Datos_Venta(true);

        //Botones laterales
        jbLimpiar.setEnabled(true);
        jbGuardarVenta.setEnabled(true);
        jbAgregarServicio.setEnabled(false);
    }//GEN-LAST:event_jbAgregarServicioActionPerformed

    private void jbPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPagarActionPerformed
        habilita_Panel_Venta(false);
        habilita_Panel_Datos_Venta(false);
        habilita_Panel_Pag(true);
        habilita_Panel_Formas_Pago(true);

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

        int sw_tipo = 0;

        if (jrbProducto.isSelected()) {
            sw_tipo = 1;
        }

        if (jtfServicio.getText().isEmpty() && jtfProducto.getText().isEmpty()) {
            if (message == null) {
                message = "Validación de campos:\n";
            }
            message += "\n* Ingresar Servicio / Producto.";
        }

        if (jtfPrecioVenta.getText().isEmpty()) {
            if (message == null) {
                message = "Validación de campos:\n";
            }
            message += "\n* Ingresar Precio de Venta.";
        }

        if (jtfCantidad.getText().isEmpty()) {
            if (message == null) {
                message = "Validación de campos:\n";
            }
            message += "\n* Ingresar cantidad.";
        }

        if (jcbEstilistas.getSelectedIndex() == 0 && sw_tipo == 0) {
            if (message == null) {
                message = "Validación de campos:\n";
            }
            message += "\n* Seleccionar Estilista.";
        }

        if (message != null) {
            JOptionPane.showMessageDialog(null, message, "Alerta", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        boolean calculado = false;
        Double precio = Double.parseDouble(jtfPrecioVenta.getText());
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

        if (message != null) {
            JOptionPane.showMessageDialog(null, message, "Alerta", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (accion == 0) {
            addDetalle(sw_tipo);
        } else if (accion == 1) {
            updDetalle(row);
        }

        habilita_Panel_Venta(false);
        habilita_Panel_Datos_Venta(false);
        habilita_Panel_Pag(false);
        habilita_Panel_Formas_Pago(false);

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
        limpiar_Datos();
        jbGuardarVenta.setEnabled(false);
    }//GEN-LAST:event_jbLimpiarActionPerformed

    private void jbNuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevaVentaActionPerformed
        accion = 0;

        inicializarDatos();

        jbSearch.setEnabled(true);
        jbAdd.setEnabled(true);
        jrbServicio.setEnabled(true);
        jrbProducto.setEnabled(true);

        jbNuevaVenta.setEnabled(false);
        jbLimpiar.setEnabled(true);
        jbCancelarVenta.setEnabled(true);
    }//GEN-LAST:event_jbNuevaVentaActionPerformed

    private void jbFinalizarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFinalizarVentaActionPerformed
        String message = null;
        double mnt_pagado = 0.0;
        double mnt_saldo = 0.0;
        int clie_id = 0;
        int peri_id = 0;

        if (jtfClieID.getText().isBlank() || jtfClieID.getText().isEmpty()) {
            if (message == null) {
                message = "Validación de campos:\n";
            }
            message += "\n* Ingresar cliente.";
        } else {
            clie_id = Integer.parseInt(jtfClieID.getText());
        }

        if (jchkbEfectivo.isSelected()) {
            forma_pago_id = 1;
        } else if (jchkbConTarjeta.isSelected()) {
            forma_pago_id = 2;
        } else if (jchkbTransferencia.isSelected()) {
            forma_pago_id = 3;
        } else if (jchkbYape.isSelected()) {
            forma_pago_id = 4;
        } else if (jchkbPlin.isSelected()) {
            forma_pago_id = 5;
        } else {
            if (message == null) {
                message = "Validación de campos:\n";
            }
            message += "\n* Seleccionar Forma de Pago.";
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

        if (jcbPeriodo.getSelectedIndex() < 1) {
            if (message == null) {
                message = "Validación de campos:\n";
            }
            message += "\n* Seleccionar un Periodo.";
        } else {
            int idx = jcbPeriodo.getSelectedIndex() - 1;
            peri_id = Integer.parseInt(obj_peri[idx][1].toString());
        }

        if (message != null) {
            JOptionPane.showMessageDialog(null, message, "Alerta", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int Ok = JOptionPane.showConfirmDialog(null, "El monto a pagar es " + totalVenta + ".\n\n¿Desea finalizar la venta?", "Finalizar Operación", JOptionPane.YES_NO_OPTION);

        if (Ok == 0) {
            try {
                Operaciones operacionBE = new Operaciones();

                // temporal
                mnt_saldo = totalVenta - mnt_pagado;

                operacionBE.setTope_id(1); // Venta
                operacionBE.setUser_id(1); // Aldo
                operacionBE.setTcom_id(1); // Boleta
                operacionBE.setOper_flag_emit_comp(false);
                operacionBE.setOper_flag_impr_comp(false);
                operacionBE.setFpag_id(forma_pago_id);
                operacionBE.setPeri_id(peri_id);
                operacionBE.setClie_id(clie_id);
                operacionBE.setOper_monto(totalVenta);
                operacionBE.setOper_pagado(mnt_pagado);
                operacionBE.setOper_saldo(mnt_saldo);

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                operacionBE.setOper_fecha(sdf.format(jdcFechaOpe.getDate()));
                operacionBE.setEsta_id(1);
//                operacionBE.setOper_timestamp();

                DaoOperacion daoOperacion = new DaoOperacionImpl();

                int idOpe = daoOperacion.ins_Operaciones(operacionBE);

                DetalleOperacion detOperacionBE = null;
                DaoDetalleOperacion daoDetOperacion = new DaoDetalleOperacionImpl();
                List<DetalleOperacion> list = new ArrayList<DetalleOperacion>();

                for (int i = 0; i < jtVentas.getRowCount(); i++) {
                    detOperacionBE = new DetalleOperacion();
                    detOperacionBE.setOper_id(idOpe);

                    if (vnta == 1) {
                        detOperacionBE.setServ_id(Integer.parseInt(jtVentas.getModel().getValueAt(i, 1).toString()));
                        detOperacionBE.setProd_id(0);
                        detOperacionBE.setUser_id(Integer.parseInt(jtVentas.getModel().getValueAt(i, 5).toString()));
                    } else {
                        detOperacionBE.setServ_id(0);
                        detOperacionBE.setProd_id(Integer.parseInt(jtVentas.getModel().getValueAt(i, 3).toString()));
                        detOperacionBE.setUser_id(0);
                    }
                    detOperacionBE.setProv_id(0);
                    detOperacionBE.setActi_id(0);
                    detOperacionBE.setPasi_id(0);
                    detOperacionBE.setDope_precio(Double.parseDouble(jtVentas.getModel().getValueAt(i, 7).toString()));
                    detOperacionBE.setDope_cantidad(Integer.parseInt(jtVentas.getModel().getValueAt(i, 8).toString()));
                    detOperacionBE.setDope_subtotal(Double.parseDouble(jtVentas.getModel().getValueAt(i, 9).toString()));
                    detOperacionBE.setDope_descuento(Double.parseDouble(jtVentas.getModel().getValueAt(i, 10).toString()));
                    detOperacionBE.setDope_total(Double.parseDouble(jtVentas.getModel().getValueAt(i, 11).toString()));
                    detOperacionBE.setEsta_id(1);
                    detOperacionBE.setDope_timestamp(null);
                    message = daoDetOperacion.ins_DetalleOperacion(detOperacionBE);
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

    private void jbComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbComprobanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbComprobanteActionPerformed

    private void jbFndServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFndServicioActionPerformed
        DaoServicios daoServicios = new DaoServiciosImpl();

        List<Servicios> list = daoServicios.lst_Servicios_2_1();

        if (list.size() < 0) {
            return;
        } else if (list.size() == 0) {
            StringBuilder message = new StringBuilder();
            message.append("No se tienen SERVICIOS registrados.\n")
                    .append("\n * Ir a 'Configurar'.")
                    .append("\n * Ir a 'Configurar Servicios'.")
                    .append("\n * Registrar al menos un SERVICIO.");
            JOptionPane.showMessageDialog(null, message.toString(), "LISTADO DE SERVICIOS", JOptionPane.INFORMATION_MESSAGE);
        } else {
            lstServicios(list);
        }
    }//GEN-LAST:event_jbFndServicioActionPerformed

    private void jrbServicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrbServicioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbServicioMouseClicked

    private void jrbProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrbProductoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbProductoMouseClicked

    private void jbFndProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFndProductoActionPerformed
        DaoProductos daoProductos = new DaoProductosImpl();

        List<Productos> list = daoProductos.lst_Productos_2_1();

        if (list.size() < 0) {
            return;
        } else if (list.size() == 0) {
            StringBuilder message = new StringBuilder();
            message.append("No se tienen PRODUCTOS registrados.\n")
                    .append("\n * Ir a 'Configurar'.")
                    .append("\n * Ir a 'Configurar Productos'.")
                    .append("\n * Registrar al menos un PRODUCTO.");
            JOptionPane.showMessageDialog(null, message.toString(), "LISTADO DE PRODUCTOS", JOptionPane.INFORMATION_MESSAGE);
        } else {
            lstProductos(list);
        }
    }//GEN-LAST:event_jbFndProductoActionPerformed

    private void jrbServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbServicioActionPerformed
        if (vnta == 2) {
            jbFndServicio.setEnabled(true);
            jtfServicio.setEnabled(true);
            jtfPrecioPizarraServ.setEnabled(true);

            jbFndProducto.setEnabled(false);
            jtfProducto.setEnabled(false);
            jtfPrecioCostoProd.setEnabled(false);

            jtfProducto.setText("");
            jtfPrecioCostoProd.setText("");

            jtfPrecioVenta.setText("");
            jtfCantidad.setText("");
            jtfDescuento.setText("");
            jtfTotal.setText("");

            habilita_Panel_Datos_Venta(false);

            if (jbGuardarVenta.isEnabled()) {
                jbGuardarVenta.setEnabled(false);
            }

            vnta = 1;
            return;
        }

        if (vnta == 0) {
            jbFndServicio.setEnabled(true);
            jtfServicio.setEnabled(true);
            jtfPrecioPizarraServ.setEnabled(true);
            vnta = 1;
        }
    }//GEN-LAST:event_jrbServicioActionPerformed

    private void jrbProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbProductoActionPerformed
        if (vnta == 1) {
            jbFndProducto.setEnabled(true);
            jtfProducto.setEnabled(true);
            jtfPrecioCostoProd.setEnabled(true);

            jbFndServicio.setEnabled(false);
            jtfServicio.setEnabled(false);
            jtfPrecioPizarraServ.setEnabled(false);

            jtfServicio.setText("");
            jtfPrecioPizarraServ.setText("");

            jtfPrecioVenta.setText("");
            jtfCantidad.setText("");
            jtfDescuento.setText("");
            jtfTotal.setText("");
            jcbEstilistas.setSelectedIndex(0);

            habilita_Panel_Datos_Venta(false);

            if (jbGuardarVenta.isEnabled()) {
                jbGuardarVenta.setEnabled(false);
            }
            vnta = 2;
            return;
        }

        if (vnta == 0) {
            jbFndProducto.setEnabled(true);
            jtfProducto.setEnabled(true);
            jtfPrecioCostoProd.setEnabled(true);
            vnta = 2;
        }
    }//GEN-LAST:event_jrbProductoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
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
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAdd;
    private javax.swing.JButton jbAgregarServicio;
    private javax.swing.JButton jbCalcular;
    private javax.swing.JButton jbCancelarVenta;
    private javax.swing.JButton jbComprobante;
    private javax.swing.JButton jbFinalizarVenta;
    private javax.swing.JButton jbFndProducto;
    private javax.swing.JButton jbFndServicio;
    private javax.swing.JButton jbGuardarVenta;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JButton jbNuevaVenta;
    private javax.swing.JButton jbPagar;
    private javax.swing.JButton jbSearch;
    private javax.swing.JComboBox<String> jcbEstilistas;
    private javax.swing.JComboBox<String> jcbPeriodo;
    private javax.swing.JCheckBox jchkbConTarjeta;
    private javax.swing.JCheckBox jchkbEfectivo;
    private javax.swing.JCheckBox jchkbPlin;
    private javax.swing.JCheckBox jchkbTransferencia;
    private javax.swing.JCheckBox jchkbYape;
    private com.toedter.calendar.JDateChooser jdcFechaOpe;
    private javax.swing.JLabel jlTotalVenta;
    private javax.swing.JRadioButton jrbPagoParcial;
    private javax.swing.JRadioButton jrbPagoTotal;
    private javax.swing.JRadioButton jrbProducto;
    private javax.swing.JRadioButton jrbServicio;
    private javax.swing.JTable jtVentas;
    private javax.swing.JTextField jtfApeClie;
    private javax.swing.JTextField jtfCantidad;
    private javax.swing.JTextField jtfClieID;
    private javax.swing.JTextField jtfDNI;
    private javax.swing.JTextField jtfDescuento;
    private javax.swing.JTextField jtfNomClie;
    private javax.swing.JTextField jtfPagoParcial;
    private javax.swing.JTextField jtfPagoTotal;
    private javax.swing.JTextField jtfPrecioCostoProd;
    private javax.swing.JTextField jtfPrecioPizarraServ;
    private javax.swing.JTextField jtfPrecioVenta;
    private javax.swing.JTextField jtfProducto;
    private javax.swing.JTextField jtfServicio;
    private javax.swing.JTextField jtfTotal;
    // End of variables declaration//GEN-END:variables

    public void limpiar_Datos() {
        // Datos Cliente
        jtfNomClie.setText("");
        jtfApeClie.setText("");
        jtfDNI.setText("");
        jtfClieID.setText("");

        // Venta
        buttonGroup3.clearSelection();
        jtfServicio.setText("");
        jtfPrecioPizarraServ.setText("");
        jtfProducto.setText("");
        jtfPrecioCostoProd.setText("");

        // Datos Venta
        jtfPrecioVenta.setText("");
        jtfCantidad.setText("");
        jtfDescuento.setText("");
        jtfTotal.setText("");
        jcbEstilistas.setSelectedIndex(0);

        // Datos Facturación
        jdcFechaOpe.setDate(null);
        jcbPeriodo.setSelectedIndex(0);
        buttonGroup2.clearSelection();
        jtfPagoTotal.setText("");
        jtfPagoParcial.setText("");

        // Formas de Pago
        buttonGroup1.clearSelection();
    }

    public void habilita_Panel_Datos_Cliente(boolean estado) {
        jtfNomClie.setEnabled(estado);
        jtfApeClie.setEnabled(estado);
        jtfDNI.setEnabled(estado);
        jtfClieID.setEnabled(estado);

        jbSearch.setEnabled(estado);
        jbAdd.setEnabled(estado);
    }

    public void habilita_Panel_Venta(boolean estado) {
        jrbServicio.setEnabled(estado);
        jbFndServicio.setEnabled(estado);
        jtfServicio.setEnabled(estado);
        jtfPrecioPizarraServ.setEnabled(estado);

        jrbProducto.setEnabled(estado);
        jbFndProducto.setEnabled(estado);
        jtfProducto.setEnabled(estado);
        jtfPrecioCostoProd.setEnabled(estado);
    }

    public void habilita_Panel_Venta_Servicios(boolean estado) {
        jrbServicio.setEnabled(estado);
        jbFndServicio.setEnabled(estado);
        jtfServicio.setEnabled(estado);
        jtfPrecioPizarraServ.setEnabled(estado);
    }

    public void habilita_Panel_Venta_Productos(boolean estado) {
        jrbProducto.setEnabled(estado);
        jbFndProducto.setEnabled(estado);
        jtfProducto.setEnabled(estado);
        jtfPrecioCostoProd.setEnabled(estado);
    }

    public void habilita_Panel_Datos_Venta(boolean estado) {
        jtfPrecioVenta.setEnabled(estado);
        jtfCantidad.setEnabled(estado);
        jtfDescuento.setEnabled(estado);
        jbCalcular.setEnabled(estado);

        if (!jrbProducto.isSelected()) {
            jcbEstilistas.setEnabled(estado);
        }
    }

    public void habilita_Panel_Formas_Pago(boolean estado) {
        jchkbEfectivo.setEnabled(estado);
        jchkbConTarjeta.setEnabled(estado);
        jchkbTransferencia.setEnabled(estado);
        jchkbYape.setEnabled(estado);
        jchkbPlin.setEnabled(estado);
    }

    public void habilita_Panel_Pag(boolean estado) {
        jdcFechaOpe.setEnabled(estado);
        jcbPeriodo.setEnabled(estado);
        jrbPagoTotal.setEnabled(estado);
        jrbPagoParcial.setEnabled(estado);
        jtfPagoTotal.setEnabled(estado);
        jtfPagoParcial.setEnabled(estado);
    }
}
