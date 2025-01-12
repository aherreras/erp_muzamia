/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp_muzamia.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import erp_muzamia.dao.DaoUsuarios;
import erp_muzamia.dto.Usuarios;
import erp_muzamia.sql.ConectaDb;
import java.sql.CallableStatement;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class DaoUsuariosImpl implements DaoUsuarios {

    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public DaoUsuariosImpl() {
        db = new ConectaDb();
        this.sql = new StringBuilder();
    }

    @Override
    public String ins_Usuarios(Usuarios usuarios) {
        String sp = "{call sp_insUsuarios(?,?,?,?,?,?,?,?,?,?,?)}";
        Integer nvel_id = usuarios.getNvel_id();
        Integer user_dni = usuarios.getUser_dni();

        try ( Connection cn = db.getConnection();  CallableStatement cs = cn.prepareCall(sp)) {

            if (nvel_id == null) {
                cs.setNull(1, Types.INTEGER);
            } else {
                cs.setInt(1, nvel_id);
            }

            cs.setString(2, usuarios.getUser_nombres());
            cs.setString(3, usuarios.getUser_apellidos());
            cs.setString(4, usuarios.getUser_codigo());
            cs.setString(5, usuarios.getUser_password());
            cs.setString(6, usuarios.getUser_fecha_nacimiento());

            if (user_dni == null) {
                cs.setNull(7, Types.INTEGER);
            } else {
                cs.setInt(7, user_dni);
            }

            cs.setString(8, usuarios.getUser_fecha_ingreso());
            cs.setString(9, usuarios.getUser_fecha_salida());
            cs.setInt(10, usuarios.getRole_id());
            cs.setBoolean(11, usuarios.isUser_estado());

            int ctos = cs.executeUpdate();

            if (ctos == 0) {
                throw new SQLException("0 filas afectadas");
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return message;
    }

    @Override
    public String upd_Usuarios(Usuarios usuarios) {
        String sp = "{call sp_updUsuarios(?,?,?,?,?,?,?,?,?,?,?,?)}";
        Integer user_id = usuarios.getUser_id();
        Integer nvel_id = usuarios.getNvel_id();
        Integer user_dni = usuarios.getUser_dni();

        try ( Connection cn = db.getConnection();  CallableStatement cs = cn.prepareCall(sp)) {

            if (user_id == null) {
                cs.setNull(1, Types.INTEGER);
            } else {
                cs.setInt(1, user_id);
            }

            if (nvel_id == null) {
                cs.setNull(2, Types.INTEGER);
            } else {
                cs.setInt(2, nvel_id);
            }

            cs.setString(3, usuarios.getUser_nombres());
            cs.setString(4, usuarios.getUser_apellidos());
            cs.setString(5, usuarios.getUser_codigo());
            cs.setString(6, usuarios.getUser_password());
            cs.setString(7, usuarios.getUser_fecha_nacimiento());

            if (user_dni == null) {
                cs.setNull(8, Types.INTEGER);
            } else {
                cs.setInt(8, user_dni);
            }

            cs.setString(9, usuarios.getUser_fecha_ingreso());
            cs.setString(10, usuarios.getUser_fecha_salida());
            cs.setInt(11, usuarios.getRole_id());
            cs.setBoolean(12, usuarios.isUser_estado());

            int ctos = cs.executeUpdate();

            if (ctos == 0) {
                throw new SQLException("0 filas afectadas");
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return message;
    }

    @Override
    public List<Object[]> lst_Usuarios_1() {
        List<Object[]> lstUser = null;
        sql.append("SELECT ")
                .append("user_id,")
                .append("user_nombres,")
                .append("user_apellidos,")
                .append("user_codigo,")
                .append("user_fecha_nacimiento,")
                .append("user_dni,")
                .append("user_estado,")
                .append("user_fecha_ingreso,")
                .append("user_fecha_salida,")
                .append("role_id ")
                .append("FROM usuarios;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            lstUser = new LinkedList<>();

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] reg = new Object[10];
                    reg[0] = rs.getInt(1);
                    reg[1] = rs.getString(2);
                    reg[2] = rs.getString(3);
                    reg[3] = rs.getString(4);
                    reg[4] = rs.getString(5);
                    reg[5] = rs.getInt(6);
                    reg[6] = rs.getBoolean(7);
                    reg[7] = rs.getString(8);
                    reg[8] = rs.getString(9);
                    reg[9] = rs.getInt(10);

                    lstUser.add(reg);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return lstUser;
    }

    @Override
    public List<Object[]> lst_Usuarios_1_1() {
        List<Object[]> lstUser = null;
        sql.append("SELECT ")
                .append("user_id,")
                .append("user_nombres,")
                .append("user_apellidos,")
                .append("user_codigo,")
                .append("user_password,")
                .append("user_fecha_nacimiento,")
                .append("user_dni,")
                .append("user_fecha_ingreso,")
                .append("user_fecha_salida,")
                .append("u.nvel_id,")
                .append("nvel_codigo,")
                .append("user_estado,")
                .append("user_timestamp ")
                .append("FROM usuarios u ")
                .append("INNER JOIN niveles n ")
                .append("ON u.nvel_id = n.nvel_id ")
                .append("WHERE role_id = 2;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            lstUser = new LinkedList<>();

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] reg = new Object[13];
                    reg[0] = rs.getInt(1);
                    reg[1] = rs.getString(2);
                    reg[2] = rs.getString(3);
                    reg[3] = rs.getString(4);
                    reg[4] = rs.getString(5);
                    reg[5] = rs.getString(6);
                    reg[6] = rs.getInt(7);
                    reg[7] = rs.getString(8);
                    reg[8] = rs.getString(9);
                    reg[9] = rs.getInt(10);
                    reg[10] = rs.getString(11);

                    if (rs.getBoolean(12)) {
                        reg[11] = "Activo";
                    } else {
                        reg[11] = "Inactivo";
                    }
                    reg[12] = rs.getString(13);

                    lstUser.add(reg);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return lstUser;
    }

    @Override
    public List<Usuarios> lst_Usuarios_2() {
        List<Usuarios> list = new ArrayList<Usuarios>();
        Usuarios usuarios = null;
        sql.append("SELECT ")
                .append("user_id,")
                .append("nvel_id,")
                .append("user_nombres,")
                .append("user_apellidos,")
                .append("user_codigo,")
                .append("user_password,")
                .append("user_fecha_nacimiento,")
                .append("user_dni,")
                .append("user_fecha_ingreso,")
                .append("user_fecha_salida,")
                .append("Role_id,")
                .append("user_estado,")
                .append("user_timestamp ")
                .append("FROM usuarios;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    usuarios = new Usuarios();
                    usuarios.setUser_id(rs.getInt(1));
                    usuarios.setNvel_id(rs.getInt(2));
                    usuarios.setUser_nombres(rs.getString(3));
                    usuarios.setUser_apellidos(rs.getString(4));
                    usuarios.setUser_codigo(rs.getString(5));
                    usuarios.setUser_password(rs.getString(6));
                    usuarios.setUser_fecha_nacimiento(rs.getString(7));
                    usuarios.setUser_dni(rs.getInt(8));
                    usuarios.setUser_fecha_ingreso(rs.getString(9));
                    usuarios.setUser_fecha_salida(rs.getString(10));
                    usuarios.setRole_id(rs.getInt(11));
                    usuarios.setUser_estado(rs.getBoolean(12));
                    usuarios.setUser_timestamp(rs.getString(13));

                    list.add(usuarios);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public List<Usuarios> lst_Usuarios_2_1() {
        List<Usuarios> list = new ArrayList<Usuarios>();
        Usuarios usuarios = null;
        sql.append("SELECT ")
                .append("user_id,")
                .append("nvel_id,")
                .append("user_nombres,")
                .append("user_apellidos,")
                .append("user_codigo,")
                .append("user_password,")
                .append("user_fecha_nacimiento,")
                .append("user_dni,")
                .append("user_fecha_ingreso,")
                .append("user_fecha_salida,")
                .append("role_id,")
                .append("user_estado,")
                .append("user_timestamp ")
                .append("FROM usuarios ")
                .append("WHERE role_id = '2' ")
                .append("AND user_estado = 1;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    usuarios = new Usuarios();
                    usuarios.setUser_id(rs.getInt(1));
                    usuarios.setNvel_id(rs.getInt(2));
                    usuarios.setUser_nombres(rs.getString(3));
                    usuarios.setUser_apellidos(rs.getString(4));
                    usuarios.setUser_codigo(rs.getString(5));
                    usuarios.setUser_password(rs.getString(6));
                    usuarios.setUser_fecha_nacimiento(rs.getString(7));
                    usuarios.setUser_dni(rs.getInt(8));
                    usuarios.setUser_fecha_ingreso(rs.getString(9));
                    usuarios.setUser_fecha_salida(rs.getString(10));
                    usuarios.setRole_id(rs.getInt(11));
                    usuarios.setUser_estado(rs.getBoolean(12));
                    usuarios.setUser_timestamp(rs.getString(13));

                    list.add(usuarios);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public Usuarios fnd_Usuarios(String cod) {
        Usuarios usuarios = null;
        sql.append("SELECT ")
                .append("user_id,")
                .append("nvel_id,")
                .append("user_nombres,")
                .append("user_apellidos,")
                .append("user_codigo,")
                .append("user_password,")
                .append("user_fecha_nacimiento,")
                .append("user_dni,")
                .append("user_fecha_ingreso,")
                .append("user_fecha_salida,")
                .append("role_id,")
                .append("user_estado,")
                .append("user_timestamp ")
                .append("FROM usuarios ")
                .append("WHERE user_codigo = ?");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {

            ps.setString(1, cod);

            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuarios = new Usuarios();
                    usuarios.setUser_id(rs.getInt(1));
                    usuarios.setNvel_id(rs.getInt(2));
                    usuarios.setUser_nombres(rs.getString(3));
                    usuarios.setUser_apellidos(rs.getString(4));
                    usuarios.setUser_codigo(rs.getString(5));
                    usuarios.setUser_password(rs.getString(6));
                    usuarios.setUser_fecha_nacimiento(rs.getString(7));
                    usuarios.setUser_dni(rs.getInt(8));
                    usuarios.setUser_fecha_ingreso(rs.getString(9));
                    usuarios.setUser_fecha_salida(rs.getString(10));
                    usuarios.setRole_id(rs.getInt(11));
                    usuarios.setUser_estado(rs.getBoolean(12));
                    usuarios.setUser_timestamp(rs.getString(13));
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return usuarios;
    }
}
