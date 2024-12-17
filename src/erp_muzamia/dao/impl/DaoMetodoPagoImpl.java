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
import erp_muzamia.dao.DaoMetodoPago;
import erp_muzamia.dto.MetodoPago;
import erp_muzamia.sql.ConectaDb;

/**
 *
 * @author User
 */
public class DaoMetodoPagoImpl implements DaoMetodoPago {

    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public DaoMetodoPagoImpl() {
        db = new ConectaDb();
        this.sql = new StringBuilder();
    }

    @Override
    public List<Object[]> lstMetodosPago() {
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
    public List<MetodoPago> lstMetodosPago_2() {
        List<MetodoPago> list = null;
        MetodoPago metodoPago = null;
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
                    metodoPago = new MetodoPago();

                    metodoPago.setMpag_id(rs.getInt(1));
                    metodoPago.setMpag_descripcion(rs.getString(2));
                    metodoPago.setMpag_comision(rs.getDouble(3));
                    metodoPago.setMpag_estado(rs.getBoolean(4));

                    list.add(metodoPago);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }
}
