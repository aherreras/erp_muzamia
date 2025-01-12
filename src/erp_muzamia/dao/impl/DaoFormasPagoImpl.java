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
import erp_muzamia.dto.FormasPago;
import erp_muzamia.sql.ConectaDb;
import erp_muzamia.dao.DaoFormasPago;

/**
 *
 * @author User
 */
public class DaoFormasPagoImpl implements DaoFormasPago {

    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public DaoFormasPagoImpl() {
        db = new ConectaDb();
        this.sql = new StringBuilder();
    }
    @Override
    public String ins_FormasPago(FormasPago metodosPago) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String upd_FormasPago(FormasPago metodosPago) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Object[]> lst_FormasPago_1() {
        List<Object[]> list = null;
        sql.append("SELECT ")
                .append("mpag_id,")
                .append("mpag_descripcion,")
                .append("mpag_comision,")
                .append("mpag_estado ")
                .append("FROM METODO_PAGO ")
                .append("WHERE mpag_estado = true;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();
            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] reg = new Object[4];

                    reg[0] = rs.getInt(1);
                    reg[1] = rs.getString(2);
                    reg[2] = rs.getDouble(3);
                    reg[3] = rs.getBoolean(4);

                    list.add(reg);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public List<FormasPago> lst_FormasPago_2() {
        List<FormasPago> list = null;
        FormasPago metodoPago = null;
        sql.append("SELECT ")
                .append("mpag_id,")
                .append("mpag_descripcion,")
                .append("mpag_comision,")
                .append("mpag_estado ")
                .append("FROM METODO_PAGO ")
                .append("WHERE mpag_estado = true;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    metodoPago = new FormasPago();

                    metodoPago.setFpag_id(rs.getInt(1));
                    metodoPago.setFpag_descripcion(rs.getString(2));
                    metodoPago.setFpag_comision(rs.getDouble(3));
                    metodoPago.setFpag_estado(rs.getBoolean(4));

                    list.add(metodoPago);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

}
