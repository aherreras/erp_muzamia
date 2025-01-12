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
import erp_muzamia.dto.Periodos;
import erp_muzamia.sql.ConectaDb;
import java.util.ArrayList;
import erp_muzamia.dao.DaoPeriodos;

/**
 *
 * @author User
 */
public class DaoPeriodosImpl implements DaoPeriodos {

    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public DaoPeriodosImpl() {
        db = new ConectaDb();
        this.sql = new StringBuilder();
    }

    @Override
    public List<Object[]> lst_Periodos_1() {
        List<Object[]> list = null;
        sql.append("SELECT ")
                .append("peri_id,")
                .append("peri_descripcion,")
                .append("peri_fecha_ini,")
                .append("peri_fecha_fin,")
                .append("peri_total_venta_servicios,")
                .append("peri_total_venta_productos,")
                .append("peri_total_ingresos,")
                .append("peri_total_costo_local_alqu,")
                .append("peri_total_costo_fijo,")
                .append("peri_total_costo_productos,")
                .append("peri_total_costo_local_serv,")
                .append("peri_total_costo_personal,")
                .append("peri_total_costo_variable,")
                .append("peri_total_gastos_publicidad,")
                .append("peri_total_gastos_inversion,")
                .append("peri_total_gastos_otros,")
                .append("peri_total_activos,")
                .append("peri_total_pasivos,")
                .append("peri_total_utilidad,")
                .append("esta_id,")
                .append("peri_fecha_registrado,")                
                .append("peri_fecha_apertura,")
                .append("peri_fecha_anulacion,")                
                .append("peri_fecha_cierre,")
                .append("peri_estado,")
                .append("peri_timestamp ")
                .append("FROM periodos ")
                .append("ORDER BY peri_id ASC");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] reg = new Object[16];

                    reg[0] = rs.getInt(1);
                    reg[1] = rs.getString(2);
                    reg[2] = rs.getString(3);
                    reg[3] = rs.getString(4);
                    reg[4] = rs.getDouble(5);
                    reg[5] = rs.getDouble(6);
                    reg[6] = rs.getDouble(7);
                    reg[7] = rs.getDouble(8);
                    reg[8] = rs.getDouble(9);
                    reg[9] = rs.getDouble(10);
                    reg[10] = rs.getDouble(11);
                    reg[11] = rs.getDouble(12);
                    reg[12] = rs.getDouble(13);
                    reg[13] = rs.getDouble(14);
                    reg[14] = rs.getDouble(15);
                    reg[15] = rs.getDouble(16);
                    reg[16] = rs.getDouble(17);
                    reg[17] = rs.getDouble(18);
                    reg[18] = rs.getDouble(19);
                    reg[19] = rs.getInt(20);
                    reg[20] = rs.getString(21);
                    reg[21] = rs.getString(22);
                    reg[22] = rs.getString(23);
                    reg[23] = rs.getString(24);
                    reg[24] = rs.getBoolean(25);
                    reg[25] = rs.getString(26);

                    list.add(reg);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }
    
    @Override
    public List<Periodos> lst_Periodos_2() {
        List<Periodos> list= null;
        Periodos caja = null;
        sql.append("SELECT ")
                .append("peri_id,")
                .append("peri_descripcion,")
                .append("peri_fecha_ini,")
                .append("peri_fecha_fin,")
                .append("peri_total_venta_servicios,")
                .append("peri_total_venta_productos,")
                .append("peri_total_ingresos,")
                .append("peri_total_costo_local_alqu,")
                .append("peri_total_costo_fijo,")
                .append("peri_total_costo_productos,")
                .append("peri_total_costo_local_serv,")
                .append("peri_total_costo_personal,")
                .append("peri_total_costo_variable,")
                .append("peri_total_gastos_publicidad,")
                .append("peri_total_gastos_inversion,")
                .append("peri_total_gastos_otros,")
                .append("peri_total_activos,")
                .append("peri_total_pasivos,")
                .append("peri_total_utilidad,")
                .append("esta_id,")
                .append("peri_fecha_registrado,")                
                .append("peri_fecha_apertura,")
                .append("peri_fecha_anulacion,")                
                .append("peri_fecha_cierre,")
                .append("peri_estado,")
                .append("peri_timestamp ")
                .append("FROM periodos ")
                .append("ORDER BY peri_id ASC");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    caja = new Periodos();

                    caja.setPeri_id(rs.getInt(1));
                    caja.setPeri_descripcion(rs.getString(2));
//                    caja.setPeri_fecha_ini(rs.getDouble(3));
//                    caja.setPeri_fecha_fin(rs.getDouble(4));
//                    caja.setPeri_total_cobrado(rs.getDouble(5));
//                    caja.setPeri_total_gasto(rs.getDouble(6));
//                    caja.setPeri_total_retirado(rs.getDouble(7));
//                    caja.setPeri_total_ingresado(rs.getDouble(8));
                    caja.setPeri_fecha_ini(rs.getString(9));
                    caja.setPeri_fecha_fin(rs.getString(10));
                    caja.setPeri_estado(rs.getBoolean(11));

                    list.add(caja);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public List<Object[]> lst_Periodos_1_1(List<Integer> ids) {
        List<Object[]> list = null;
        String strIds = "";
        for (Integer id : ids) {
            strIds += id + ",";
        }
        sql.append("SELECT ")
                .append("peri_id,")
                .append("peri_descripcion,")
                .append("peri_total_cierre,")
                .append("peri_saldo_anterior,")
                .append("peri_total_cobrado,")
                .append("peri_total_gasto,")
                .append("peri_total_retirado,")
                .append("peri_total_ingresado,")
                .append("peri_fecha_ini,")
                .append("peri_fecha_fin,")
                .append("peri_estado ")
                .append("FROM CAJA ")
                .append("WHERE peri_id in (" + strIds.substring(0, strIds.length() - 1) + ") ")
                .append("ORDER BY peri_id ASC");

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
    public Periodos fnd_Periodos_2(int id) {
        Periodos cj = null;
        sql.append("SELECT ")
                .append("peri_id,")
                .append("peri_descripcion,")
                .append("peri_total_cierre,")
                .append("peri_saldo_anterior,")
                .append("peri_total_cobrado,")
                .append("peri_total_gasto,")
                .append("peri_total_retirado,")
                .append("peri_total_ingresado,")
                .append("peri_fecha_ini,")
                .append("peri_fecha_fin,")
                .append("peri_estado ")
                .append("FROM CAJA ")
                .append("WHERE peri_id = " + id);

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {

            ps.setInt(1, id);

            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {

                    cj = new Periodos();

                    cj.setPeri_id(rs.getInt(1));
                    cj.setPeri_descripcion(rs.getString(2));
//                    cj.setPeri_total_cierre(rs.getDouble(3));
//                    cj.setPeri_saldo_anterior(rs.getDouble(4));
//                    cj.setPeri_total_cobrado(rs.getDouble(5));
//                    cj.setPeri_total_gasto(rs.getDouble(6));
//                    cj.setPeri_total_retirado(rs.getDouble(7));
//                    cj.setPeri_total_ingresado(rs.getDouble(8));
                    cj.setPeri_fecha_ini(rs.getString(9));
                    cj.setPeri_fecha_fin(rs.getString(10));
                    cj.setPeri_estado(rs.getBoolean(11));
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return cj;
    }

    @Override
    public String ins_Periodos(Periodos periodos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String upd_Periodos(Periodos periodos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object[] fnd_Periodos_1(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
