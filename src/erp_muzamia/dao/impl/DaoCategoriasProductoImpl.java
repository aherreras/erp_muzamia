/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp_muzamia.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import erp_muzamia.dto.CategoriasProducto;
import erp_muzamia.sql.ConectaDb;
import erp_muzamia.dao.DaoCategoriasProducto;
import java.util.LinkedList;

/**
 *
 * @author User
 */
public class DaoCategoriasProductoImpl implements DaoCategoriasProducto {

    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public DaoCategoriasProductoImpl() {
        db = new ConectaDb();
        this.sql = new StringBuilder();
    }

    @Override
    public String ins_CategoriasProducto(CategoriasProducto categoriasProducto) {
        String sp = "{call sp_insCategoriasProducto(?,?)}";

        try ( Connection cn = db.getConnection();  CallableStatement cs = cn.prepareCall(sp)) {

            cs.setString(1, categoriasProducto.getCpro_descripcion());
            cs.setBoolean(2, categoriasProducto.isCpro_estado());

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
    public String upd_CategoriasProducto(CategoriasProducto categoriasProducto) {
        String sp = "{call sp_updCategoriasProducto(?,?,?)}";

        try ( Connection cn = db.getConnection();  CallableStatement cs = cn.prepareCall(sp)) {

            cs.setInt(1, categoriasProducto.getCpro_id());
            cs.setString(2, categoriasProducto.getCpro_descripcion());
            cs.setBoolean(3, categoriasProducto.isCpro_estado());

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
    public List<Object[]> lst_CategoriasProducto_1() {
        List<Object[]> list = null;
        sql.append("SELECT ")
                .append("cpro_id,")
                .append("cpro_descripcion,")
                .append("cpro_estado,")
                .append("cpro_timestamp ")
                .append("FROM categorias_producto;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] reg = new Object[4];

                    reg[0] = rs.getInt(1);
                    reg[1] = rs.getString(2);
                    reg[2] = rs.getBoolean(3);
                    reg[3] = rs.getString(4);

                    list.add(reg);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public List<CategoriasProducto> lst_CategoriasProducto_2() {
        List<CategoriasProducto> list = new ArrayList<CategoriasProducto>();
        CategoriasProducto cateProductos = null;
        sql.append("SELECT ")
                .append("cpro_id,")
                .append("cpro_descripcion,")
                .append("cpro_estado,")
                .append("cpro_timestamp ")
                .append("FROM categorias_producto;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    cateProductos = new CategoriasProducto();

                    cateProductos.setCpro_id(rs.getInt(1));
                    cateProductos.setCpro_descripcion(rs.getString(2));
                    cateProductos.setCpro_estado(rs.getBoolean(3));
                    cateProductos.setCpro_timestamp(rs.getString(4));

                    list.add(cateProductos);

                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }
    
    @Override
    public List<CategoriasProducto> lst_CategoriasProducto_2_1() {
        List<CategoriasProducto> list = new ArrayList<CategoriasProducto>();
        CategoriasProducto cateProductos = null;
        sql.append("SELECT ")
                .append("cpro_id,")
                .append("cpro_descripcion ")
                .append("cpro_estado,")
                .append("cpro_timestamp ")
                .append("FROM categorias_producto ")
                .append("WHERE cpro_estado = 1;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    cateProductos = new CategoriasProducto();

                    cateProductos.setCpro_id(rs.getInt(1));
                    cateProductos.setCpro_descripcion(rs.getString(2));
                    cateProductos.setCpro_estado(rs.getBoolean(3));
                    cateProductos.setCpro_timestamp(rs.getString(4));

                    list.add(cateProductos);

                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }
}
