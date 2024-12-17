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
import erp_muzamia.dao.DaoProveedores;
import erp_muzamia.dto.Proveedores;
import erp_muzamia.sql.ConectaDb;
import java.sql.CallableStatement;

/**
 *
 * @author User
 */
public class DaoProveedoresImpl implements DaoProveedores {

    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public DaoProveedoresImpl() {
        db = new ConectaDb();
        this.sql = new StringBuilder();
    }

    @Override
    public List<Object[]> listaProveedores() {
        List<Object[]> list = null;
        sql.append("SELECT ")
                .append("prov_id,")
                .append("prov_razon_social,")
                .append("prov_ruc,")
                .append("prov_estado ")
                .append("FROM PROVEEDORES ")
                .append("WHERE prov_estado = true;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();
            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] reg = new Object[4];

                    reg[0] = rs.getInt(1);
                    reg[1] = rs.getString(2);
                    reg[2] = rs.getString(3);
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
    public String registrarProveedor(Proveedores proveedor) {
        String sp = "{call sp_insProveedor(?,?,?,?,?,?)}";

        try (Connection cn = db.getConnection(); CallableStatement cs = cn.prepareCall(sp)) {

            cs.setString(1, proveedor.getProv_razon_social());
            cs.setString(2, proveedor.getProv_ruc());
            cs.setString(3, proveedor.getProv_direccion());
            cs.setString(4, proveedor.getProv_celular());
            cs.setString(5, proveedor.getProv_fec_ingreso());
            cs.setBoolean(6, proveedor.isProv_estado());

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
    public String modificarProveedor(Proveedores proveedor) {
        String sp = "{call sp_updProveedor(?,?,?,?,?,?,?)}";

        try (Connection cn = db.getConnection(); CallableStatement cs = cn.prepareCall(sp)) {

            cs.setInt(1, proveedor.getProv_id());
            cs.setString(2, proveedor.getProv_razon_social());
            cs.setString(3, proveedor.getProv_ruc());
            cs.setString(4, proveedor.getProv_direccion());
            cs.setString(5, proveedor.getProv_celular());
            cs.setString(6, proveedor.getProv_fec_ingreso());
            cs.setBoolean(7, proveedor.isProv_estado());

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
    public List<Proveedores> lstProveedores() {
        List<Proveedores> list = null;
        Proveedores pv = null;
        sql.append("SELECT ")
                .append("prov_id,")
                .append("prov_razon_social,")
                .append("prov_ruc,")
                .append("prov_direccion,")
                .append("prov_celular,")
                .append("prov_fec_ingreso,")
                .append("prov_estado,")
                .append("prov_timestamp ")
                .append("FROM proveedores ")
                .append("ORDER BY prov_id;");

        try (Connection cn = db.getConnection(); PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    pv = new Proveedores();

                    pv.setProv_id(rs.getInt(1));
                    pv.setProv_razon_social(rs.getString(2));
                    pv.setProv_ruc(rs.getString(3));
                    pv.setProv_direccion(rs.getString(4));
                    pv.setProv_celular(rs.getString(5));
                    pv.setProv_fec_ingreso(rs.getString(6));
                    pv.setProv_estado(rs.getBoolean(7));
                    pv.setProv_timestamp(rs.getTimestamp(8).toString());

                    list.add(pv);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }
}
