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
import java.util.LinkedList;
import java.util.List;
import erp_muzamia.dao.DaoServicios;
import erp_muzamia.dto.Servicios;
import erp_muzamia.sql.ConectaDb;
import java.sql.CallableStatement;

/**
 *
 * @author User
 */
public class DaoServiciosImpl implements DaoServicios {

    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public DaoServiciosImpl() {
        db = new ConectaDb();
        this.sql = new StringBuilder();
    }

    @Override
    public String ins_Servicios(Servicios servicios) {
        String sp = "{call sp_insServicios(?,?,?,?,?)}";

        try ( Connection cn = db.getConnection();  CallableStatement cs = cn.prepareCall(sp)) {

            cs.setString(1, servicios.getServ_nombre());
            cs.setString(2, servicios.getServ_descripcion());
            cs.setDouble(3, servicios.getServ_precio());
            cs.setInt(4, servicios.getCate_id());
            cs.setBoolean(5, servicios.isServ_estado());

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
    public String upd_Servicios(Servicios servicios) {
        String sp = "{call sp_updServicios(?,?,?,?,?,?)}";

        try ( Connection cn = db.getConnection();  CallableStatement cs = cn.prepareCall(sp)) {

            cs.setInt(1, servicios.getServ_id());
            cs.setString(2, servicios.getServ_nombre());
            cs.setString(3, servicios.getServ_descripcion());
            cs.setDouble(4, servicios.getServ_precio());
            cs.setInt(5, servicios.getCate_id());
            cs.setBoolean(6, servicios.isServ_estado());

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
    public List<Object[]> lst_Servicios_1() {
        List<Object[]> list = null;
        sql.append("SELECT ")
                .append("serv_id,")
                .append("serv_nombre,")
                .append("serv_descripcion,")
                .append("serv_precio,")
                .append("cate_id,")
                .append("serv_estado,")
                .append("serv_timestamp ")
                .append("FROM servicios;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] reg = new Object[7];

                    reg[0] = rs.getInt(1);
                    reg[1] = rs.getString(2);
                    reg[2] = rs.getString(3);
                    reg[3] = rs.getDouble(4);
                    reg[4] = rs.getInt(5);
                    reg[5] = rs.getBoolean(6);
                    reg[6] = rs.getString(7);

                    list.add(reg);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public List<Object[]> lst_Servicios_1_1() {
        List<Object[]> list = null;
        sql.append("SELECT ")
                .append("serv_id,")
                .append("serv_nombre,")
                .append("serv_descripcion,")
                .append("serv_precio,")
                .append("s.cate_id,")
                .append("cate_descripcion,")
                .append("serv_estado,")
                .append("serv_timestamp ")
                .append("FROM servicios s ")
                .append("INNER JOIN categorias c ")
                .append("ON s.cate_id = c.cate_id ")
                .append("ORDER BY serv_id ASC;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] reg = new Object[8];

                    reg[0] = rs.getInt(1);
                    reg[1] = rs.getString(2);
                    reg[2] = rs.getString(3);
                    reg[3] = rs.getDouble(4);
                    reg[4] = rs.getInt(5);
                    reg[5] = rs.getString(6);
                    
                    if (rs.getBoolean(7) == true) {
                        reg[6] = "Activo";
                    } else {
                        reg[6] = "Inactivo";
                    }
                    
                    reg[7] = rs.getString(8);

                    list.add(reg);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public List<Servicios> lst_Servicios_2() {
        List<Servicios> list = new ArrayList<Servicios>();
        Servicios servicios = null;
        sql.append("SELECT ")
                .append("serv_id,")
                .append("serv_nombre,")
                .append("serv_descripcion,")
                .append("serv_precio,")
                .append("cate_id,")
                .append("serv_estado,")
                .append("serv_timestamp ")
                .append("FROM servicios;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    servicios = new Servicios();

                    servicios.setServ_id(rs.getInt(1));
                    servicios.setServ_nombre(rs.getString(2));
                    servicios.setServ_descripcion(rs.getString(3));
                    servicios.setServ_precio(rs.getDouble(4));
                    servicios.setCate_id(rs.getInt(5));
                    servicios.setServ_estado(rs.getBoolean(6));
                    servicios.setServ_timestamp(rs.getString(7));

                    list.add(servicios);

                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public List<Servicios> lst_Servicios_2_1() {
        List<Servicios> list = new ArrayList<Servicios>();
        Servicios servicios = null;
        sql.append("SELECT ")
                .append("serv_id,")
                .append("serv_nombre,")
                .append("serv_descripcion,")
                .append("serv_precio,")
                .append("cate_id,")
                .append("serv_estado,")
                .append("serv_timestamp ")
                .append("FROM servicios ")
                .append("WHERE serv_estado = TRUE;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    servicios = new Servicios();

                    servicios.setServ_id(rs.getInt(1));
                    servicios.setServ_nombre(rs.getString(2));
                    servicios.setServ_descripcion(rs.getString(3));
                    servicios.setServ_precio(rs.getDouble(4));
                    servicios.setCate_id(rs.getInt(5));
                    servicios.setServ_estado(rs.getBoolean(6));
                    servicios.setServ_timestamp(rs.getString(7));

                    list.add(servicios);

                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public List<Object[]> lst_Servicios_x_Categoria_1_1(int id) {
        List<Object[]> list = null;
        sql.append("SELECT ")
                .append("serv_id,")
                .append("serv_nombre,")
                .append("serv_descripcion,")
                .append("serv_precio,")
                .append("s.cate_id,")
                .append("cate_descripcion ")
                .append("FROM servicios s ")
                .append("INNER JOIN categorias c ")
                .append("ON s.cate_id = c.cate_id ")
                .append("WHERE s.cate_id = ? ")
                .append("AND serv_estado = 1 ")
                .append("ORDER BY serv_nombre ASC;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();

            ps.setInt(1, id);

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] reg = new Object[6];

                    reg[0] = rs.getInt(1);
                    reg[1] = rs.getString(2);
                    reg[2] = rs.getString(3);
                    reg[3] = rs.getDouble(4);
                    reg[4] = rs.getInt(5);
                    reg[5] = rs.getString(6);

                    list.add(reg);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public List<Object[]> lst_Servicios_x_Categoria_1_2() {
        List<Object[]> list = null;
        sql.append("SELECT ")
                .append("serv_id,")
                .append("serv_nombre,")
                .append("serv_descripcion,")
                .append("s.cate_id,")
                .append("cate_descripcion,")
                .append("serv_precio,")
                .append("serv_estado,")
                .append("serv_timestamp ")
                .append("FROM servicios s ")
                .append("INNER JOIN categorias c ")
                .append("ON s.cate_id = c.cate_id ")
                .append("WHERE serv_estado = 1;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] reg = new Object[8];

                    reg[0] = rs.getInt(1);
                    reg[1] = rs.getString(2);
                    reg[2] = rs.getString(3);
                    reg[3] = rs.getInt(4);
                    reg[4] = rs.getString(5);
                    reg[5] = rs.getDouble(6);

                    if (rs.getBoolean(7) == true) {
                        reg[6] = "Activo";
                    } else {
                        reg[6] = "Inactivo";
                    }

                    reg[7] = rs.getString(8);

                    list.add(reg);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public List<Object[]> lst_Servicios_x_Categoria_1_3() {
        List<Object[]> list = null;
        int num = 1;
        sql.append("SELECT ")
                .append("serv_id,")
                .append("serv_nombre,")
                .append("serv_descripcion,")
                .append("s.cate_id,")
                .append("cate_descripcion,")
                .append("serv_precio,")
                .append("serv_estado ")
                .append("FROM servicios s ")
                .append("INNER JOIN categorias c ")
                .append("ON s.cate_id = c.cate_id;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] reg = new Object[8];

                    reg[0] = num;
                    reg[1] = rs.getInt(1);
                    reg[2] = rs.getString(2);
                    reg[3] = rs.getString(3);
                    reg[4] = rs.getInt(4);
                    reg[5] = rs.getString(5);
                    reg[6] = rs.getDouble(6);
                    reg[7] = rs.getBoolean(7);

                    list.add(reg);
                    num++;
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public List<Servicios> lst_Servicios_x_Categoria_2(int id) {
        List<Servicios> list = new ArrayList<Servicios>();
        Servicios servicios = null;
        sql.append("SELECT ")
                .append("serv_id,")
                .append("serv_nombre,")
                .append("serv_descripcion,")
                .append("serv_precio ")
                .append("FROM SERVICIOS ")
                .append("WHERE cate_id = ?");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {

            ps.setInt(1, id);

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    servicios = new Servicios();

                    servicios.setServ_id(rs.getInt(1));
                    servicios.setServ_nombre(rs.getString(2));
                    servicios.setServ_descripcion(rs.getString(3));
                    servicios.setServ_precio(rs.getDouble(4));

                    list.add(servicios);

                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public double fnd_Precio_x_Servicio(int id) {
        double precio = 0;
        Servicios servicios = null;
        sql.append("SELECT ")
                .append("serv_precio ")
                .append("FROM servicios ")
                .append("WHERE serv_id = ?;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {

            ps.setInt(1, id);

            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    precio = rs.getDouble(1);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return precio;
    }
}
