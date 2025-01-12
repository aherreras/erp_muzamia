/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp_muzamia.dao.impl;

import erp_muzamia.dao.DaoNiveles;
import erp_muzamia.dto.Niveles;
import erp_muzamia.sql.ConectaDb;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author User
 */
public class DaoNivelesImpl implements DaoNiveles {

    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public DaoNivelesImpl() {
        db = new ConectaDb();
        this.sql = new StringBuilder();
    }

    @Override
    public String ins_Niveles(Niveles niveles) {
        String sp = "{call sp_insNiveles(?,?,?,?,?,?,?)}";

        try ( Connection cn = db.getConnection();  CallableStatement cs = cn.prepareCall(sp)) {

            cs.setString(1, niveles.getNvel_codigo());
            cs.setString(2, niveles.getNvel_categoria());
            cs.setString(3, niveles.getNvel_descripcion());
            cs.setDouble(4, niveles.getNvel_base());
            cs.setDouble(5, niveles.getNvel_comision());
            cs.setDouble(6, niveles.getNvel_bonif());            
            cs.setBoolean(7, niveles.isNvel_estado());

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
    public String upd_Niveles(Niveles niveles) {
        String sp = "{call sp_updNiveles(?,?,?,?,?,?,?,?)}";
        Integer id = niveles.getNvel_id();

        try ( Connection cn = db.getConnection();  CallableStatement cs = cn.prepareCall(sp)) {

            if (id == null) {
                cs.setNull(1, Types.INTEGER);
            } else {
                cs.setInt(1, id);
            }

            cs.setString(2, niveles.getNvel_codigo());
            cs.setString(3, niveles.getNvel_categoria());
            cs.setString(4, niveles.getNvel_descripcion());
            cs.setDouble(5, niveles.getNvel_base());
            cs.setDouble(6, niveles.getNvel_comision());
            cs.setDouble(7, niveles.getNvel_bonif());            
            cs.setBoolean(8, niveles.isNvel_estado());

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
    public List<Object[]> lst_Niveles_1() {
        List<Object[]> list = null;
        sql.append("SELECT ")
                .append("nvel_id,")
                .append("nvel_codigo,")
                .append("nvel_categoria,")
                .append("nvel_descripcion,")
                .append("nvel_base,")
                .append("nvel_comision,")
                .append("nvel_bonif,")
                .append("nvel_estado,")
                .append("nvel_timestamp ")
                .append("FROM niveles;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();
            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] reg = new Object[4];

                    reg[0] = rs.getInt(1);
                    reg[1] = rs.getString(2);
                    reg[2] = rs.getString(3);
                    reg[3] = rs.getString(4);
                    reg[4] = rs.getDouble(5);
                    reg[5] = rs.getDouble(6);
                    reg[6] = rs.getDouble(7);
                    reg[7] = rs.getBoolean(8);
                    reg[8] = rs.getString(9);

                    list.add(reg);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public List<Niveles> lst_Niveles_2() {
        List<Niveles> list = null;
        Niveles nl = null;
        sql.append("SELECT ")
                .append("nvel_id,")
                .append("nvel_codigo,")
                .append("nvel_categoria,")
                .append("nvel_descripcion,")
                .append("nvel_base,")
                .append("nvel_comision,")
                .append("nvel_bonif,")
                .append("nvel_estado,")
                .append("nvel_timestamp ")
                .append("FROM niveles;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();
            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    nl = new Niveles();
                    
                    nl.setNvel_id(rs.getInt(1));
                    nl.setNvel_codigo(rs.getString(2));
                    nl.setNvel_categoria(rs.getString(3));
                    nl.setNvel_descripcion(rs.getString(4));
                    nl.setNvel_base(Double.parseDouble(rs.getString(5)));
                    nl.setNvel_comision(Double.parseDouble(rs.getString(6)));
                    nl.setNvel_bonif(Double.parseDouble(rs.getString(7)));
                    nl.setNvel_estado(rs.getBoolean(8));
                    nl.setNvel_timestamp(rs.getString(9));

                    list.add(nl);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }    
}
