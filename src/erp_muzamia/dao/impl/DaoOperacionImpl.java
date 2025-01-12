/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp_muzamia.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Types;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import erp_muzamia.dao.DaoOperacion;
import erp_muzamia.dto.Operaciones;
import erp_muzamia.sql.ConectaDb;

/**
 *
 * @author User
 */
public class DaoOperacionImpl implements DaoOperacion {

    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public DaoOperacionImpl() {
        db = new ConectaDb();
        this.sql = new StringBuilder();
    }

    @Override
    public int ins_Operaciones(Operaciones operacion) {
        String sp = "{?= call fn_insOperacion(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        Integer id = null;

        try ( Connection cn = db.getConnection();  CallableStatement cs = cn.prepareCall(sp)) {

            cn.setAutoCommit(false);

            cs.registerOutParameter(1, Types.INTEGER);
            cs.setInt(2, operacion.getTope_id());
            cs.setInt(3, operacion.getUser_id());

            if (operacion.getTcom_id() > 0) {
                cs.setInt(4, operacion.getTcom_id());
            } else {
                cs.setNull(4, Types.NULL);
            }

            cs.setBoolean(5, operacion.isOper_flag_emit_comp());
            cs.setBoolean(6, operacion.isOper_flag_impr_comp());
            cs.setInt(7, operacion.getFpag_id());
            cs.setInt(8, operacion.getPeri_id());
            cs.setInt(9, operacion.getClie_id());
            cs.setDouble(10, operacion.getOper_monto());
            cs.setDouble(11, operacion.getOper_pagado());
            cs.setDouble(12, operacion.getOper_saldo());

            Date date1 = Date.valueOf(operacion.getOper_fecha());
            cs.setDate(13, date1);

            cs.setInt(14, operacion.getEsta_id());

            cs.execute();
            id = cs.getInt(1);

            if (id == null) {
                cn.rollback();
            } else {
                cn.commit();
            }

            cn.setAutoCommit(true);

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return id;
    }

    @Override
    public String upd_Operaciones(Operaciones operacion) {
        String sp = "{call sp_updOperacion(?,?,?,?,?,?,?,?,?,?,?)}";
        Integer id = null;

        try ( Connection cn = db.getConnection();  CallableStatement cs = cn.prepareCall(sp)) {

            cs.setInt(1, operacion.getOper_id());
            cs.setInt(2, operacion.getTope_id());
            cs.setInt(3, operacion.getUser_id());

            if (operacion.getTcom_id() > 0) {
                cs.setInt(4, operacion.getTcom_id());
            } else {
                cs.setNull(4, Types.NULL);
            }

            cs.setBoolean(5, operacion.isOper_flag_emit_comp());
            cs.setBoolean(6, operacion.isOper_flag_impr_comp());
            cs.setInt(7, operacion.getFpag_id());
            cs.setInt(8, operacion.getPeri_id());
            cs.setDouble(9, operacion.getOper_monto());

            Date date1 = Date.valueOf(operacion.getOper_fecha());
            cs.setDate(10, date1);

            cs.setInt(11, operacion.getEsta_id());

            int ctos = cs.executeUpdate();
            if (ctos == 0) {
                throw new SQLException("0 filas afectadas");
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return message;
    }

//    @Override
    public Object[] get_Operacion_1(int idOperacion) {
        Object[] obj = null;
        sql.append("SELECT ")
                .append("oper_id,")
                .append("o.tope_id,")
                .append("tope_descripcion,")
                .append("o.mpag_id,")
                .append("mpag_descripcion,")
                .append("caja_id,")
                .append("o.clie_id,")
                .append("clie_nombres,")
                .append("o.user_id,")
                .append("user_nombres,")
                .append("prov_id,")
                .append("oper_timestamp,")
                .append("oper_monto,")
                .append("oper_pagado,")
                .append("oper_vuelto,")
                .append("oper_cobrado,")
                .append("oper_saldo,")
                .append("oper_fecha ")
                .append("FROM OPERACION o ")
                .append("INNER JOIN TIPO_OPERACION t ")
                .append("ON o.tope_id = t.tope_id ")
                .append("INNER JOIN METODO_PAGO m ")
                .append("ON o.mpag_id = m.mpag_id ")
                .append("INNER JOIN CLIENTES c ")
                .append("ON o.clie_id = c.clie_id ")
                .append("INNER JOIN USUARIOS u ")
                .append("ON o.user_id = u.user_id ")
                .append("WHERE oper_id = ?");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {

            ps.setInt(1, idOperacion);

            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    obj = new Object[18];

                    obj[0] = rs.getInt(1);
                    obj[1] = rs.getInt(2);
                    obj[2] = rs.getString(3);
                    obj[3] = rs.getInt(4);
                    obj[4] = rs.getString(5);
                    obj[5] = rs.getInt(6);
                    obj[6] = rs.getInt(7);
                    obj[7] = rs.getString(8);
                    obj[8] = rs.getInt(9);
                    obj[9] = rs.getString(10);
                    obj[10] = rs.getInt(11);
                    obj[11] = rs.getString(12);
                    obj[12] = rs.getDouble(13);
                    obj[13] = rs.getDouble(14);
                    obj[14] = rs.getDouble(15);
                    obj[15] = rs.getDouble(16);
                    obj[16] = rs.getDouble(17);
                    obj[17] = rs.getString(18);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return obj;
    }

//    @Override
    public Object[] get_Operacion_2(int idOperacion) {
        Object[] obj = null;
        sql.append("SELECT ")
                .append("mpag_id,")
                .append("o.clie_id,")
                .append("clie_nombres,")
                .append("clie_apellidos,")
                .append("clie_dni,")
                .append("oper_monto,")
                .append("oper_pagado,")
                .append("oper_fecha ")
                .append("FROM OPERACION o ")
                .append("INNER JOIN CLIENTES c ")
                .append("ON o.clie_id = c.clie_id ")
                .append("WHERE oper_id = ?");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {

            ps.setInt(1, idOperacion);

            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    obj = new Object[8];

                    obj[0] = rs.getInt(1);
                    obj[1] = rs.getInt(2);
                    obj[2] = rs.getString(3);
                    obj[3] = rs.getString(4);
                    obj[4] = rs.getInt(5);
                    obj[5] = rs.getDouble(6);
                    obj[6] = rs.getDouble(7);
                    obj[7] = rs.getString(8);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return obj;
    }

    public List<Object[]> listarOperaciones(String fecIni, String fecFin) {
        List<Object[]> list = null;
        int num = 1;
        sql.append("SELECT ")
                .append("oper_id,")
                .append("o.tope_id,")
                .append("tope_descripcion,")
                .append("o.mpag_id,")
                .append("mpag_descripcion,")
                .append("o.clie_id,")
                .append("clie_nombres,")
                .append("o.prov_id,")
                .append("prov_razon_social,")
                .append("oper_timestamp,")
                .append("oper_monto,")
                .append("oper_pagado,")
                .append("oper_vuelto,")
                .append("oper_cobrado,")
                .append("oper_saldo,")
                .append("oper_fecha ")
                .append("FROM OPERACION o ")
                .append("INNER JOIN TIPO_OPERACION t ")
                .append("ON o.tope_id = t.tope_id ")
                .append("INNER JOIN METODO_PAGO m ")
                .append("ON o.mpag_id = m.mpag_id ")
                .append("LEFT JOIN CLIENTES c ")
                .append("ON o.clie_id = c.clie_id ")
                .append("LEFT JOIN PROVEEDORES p ")
                .append("ON o.prov_id = p.prov_id ")
                .append("WHERE oper_fecha BETWEEN ")
                .append("? and ? ")
                .append("ORDER BY oper_fecha ASC;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();

            ps.setString(1, fecIni);
            ps.setString(2, fecFin);

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] reg = new Object[17];

                    reg[0] = num;
                    reg[1] = rs.getInt(1);
                    reg[2] = rs.getInt(2);
                    reg[3] = rs.getString(3);
                    reg[4] = rs.getInt(4);
                    reg[5] = rs.getString(5);
                    reg[6] = rs.getInt(6);
                    reg[7] = rs.getString(7);
                    reg[8] = rs.getInt(8);
                    reg[9] = rs.getString(9);
                    reg[10] = rs.getString(10);
                    reg[11] = rs.getDouble(11);
                    reg[12] = rs.getDouble(12);
                    reg[13] = rs.getDouble(13);
                    reg[14] = rs.getDouble(14);
                    reg[15] = rs.getDouble(15);
                    reg[16] = rs.getString(16);

                    list.add(reg);
                    num++;
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public List<Object[]> lst_Operaciones_1() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Object[]> lst_Operaciones_1_1() {
        List<Object[]> list = null;
        sql.append("SELECT ")
                .append("oper_id,")
                .append("tope_id,")
                .append("tope_descripcion,")
                .append("user_id,")
                .append("user_nombres,")
                .append("tcom_id,")
                .append("tcom_descripcion,")
                .append("oper_flag_emit_comp,")
                .append("oper_flag_impr_comp,")
                .append("fpag_id,")
                .append("fpag_descripcion,")
                .append("peri_id,")
                .append("peri_descripcion,")
                .append("clie_id,")
                .append("clie_nombres,")
                .append("oper_monto,")
                .append("oper_pagado,")
                .append("oper_saldo,")
                .append("oper_fecha,")
                .append("esta_id,")
                .append("esta_descripcion,")
                .append("oper_timestamp ")
                .append("FROM vw_operaciones_01 ")
                .append("WHERE tope_id = 1;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] reg = new Object[22];

                    reg[0] = rs.getInt(1);
                    reg[1] = rs.getInt(2);
                    reg[2] = rs.getString(3);
                    reg[3] = rs.getInt(4);
                    reg[4] = rs.getString(5);
                    reg[5] = rs.getInt(6);
                    reg[6] = rs.getString(7);
                    reg[7] = rs.getBoolean(8);
                    reg[8] = rs.getBoolean(9);
                    reg[9] = rs.getInt(10);
                    reg[10] = rs.getString(11);
                    reg[11] = rs.getInt(12);
                    reg[12] = rs.getString(13);
                    reg[13] = rs.getInt(14);
                    reg[14] = rs.getString(15);
                    reg[15] = rs.getDouble(16);
                    reg[16] = rs.getDouble(17);
                    reg[17] = rs.getDouble(18);
                    reg[18] = rs.getString(19);
                    reg[19] = rs.getInt(20);
                    reg[20] = rs.getString(21);
                    reg[21] = rs.getString(22);

                    list.add(reg);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public List<Operaciones> lst_Operaciones_2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Operaciones> lst_Operaciones_flt_1(String fecIni, String fecFin) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object[] get_Operaciones_1(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Operaciones get_Operaciones_2(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
