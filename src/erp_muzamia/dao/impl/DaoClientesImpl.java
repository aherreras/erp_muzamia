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
import erp_muzamia.dao.DaoClientes;
import erp_muzamia.dto.Clientes;
import erp_muzamia.sql.ConectaDb;
import java.sql.CallableStatement;
import java.sql.Types;

/**
 *
 * @author User
 */
public class DaoClientesImpl implements DaoClientes {

    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public DaoClientesImpl() {
        db = new ConectaDb();
        this.sql = new StringBuilder();
    }

    @Override
    public Clientes getCliente(Integer dni) {
        Clientes clientes = new Clientes();;
        sql.append("SELECT ")
                .append("clie_id,")
                .append("clie_nombres,")
                .append("clie_apellidos,")
                .append("clie_dni,")
                .append("clie_estado ")
                .append("FROM CLIENTES ")
                .append("WHERE clie_dni = ?");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {

            ps.setInt(1, dni);

            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    clientes.setClie_id(rs.getInt(1));
                    clientes.setClie_nombres(rs.getString(2));
                    clientes.setClie_apellidos(rs.getString(3));
                    clientes.setClie_dni(rs.getInt(4));
                    clientes.setClie_estado(rs.getBoolean(5));
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return clientes;
    }

    @Override
    public Integer getID(Integer dni) {
        Integer id = null;
        sql.append("SELECT ")
                .append("clie_id ")
                .append("FROM CLIENTES ")
                .append("WHERE clie_dni = ?");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {

            ps.setInt(1, dni);

            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt(1);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return id;
    }

    @Override
    public List<Object[]> lstClientes() {
        List<Object[]> list = null;
        sql.append("SELECT ")
                .append("clie_id,")
                .append("clie_nombres,")
                .append("clie_apellidos,")
                .append("clie_dni,")
                .append("clie_estado ")
                .append("FROM CLIENTES ")
                .append("WHERE clie_estado = true;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();
            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] reg = new Object[2];

                    reg[0] = rs.getInt(1);
                    reg[1] = rs.getString(2);
//                    reg[2] = rs.getString(3);
//                    reg[3] = rs.getInt(4);
//                    reg[4] = rs.getBoolean(5);

                    list.add(reg);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public List<Clientes> lstClientes_2() {
        List<Clientes> list = null;
        Clientes cl = null;
        sql.append("SELECT ")
                .append("clie_id,")
                .append("clie_nombres,")
                .append("clie_apellidos,")
                .append("clie_dni,")
                .append("clie_estado,")
                .append("clie_timestamp ")
                .append("FROM CLIENTES;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();
            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    cl = new Clientes();
                    
                    cl.setClie_id(rs.getInt(1));
                    cl.setClie_nombres(rs.getString(2));
                    cl.setClie_apellidos(rs.getString(3));
                    cl.setClie_dni(rs.getInt(4));
                    cl.setClie_estado(rs.getBoolean(5));
                    cl.setClie_timestamp(rs.getTimestamp(6).toString());

                    list.add(cl);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }
    
    @Override
    public List<Clientes> getClientePorNombre(String nombres) {
        List<Clientes> list = null;
        Clientes clientes = null;

        sql.append("SELECT ")
                .append("clie_id,")
                .append("clie_nombres,")
                .append("clie_apellidos,")
                .append("clie_dni,")
                .append("clie_estado,")
                .append("clie_timestamp ")
                .append("FROM CLIENTES ")
                .append("WHERE clie_nombres like ?;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();

            if (nombres != null) {
                ps.setString(1, nombres);
            } else {
                ps.setNull(1, Types.NULL);
            }

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    clientes = new Clientes();

                    clientes.setClie_id(rs.getInt(1));
                    clientes.setClie_nombres(rs.getString(2));
                    clientes.setClie_apellidos(rs.getString(3));
                    clientes.setClie_dni(rs.getInt(4));
                    clientes.setClie_estado(rs.getBoolean(5));
                    clientes.setClie_timestamp(rs.getString(6));

                    list.add(clientes);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public String insCliente(Clientes clientes) {
        String sp = "{call sp_InsertCliente(?,?,?,?)}";
        Integer dni = clientes.getClie_dni();

        try ( Connection cn = db.getConnection();  CallableStatement cs = cn.prepareCall(sp)) {

            cs.setString(1, clientes.getClie_nombres());
            cs.setString(2, clientes.getClie_apellidos());
            
            if (dni == null) {
                cs.setNull(3, Types.INTEGER);
            } else {
                cs.setInt(3, dni);
            }
            
            cs.setBoolean(4, clientes.getClie_estado());

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
    public String updCliente(Clientes clientes) {
        String sp = "{call sp_UpdateCliente(?,?,?,?,?)}";
        Integer id = clientes.getClie_id();
        Integer dni = clientes.getClie_dni();

        try ( Connection cn = db.getConnection();  CallableStatement cs = cn.prepareCall(sp)) {

            if (id == null) {
                cs.setNull(1, Types.INTEGER);
            } else {
                cs.setInt(1, id);
            }
            
            cs.setString(2, clientes.getClie_nombres());
            cs.setString(3, clientes.getClie_apellidos());
            
            if (dni == null) {
                cs.setNull(4, Types.INTEGER);
            } else {
                cs.setInt(4, dni);
            }
            
            cs.setBoolean(5, clientes.getClie_estado());

            int ctos = cs.executeUpdate();
            if (ctos == 0) {
                throw new SQLException("0 filas afectadas");
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return message;
    }
}
