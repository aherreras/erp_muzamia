/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp_muzamia.dao.impl;

import erp_muzamia.dao.DaoReportes;
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
public class DaoReportesImpl implements DaoReportes {

    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public DaoReportesImpl() {
        db = new ConectaDb();
        this.sql = new StringBuilder();
    }
    
    @Override
    public List<Object[]> reporte_1() {
        List<Object[]> list = null;
        sql.append("SELECT ")
                .append("user_id,")
                .append("user_nombres,")
                .append("user_apellidos,")
                .append("total,")
                .append("peri_descripcion ")
                .append("FROM vw_reporte_01;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] reg = new Object[5];

                    reg[0] = rs.getInt(1);
                    reg[1] = rs.getString(2);
                    reg[2] = rs.getString(3);
                    reg[3] = rs.getDouble(4);
                    reg[4] = rs.getString(5);

                    list.add(reg);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public List<Object[]> reporte_2() {
        List<Object[]> list = null;
        sql.append("SELECT ")
                .append("peri_id,")
                .append("peri_descripcion,")
                .append("total ")
                .append("FROM vw_reporte_02;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] reg = new Object[3];

                    reg[0] = rs.getInt(1);
                    reg[1] = rs.getString(2);
                    reg[2] = rs.getDouble(3);

                    list.add(reg);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public List<Object[]> reporte_3() {
        List<Object[]> list = null;
        sql.append("SELECT ")
                .append("cont,")
                .append("clie_id,")
                .append("clie_nombres,")
                .append("clie_apellidos ")
                .append("FROM vw_reporte_03;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] reg = new Object[4];

                    reg[0] = rs.getInt(1);
                    reg[1] = rs.getInt(2);
                    reg[2] = rs.getString(3);
                    reg[3] = rs.getString(4);

                    list.add(reg);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

}
