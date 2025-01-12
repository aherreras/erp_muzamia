/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp_muzamia.dao.impl;

import erp_muzamia.dao.DaoVenta;
import erp_muzamia.dto.DetOperacion;
import erp_muzamia.dto.Venta;
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
    public List<DetOperacion> getDetalle(int idOperacion) {
        List<DetOperacion> list = null;
        Venta det = null;
        sql.append("SELECT ")
                .append("dope_id,")
                .append("oper_id,")
                .append("user_id,")
                .append("user_nombres,")
                .append("user_apellidos,")
                .append("serv_id,")
                .append("serv_nombre,")
                .append("prod_id,")
                .append("prod_nombre,")
                .append("dope_precio,")
                .append("dope_cantidad,")
                .append("dope_subtotal,")
                .append("dope_descuento,")
                .append("dope_total,")
                .append("esta_id,")
                .append("esta_descripcion ")
                .append("FROM vw_ventas_01 ")
                .append("WHERE oper_id = ?;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();

            ps.setInt(1, idOperacion);

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    det = new Venta(idOperacion);

                    det.setDope_id(rs.getInt(1));
                    det.setOper_id(rs.getInt(2));
                    det.setUser_id(rs.getInt(3));
                    det.setUser_nombres(rs.getString(4));
                    det.setUser_apellidos(rs.getString(5));
                    det.setServ_id(rs.getInt(6));
                    det.setServ_nombre(rs.getString(7));
                    det.setProd_id(rs.getInt(8));
                    det.setProd_nombre(rs.getString(9));
                    det.setDope_precio(rs.getDouble(10));
                    det.setDope_cantidad(rs.getInt(11));
                    det.setDope_subtotal(rs.getDouble(12));
                    det.setDope_descuento(rs.getDouble(13));
                    det.setDope_total(rs.getDouble(14));
                    det.setEsta_id(rs.getInt(15));
                    det.setEsta_descripcion(rs.getString(16));

                    list.add(det);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }
}
