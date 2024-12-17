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
import erp_muzamia.dao.DaoCaja;
import erp_muzamia.dto.Caja;
import erp_muzamia.sql.ConectaDb;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class DaoCajaImpl implements DaoCaja {

    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public DaoCajaImpl() {
        db = new ConectaDb();
        this.sql = new StringBuilder();
    }

    @Override
    public List<Object[]> lstCajas() {
        List<Object[]> list = null;
        sql.append("SELECT ")
                .append("caja_id,")
                .append("caja_descripcion,")
                .append("caja_total_cierre,")
                .append("caja_saldo_anterior,")
                .append("caja_total_cobrado,")
                .append("caja_total_gasto,")
                .append("caja_total_retirado,")
                .append("caja_total_ingresado,")
                .append("caja_fecha_ini,")
                .append("caja_fecha_fin,")
                .append("caja_estado ")
                .append("FROM CAJA ")
                .append("ORDER BY caja_id ASC");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] reg = new Object[16];

                    reg[0] = rs.getInt(1);
                    reg[1] = rs.getString(2);
                    reg[2] = rs.getDouble(3);
                    reg[3] = rs.getDouble(4);
                    reg[4] = rs.getDouble(5);
                    reg[5] = rs.getDouble(6);
                    reg[6] = rs.getDouble(7);
                    reg[7] = rs.getDouble(8);
                    reg[8] = rs.getString(9);
                    reg[9] = rs.getString(10);
                    reg[10] = rs.getBoolean(11);

                    list.add(reg);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }
    
    @Override
    public List<Caja> lstCajas_2() {
        List<Caja> list= null;
        Caja caja = null;
        sql.append("SELECT ")
                .append("caja_id,")
                .append("caja_descripcion,")
                .append("caja_total_cierre,")
                .append("caja_saldo_anterior,")
                .append("caja_total_cobrado,")
                .append("caja_total_gasto,")
                .append("caja_total_retirado,")
                .append("caja_total_ingresado,")
                .append("caja_fecha_ini,")
                .append("caja_fecha_fin,")
                .append("caja_estado ")
                .append("FROM CAJA ")
                .append("ORDER BY caja_id ASC");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    caja = new Caja();

                    caja.setCaja_id(rs.getInt(1));
                    caja.setCaja_descripcion(rs.getString(2));
                    caja.setCaja_total_cierre(rs.getDouble(3));
                    caja.setCaja_saldo_anterior(rs.getDouble(4));
                    caja.setCaja_total_cobrado(rs.getDouble(5));
                    caja.setCaja_total_gasto(rs.getDouble(6));
                    caja.setCaja_total_retirado(rs.getDouble(7));
                    caja.setCaja_total_ingresado(rs.getDouble(8));
                    caja.setCaja_fecha_ini(rs.getString(9));
                    caja.setCaja_fecha_fin(rs.getString(10));
                    caja.setCaja_estado(rs.getBoolean(11));

                    list.add(caja);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public List<Object[]> listarCajas(List<Integer> ids) {
        List<Object[]> list = null;
        String strIds = "";
        for (Integer id : ids) {
            strIds += id + ",";
        }
        sql.append("SELECT ")
                .append("caja_id,")
                .append("caja_descripcion,")
                .append("caja_total_cierre,")
                .append("caja_saldo_anterior,")
                .append("caja_total_cobrado,")
                .append("caja_total_gasto,")
                .append("caja_total_retirado,")
                .append("caja_total_ingresado,")
                .append("caja_fecha_ini,")
                .append("caja_fecha_fin,")
                .append("caja_estado ")
                .append("FROM CAJA ")
                .append("WHERE caja_id in (" + strIds.substring(0, strIds.length() - 1) + ") ")
                .append("ORDER BY caja_id ASC");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] reg = new Object[16];

                    reg[0] = rs.getInt(1);
                    reg[1] = rs.getString(2);
                    reg[2] = rs.getDouble(3);
                    reg[3] = rs.getDouble(4);
                    reg[4] = rs.getDouble(5);
                    reg[5] = rs.getDouble(6);
                    reg[6] = rs.getDouble(7);
                    reg[7] = rs.getDouble(8);
                    reg[8] = rs.getString(9);
                    reg[9] = rs.getString(10);
                    reg[10] = rs.getBoolean(11);

                    list.add(reg);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public Caja listarCajas(Integer id) {
        Caja cj = null;
        sql.append("SELECT ")
                .append("caja_id,")
                .append("caja_descripcion,")
                .append("caja_total_cierre,")
                .append("caja_saldo_anterior,")
                .append("caja_total_cobrado,")
                .append("caja_total_gasto,")
                .append("caja_total_retirado,")
                .append("caja_total_ingresado,")
                .append("caja_fecha_ini,")
                .append("caja_fecha_fin,")
                .append("caja_estado ")
                .append("FROM CAJA ")
                .append("WHERE caja_id = " + id);

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {

            ps.setInt(1, id);

            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {

                    cj = new Caja();

                    cj.setCaja_id(rs.getInt(1));
                    cj.setCaja_descripcion(rs.getString(2));
                    cj.setCaja_total_cierre(rs.getDouble(3));
                    cj.setCaja_saldo_anterior(rs.getDouble(4));
                    cj.setCaja_total_cobrado(rs.getDouble(5));
                    cj.setCaja_total_gasto(rs.getDouble(6));
                    cj.setCaja_total_retirado(rs.getDouble(7));
                    cj.setCaja_total_ingresado(rs.getDouble(8));
                    cj.setCaja_fecha_ini(rs.getString(9));
                    cj.setCaja_fecha_fin(rs.getString(10));
                    cj.setCaja_estado(rs.getBoolean(11));
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return cj;
    }

}
