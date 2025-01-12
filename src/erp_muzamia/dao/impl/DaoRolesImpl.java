/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp_muzamia.dao.impl;

import erp_muzamia.dao.DaoRoles;
import erp_muzamia.dto.Roles;
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
public class DaoRolesImpl implements DaoRoles {

    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public DaoRolesImpl() {
        db = new ConectaDb();
        this.sql = new StringBuilder();
    }

    @Override
    public String ins_Roles(Roles roles) {
        String sp = "{call sp_insRoles(?,?)}";

        try ( Connection cn = db.getConnection();  CallableStatement cs = cn.prepareCall(sp)) {

            cs.setString(1, roles.getRole_nombre());
            cs.setBoolean(2, roles.isRole_estado());

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
    public String upd_Roles(Roles roles) {
        String sp = "{call sp_updRoles(?,?,?)}";
        Integer id = roles.getRole_id();

        try ( Connection cn = db.getConnection();  CallableStatement cs = cn.prepareCall(sp)) {

            if (id == null) {
                cs.setNull(1, Types.INTEGER);
            } else {
                cs.setInt(1, id);
            }
            
            cs.setString(2, roles.getRole_nombre());
            cs.setBoolean(3, roles.isRole_estado());

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
    public List<Object[]> lst_Roles_1() {
        List<Object[]> list = null;
        sql.append("SELECT ")
                .append("role_id,")
                .append("role_nombre,")
                .append("role_estado,")
                .append("role_timestamp ")
                .append("FROM roles;");

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
    public List<Roles> lst_Roles_2() {
        List<Roles> list = null;
        Roles rl = null;
        sql.append("SELECT ")
                .append("role_id,")
                .append("role_nombre,")
                .append("role_estado,")
                .append("role_timestamp ")
                .append("FROM roles;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();
            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    rl = new Roles();
                    
                    rl.setRole_id(rs.getInt(1));
                    rl.setRole_nombre(rs.getString(2));
                    rl.setRole_estado(rs.getBoolean(3));
                    rl.setRole_timestamp(rs.getString(4));

                    list.add(rl);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }
}
