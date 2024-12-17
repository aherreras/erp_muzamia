/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp_muzamia.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import erp_muzamia.dao.DaoCateProductos;
import erp_muzamia.dto.CateProductos;
import erp_muzamia.sql.ConectaDb;

/**
 *
 * @author User
 */
public class DaoCateProductosImpl implements DaoCateProductos{

    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public DaoCateProductosImpl() {
        db = new ConectaDb();
        this.sql = new StringBuilder();
    }

    @Override
    public List<CateProductos> listarCateProductos() {
        List<CateProductos> list= new ArrayList<CateProductos>();
        CateProductos cateProductos = null;
        sql.append("SELECT ")
                .append("cpro_id,")
                .append("cpro_descripcion ")
                .append("FROM CATEGORIA_PRODUCTOS ");

        try (Connection cn = db.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql.toString())) {

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    cateProductos = new CateProductos();

                    cateProductos.setCpro_id(rs.getInt(1));
                    cateProductos.setCpro_descripcion(rs.getString(2));
                    
                    list.add(cateProductos);

                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }
    
}
