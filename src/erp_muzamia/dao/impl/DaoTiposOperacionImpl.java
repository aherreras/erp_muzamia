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
import erp_muzamia.dto.TiposOperacion;
import erp_muzamia.sql.ConectaDb;
import erp_muzamia.dao.DaoTiposOperacion;

/**
 *
 * @author User
 */
public class DaoTiposOperacionImpl implements DaoTiposOperacion {

    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public DaoTiposOperacionImpl() {
        db = new ConectaDb();
        this.sql = new StringBuilder();
    }

    @Override
    public String ins_TiposOperacion(TiposOperacion tiposOperacion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String upd_TiposOperacion(TiposOperacion tiposOperacion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Object[]> lst_TiposOperacion_1() {
        List<Object[]> list = null;
        sql.append("SELECT ")
                .append("tope_id,")
                .append("tope_descripcion,")
                .append("tope_estado,")
                .append("tope_timestamp ")
                .append("FROM tipos_operacion;");

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
    public List<TiposOperacion> lst_TiposOperacion_2() {
        List<TiposOperacion> list = null;
        TiposOperacion tiposOperacion = null;
        sql.append("SELECT ")
                .append("tope_id,")
                .append("tope_descripcion,")
                .append("tope_estado,")
                .append("tope_timestamp ")
                .append("FROM tipos_operacion;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    tiposOperacion = new TiposOperacion();

                    tiposOperacion.setTope_id(rs.getInt(1));
                    tiposOperacion.setTope_descripcion(rs.getString(2));
                    tiposOperacion.setTope_estado(rs.getBoolean(3));
                    tiposOperacion.setTope_timestamp(rs.getString(4));

                    list.add(tiposOperacion);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }
    
}
