/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package erp_muzamia.ui;

import erp_muzamia.dao.DaoNiveles;
import erp_muzamia.dao.DaoRoles;
import erp_muzamia.dao.DaoUsuarios;
import erp_muzamia.dao.DaoUsuarios;
import erp_muzamia.dao.impl.DaoNivelesImpl;
import erp_muzamia.dao.impl.DaoRolesImpl;
import erp_muzamia.dao.impl.DaoUsuariosImpl;
import erp_muzamia.dao.impl.DaoUsuariosImpl;
import erp_muzamia.dto.Niveles;
import erp_muzamia.dto.Roles;
import erp_muzamia.dto.Usuarios;
import erp_muzamia.dto.Usuarios;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class MantEstiUI extends javax.swing.JFrame {

    /**
     * Creates new form MantServUI2
     */
    public MantEstiUI() {
        initComponents();
        listarNiveles();
        listarColumnasTabla();
        listarEstilistas();
        inicializarDatos();
    }

    Integer accion = 0;
    Object[][] obj_nvel;
    Object[][] obj_role;

    public void listarColumnasTabla() {
        jtUsuarios.getColumnModel().getColumn(0).setMaxWidth(50);
        jtUsuarios.getColumnModel().getColumn(0).setMinWidth(50);
        jtUsuarios.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(50);
        jtUsuarios.getTableHeader().getColumnModel().getColumn(0).setMinWidth(50);

        jtUsuarios.getColumnModel().getColumn(1).setMaxWidth(120);
        jtUsuarios.getColumnModel().getColumn(1).setMinWidth(120);
        jtUsuarios.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(120);
        jtUsuarios.getTableHeader().getColumnModel().getColumn(1).setMinWidth(120);

        jtUsuarios.getColumnModel().getColumn(2).setMaxWidth(120);
        jtUsuarios.getColumnModel().getColumn(2).setMinWidth(120);
        jtUsuarios.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(120);
        jtUsuarios.getTableHeader().getColumnModel().getColumn(2).setMinWidth(120);

        jtUsuarios.getColumnModel().getColumn(3).setMaxWidth(80);
        jtUsuarios.getColumnModel().getColumn(3).setMinWidth(80);
        jtUsuarios.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(80);
        jtUsuarios.getTableHeader().getColumnModel().getColumn(3).setMinWidth(80);

        jtUsuarios.getColumnModel().getColumn(4).setMaxWidth(120);
        jtUsuarios.getColumnModel().getColumn(4).setMinWidth(120);
        jtUsuarios.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(120);
        jtUsuarios.getTableHeader().getColumnModel().getColumn(4).setMinWidth(120);

        jtUsuarios.getColumnModel().getColumn(5).setMaxWidth(80);
        jtUsuarios.getColumnModel().getColumn(5).setMinWidth(80);
        jtUsuarios.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(80);
        jtUsuarios.getTableHeader().getColumnModel().getColumn(5).setMinWidth(80);

        jtUsuarios.getColumnModel().getColumn(6).setMaxWidth(80);
        jtUsuarios.getColumnModel().getColumn(6).setMinWidth(80);
        jtUsuarios.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(80);
        jtUsuarios.getTableHeader().getColumnModel().getColumn(6).setMinWidth(80);

        jtUsuarios.getColumnModel().getColumn(7).setMaxWidth(80);
        jtUsuarios.getColumnModel().getColumn(7).setMinWidth(80);
        jtUsuarios.getTableHeader().getColumnModel().getColumn(7).setMaxWidth(80);
        jtUsuarios.getTableHeader().getColumnModel().getColumn(7).setMinWidth(80);

        jtUsuarios.getColumnModel().getColumn(8).setMaxWidth(80);
        jtUsuarios.getColumnModel().getColumn(8).setMinWidth(80);
        jtUsuarios.getTableHeader().getColumnModel().getColumn(8).setMaxWidth(80);
        jtUsuarios.getTableHeader().getColumnModel().getColumn(8).setMinWidth(80);

        jtUsuarios.getColumnModel().getColumn(9).setMaxWidth(0);
        jtUsuarios.getColumnModel().getColumn(9).setMinWidth(0);
        jtUsuarios.getTableHeader().getColumnModel().getColumn(9).setMaxWidth(0);
        jtUsuarios.getTableHeader().getColumnModel().getColumn(9).setMinWidth(0);

        jtUsuarios.getColumnModel().getColumn(10).setMaxWidth(100);
        jtUsuarios.getColumnModel().getColumn(10).setMinWidth(100);
        jtUsuarios.getTableHeader().getColumnModel().getColumn(10).setMaxWidth(100);
        jtUsuarios.getTableHeader().getColumnModel().getColumn(10).setMinWidth(100);

        jtUsuarios.getColumnModel().getColumn(11).setMaxWidth(80);
        jtUsuarios.getColumnModel().getColumn(11).setMinWidth(80);
        jtUsuarios.getTableHeader().getColumnModel().getColumn(11).setMaxWidth(80);
        jtUsuarios.getTableHeader().getColumnModel().getColumn(11).setMinWidth(80);

        jtUsuarios.getColumnModel().getColumn(12).setMaxWidth(200);
        jtUsuarios.getColumnModel().getColumn(12).setMinWidth(200);
        jtUsuarios.getTableHeader().getColumnModel().getColumn(12).setMaxWidth(200);
        jtUsuarios.getTableHeader().getColumnModel().getColumn(12).setMinWidth(200);
    }

    public void inicializarDatos() {
        limpiar_Datos();

        habilita_campos(false);

// Botones laterales
        jbNuevo.setEnabled(true);
        jbLimpiar.setEnabled(false);
        jbGuardar.setEnabled(false);
        jbModificar.setEnabled(false);
        jbEliminar.setEnabled(false);
    }

    public void listarNiveles() {
        DaoNiveles daoNiveles = new DaoNivelesImpl();
        List<Niveles> list = daoNiveles.lst_Niveles_2();
        obj_nvel = new Integer[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            jcbNivel.addItem(list.get(i).getNvel_codigo());
            obj_nvel[i][0] = i;
            obj_nvel[i][1] = list.get(i).getNvel_id();
        };
    }

    public void listarRoles() {
        DaoRoles daoRoles = new DaoRolesImpl();
        List<Roles> list = daoRoles.lst_Roles_2();
        obj_role = new Integer[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            jcbNivel.addItem(list.get(i).getRole_nombre());
            obj_role[i][0] = i;
            obj_role[i][1] = list.get(i).getRole_id();
        };
    }

    public void listarEstilistas() {
        DaoUsuarios daoUsuarios = new DaoUsuariosImpl();
        List<Object[]> list = daoUsuarios.lst_Usuarios_1_1();

        DefaultTableModel model = (DefaultTableModel) jtUsuarios.getModel();
        model.setRowCount(0);

        Object[] row;

        for (int i = 0; i < list.size(); i++) {
            row = new Object[13];
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
        jtUsuarios = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jcbNivel = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtfNombres = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfApellidos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfCodigo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtfID = new javax.swing.JTextField();
        jcbEstado = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jdcFechaNac = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jtfDni = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jdcFechaIng = new com.toedter.calendar.JDateChooser();
        jpfPassword = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jbLimpiar = new javax.swing.JButton();
        jbNuevo = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MANTENIMIENTO DE ESTILISTAS");

        jtUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombres", "Apellidos", "Código", "Password", "Fec. Nacim.", "DNI", "Fec. Ingreso", "Fec. Salida", "nvel_id", "Nivel", "Estado", "Fec. Ult. Mod."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtUsuarios);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos estilista"));

        jcbNivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar un Nivel ..." }));
        jcbNivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbNivelActionPerformed(evt);
            }
        });

        jLabel4.setText("Nivel:");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Nombres:");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Apellidos:");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Código:");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setText("ID:");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtfID.setEnabled(false);

        jcbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        jLabel6.setText("Estado:");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("Password:");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jdcFechaNac.setDateFormatString("yyyy-MM-dd");
        jdcFechaNac.setMinimumSize(new java.awt.Dimension(120, 22));
        jdcFechaNac.setPreferredSize(new java.awt.Dimension(120, 22));

        jLabel9.setText("Fecha de Nacimiento:");
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setText("DNI:");
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setText("Fecha de Ingreso:");
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jdcFechaIng.setDateFormatString("yyyy-MM-dd");
        jdcFechaIng.setMinimumSize(new java.awt.Dimension(120, 22));
        jdcFechaIng.setPreferredSize(new java.awt.Dimension(120, 22));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfID, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)
                            .addComponent(jcbNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)
                            .addComponent(jdcFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdcFechaIng, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jtfApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jtfDni, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfID, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtfNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfDni, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jpfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jdcFechaNac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jdcFechaIng, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Botones de acción"));

        jbLimpiar.setText("Limpiar");
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });

        jbNuevo.setText("Nuevo");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbModificar.setText("Modificar");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jbNuevo)
                .addGap(12, 12, 12)
                .addComponent(jbLimpiar)
                .addGap(12, 12, 12)
                .addComponent(jbModificar)
                .addGap(12, 12, 12)
                .addComponent(jbGuardar)
                .addGap(12, 12, 12)
                .addComponent(jbEliminar)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtUsuariosMouseClicked
        int row = jtUsuarios.getSelectedRow();
        jtfID.setText(jtUsuarios.getValueAt(row, 0).toString());
        jtfNombres.setText(jtUsuarios.getValueAt(row, 1).toString());
        jtfApellidos.setText(jtUsuarios.getValueAt(row, 2).toString());
        jtfCodigo.setText(jtUsuarios.getValueAt(row, 3).toString());
        jpfPassword.setText(jtUsuarios.getValueAt(row, 4).toString());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(jtUsuarios.getValueAt(row, 5).toString());
            jdcFechaNac.setDate(date);
        } catch (Exception e) {

        }

        jtfDni.setText(jtUsuarios.getValueAt(row, 6).toString());

        date = null;
        try {
            date = sdf.parse(jtUsuarios.getValueAt(row, 7).toString());
            jdcFechaIng.setDate(date);
        } catch (Exception e) {

        }

        Integer id = Integer.parseInt(jtUsuarios.getValueAt(row, 9).toString());

        for (int i = 0; i < obj_nvel.length; i++) {
            Integer index = Integer.parseInt(obj_nvel[i][1].toString());
            if (index == id) {
                jcbNivel.setSelectedIndex(i + 1);
            }
        }

        if (jtUsuarios.getValueAt(row, 11) == "Activo") {
            jcbEstado.setSelectedIndex(0);
        } else if (jtUsuarios.getValueAt(row, 11) == "Inactivo") {
            jcbEstado.setSelectedIndex(1);
        }

        jbNuevo.setEnabled(true);
        jbLimpiar.setEnabled(false);
        jbModificar.setEnabled(true);
        jbGuardar.setEnabled(false);
        jbEliminar.setEnabled(true);

        habilita_campos(false);
    }//GEN-LAST:event_jtUsuariosMouseClicked

    private void jcbNivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbNivelActionPerformed

    }//GEN-LAST:event_jcbNivelActionPerformed

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
        limpiar_Datos();
        jcbNivel.requestFocus();
    }//GEN-LAST:event_jbLimpiarActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        accion = 0;

        limpiar_Datos();

        habilita_campos(true);

        jbNuevo.setEnabled(false);
        jbLimpiar.setEnabled(true);
        jbModificar.setEnabled(false);
        jbGuardar.setEnabled(true);
        jbEliminar.setEnabled(false);
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        accion = 1;
        habilita_campos(true);

        jcbNivel.requestFocus();

        jbNuevo.setEnabled(true);
        jbLimpiar.setEnabled(false);
        jbGuardar.setEnabled(true);
        jbModificar.setEnabled(false);
        jbEliminar.setEnabled(false);
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        String message = null;

        if (jtfNombres.getText().isEmpty()) {
            if (message == null) {
                message = "Validación de campos:\n";
            }
            message += "\n* Ingresar Nombres.";
        }

        if (jtfApellidos.getText().isEmpty()) {
            if (message == null) {
                message = "Validación de campos:\n";
            }
            message += "\n* Ingresar Apellidos.";
        }

        if (jcbNivel.getSelectedIndex() == 0) {
            message = "Validación de campos:\n";
            message += "\n* Elegir un Nivel.";
        }

        if (jtfCodigo.getText().isEmpty()) {
            if (message == null) {
                message = "Validación de campos:\n";
            }
            message += "\n* Ingresar Código.";
        }

        if (jpfPassword.toString().isEmpty()) {
            if (message == null) {
                message = "Validación de campos:\n";
            }
            message += "\n* Ingresar Password.";
        }

        Date date1 = jdcFechaNac.getDate();
        if (date1 == null) {
            if (message == null) {
                message = "Validación de campos:\n";
            }
            message += "\n* Ingresar Fecha de Nacimiento.";
        }

        Date date2 = jdcFechaIng.getDate();
        if (date2 == null) {
            if (message == null) {
                message = "Validación de campos:\n";
            }
            message += "\n* Ingresar Fecha de Ingreso.";
        }

        if (jtfDni.getText().isEmpty()) {
            if (message == null) {
                message = "Validación de campos:\n";
            }
            message += "\n* Ingresar DNI.";
        }

        if (message != null) {
            JOptionPane.showMessageDialog(null, message, "Alerta", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        Usuarios usuarios = new Usuarios();
        if (!jtfID.getText().isEmpty()) {
            usuarios.setUser_id(Integer.parseInt(jtfID.getText()));
        }

        int idx = jcbNivel.getSelectedIndex() - 1;
        usuarios.setNvel_id(Integer.parseInt(obj_nvel[idx][1].toString()));

        usuarios.setUser_nombres(jtfNombres.getText());
        usuarios.setUser_apellidos(jtfApellidos.getText());

        usuarios.setUser_codigo(jtfCodigo.getText());
        usuarios.setUser_password(jpfPassword.getPassword().toString());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        usuarios.setUser_fecha_nacimiento(sdf.format(jdcFechaNac.getDate()));
        usuarios.setUser_dni(Integer.parseInt(jtfDni.getText()));
        usuarios.setUser_fecha_ingreso(sdf.format(jdcFechaIng.getDate()));

        usuarios.setRole_id(2);

        int estado = jcbEstado.getSelectedIndex();
        if (estado == 0) {
            usuarios.setUser_estado(true);
        } else {
            usuarios.setUser_estado(false);
        }

        message = null;

        DaoUsuarios daoUsuarios = new DaoUsuariosImpl();
        if (accion == 0) {
            message = daoUsuarios.ins_Usuarios(usuarios);
        } else {
            message = daoUsuarios.upd_Usuarios(usuarios);
        }

        if (message != null) {
            JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String cad = null;
        if (accion == 0) {
            cad = "Producto registrado satisfactoriamente.";
        } else {
            cad = "Producto actualizado satisfactoriamente.";
        }

        JOptionPane.showMessageDialog(null, cad, "En hora buena!", JOptionPane.INFORMATION_MESSAGE);

        limpiar_Datos();
        habilita_campos(false);

        jbNuevo.setEnabled(true);
        jbLimpiar.setEnabled(false);
        jbModificar.setEnabled(false);
        jbGuardar.setEnabled(false);
        jbEliminar.setEnabled(false);

        listarEstilistas();
    }//GEN-LAST:event_jbGuardarActionPerformed

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
            java.util.logging.Logger.getLogger(MantEstiUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantEstiUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantEstiUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantEstiUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new MantEstiUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JComboBox<String> jcbEstado;
    private javax.swing.JComboBox<String> jcbNivel;
    private com.toedter.calendar.JDateChooser jdcFechaIng;
    private com.toedter.calendar.JDateChooser jdcFechaNac;
    private javax.swing.JPasswordField jpfPassword;
    private javax.swing.JTable jtUsuarios;
    private javax.swing.JTextField jtfApellidos;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfDni;
    private javax.swing.JTextField jtfID;
    private javax.swing.JTextField jtfNombres;
    // End of variables declaration//GEN-END:variables

    public void limpiar_Datos() {
        jtfID.setText("");
        jtfNombres.setText("");
        jtfApellidos.setText("");
        jcbNivel.setSelectedIndex(0);
        jtfDni.setText("");
        jtfCodigo.setText("");
        jpfPassword.setText("");
        jdcFechaNac.setDate(null);
        jdcFechaIng.setDate(null);
        jcbEstado.setSelectedIndex(0);
    }

    public void habilita_campos(boolean estado) {
        jtfNombres.setEnabled(estado);
        jtfApellidos.setEnabled(estado);
        jcbNivel.setEnabled(estado);
        jtfDni.setEnabled(estado);
        jtfCodigo.setEnabled(estado);
        jpfPassword.setEnabled(estado);
        jdcFechaNac.setEnabled(estado);
        jdcFechaIng.setEnabled(estado);
        jcbEstado.setEnabled(estado);
    }
}
