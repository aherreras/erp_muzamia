/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp_muzamia.dao.impl;

import erp_muzamia.dao.DaoVenta;
import erp_muzamia.dto.DetOperacionVenta;
import erp_muzamia.dto.DetVenta;
import erp_muzamia.sql.ConectaDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author User
 */
public class DaoVentaImpl implements DaoVenta {
    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public DaoVentaImpl() {
        db = new ConectaDb();
        this.sql = new StringBuilder();
    }

    @Override
    public List<DetOperacionVenta> getDetalle(int idOperacion) {
        List<DetOperacionVenta> list = null;
        sql.append("SELECT ")
                .append("dope_id,")
                .append("oper_id,")
                .append("user_id,")
                .append("user_nombres,")
                .append("user_apellidos,")
                .append("serv_id,")
                .append("serv_nombre,")
                .append("dope_precio,")
                .append("dope_cantidad,")
                .append("dope_subtotal,")
                .append("dope_descuento,")
                .append("dope_total,")
                .append("dope_timestamp ")
                .append("FROM vw_ventas_03 ")
                .append("WHERE oper_id = ?;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();

            ps.setInt(1, idOperacion);
            
            DetVenta det = null;
            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    det = new DetVenta(idOperacion);

                    det.setDope_id(rs.getInt(1));
                    det.setUser_id(rs.getInt(3));
                    det.setUser_nombres(rs.getString(4));
                    det.setUser_apellidos(rs.getString(5));
                    det.setServ_id(rs.getInt(6));
                    det.setServ_nombre(rs.getString(7));
                    det.setDope_precio(rs.getDouble(8));
                    det.setDope_cantidad(rs.getInt(9));
                    det.setDope_subtotal(rs.getDouble(10));
                    det.setDope_descuento(rs.getDouble(11));
                    det.setDope_total(rs.getDouble(12));
                    det.setDope_timestamp(rs.getString(13));

                    list.add(det);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }
}
