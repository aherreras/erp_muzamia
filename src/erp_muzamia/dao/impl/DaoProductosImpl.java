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
import erp_muzamia.dao.DaoProductos;
import erp_muzamia.dto.Productos;
import erp_muzamia.sql.ConectaDb;
import java.sql.CallableStatement;

/**
 *
 * @author User
 */
public class DaoProductosImpl implements DaoProductos {

    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public DaoProductosImpl() {
        db = new ConectaDb();
        this.sql = new StringBuilder();
    }

    @Override
    public String ins_Productos(Productos productos) {
        String sp = "{call sp_insProductos(?,?,?,?,?)}";

        try ( Connection cn = db.getConnection();  CallableStatement cs = cn.prepareCall(sp)) {

            cs.setString(1, productos.getProd_nombre());
            cs.setString(2, productos.getProd_descripcion());
            cs.setDouble(3, productos.getProd_precio());
            cs.setInt(4, productos.getCpro_id());
            cs.setBoolean(5, productos.isProd_estado());

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
    public String upd_Productos(Productos productos) {
        String sp = "{call sp_updProductos(?,?,?,?,?,?)}";

        try ( Connection cn = db.getConnection();  CallableStatement cs = cn.prepareCall(sp)) {

            cs.setInt(1, productos.getProd_id());
            cs.setString(2, productos.getProd_nombre());
            cs.setString(3, productos.getProd_descripcion());
            cs.setDouble(4, productos.getProd_precio());
            cs.setInt(5, productos.getCpro_id());
            cs.setBoolean(6, productos.isProd_estado());

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
    public List<Object[]> lst_Productos_1() {
        List<Object[]> list = null;
        sql.append("SELECT ")
                .append("prod_id,")
                .append("prod_nombre,")
                .append("prod_descripcion,")
                .append("prod_precio,")
                .append("cpro_id,")
                .append("prod_estado,")
                .append("prod_timestamp ")
                .append("FROM productos;");

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
    public List<Object[]> lst_Productos_1_1() {
        List<Object[]> list = null;
        sql.append("SELECT ")
                .append("prod_id,")
                .append("prod_nombre,")
                .append("prod_descripcion,")
                .append("prod_precio,")
                .append("p.cpro_id,")
                .append("cpro_descripcion,")
                .append("prod_estado,")
                .append("prod_timestamp ")
                .append("FROM productos p ")
                .append("INNER JOIN categorias_producto c ")
                .append("ON p.cpro_id = c.cpro_id ")
                .append("ORDER BY prod_id ASC;");

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
    public List<Productos> lst_Productos_2() {
        List<Productos> list = new ArrayList<Productos>();
        Productos productos = null;
        sql.append("SELECT ")
                .append("prod_id,")
                .append("prod_nombre,")
                .append("prod_descripcion,")
                .append("prod_precio,")
                .append("cpro_id,")
                .append("prod_estado,")
                .append("prod_timestamp ")
                .append("FROM productos;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    productos = new Productos();

                    productos.setProd_id(rs.getInt(1));
                    productos.setProd_nombre(rs.getString(2));
                    productos.setProd_descripcion(rs.getString(3));
                    productos.setProd_precio(rs.getDouble(4));
                    productos.setCpro_id(rs.getInt(5));
                    productos.setProd_estado(rs.getBoolean(6));
                    productos.setProd_timestamp(rs.getString(7));

                    list.add(productos);

                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public List<Productos> lst_Productos_2_1() {
        List<Productos> list = new ArrayList<Productos>();
        Productos productos = null;
        sql.append("SELECT ")
                .append("prod_id,")
                .append("prod_nombre,")
                .append("prod_descripcion,")
                .append("prod_precio,")
                .append("cpro_id,")
                .append("prod_estado,")
                .append("prod_timestamp ")
                .append("FROM productos ")
                .append("WHERE prod_estado = TRUE;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    productos = new Productos();

                    productos.setProd_id(rs.getInt(1));
                    productos.setProd_nombre(rs.getString(2));
                    productos.setProd_descripcion(rs.getString(3));
                    productos.setProd_precio(rs.getDouble(4));
                    productos.setCpro_id(rs.getInt(5));
                    productos.setProd_estado(rs.getBoolean(6));
                    productos.setProd_timestamp(rs.getString(7));

                    list.add(productos);

                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public List<Productos> lst_Productos_x_Categoria_2(int id) {
        List<Productos> list = new ArrayList<Productos>();
        Productos productos = null;
        sql.append("SELECT ")
                .append("prod_id,")
                .append("prod_nombre,")
                .append("prod_descripcion,")
                .append("prod_precio ")
                .append("FROM PRODUCTOS ")
                .append("WHERE cpro_id = ?");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {

            ps.setInt(1, id);

            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    productos = new Productos();
                    productos.setProd_id(rs.getInt(1));
                    productos.setProd_nombre(rs.getString(2));
                    productos.setProd_descripcion(rs.getString(3));
                    productos.setProd_precio(rs.getDouble(4));

                    list.add(productos);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public double fnd_Precio_x_Producto(int id) {
        double precio = 0;
        Productos productos = null;
        sql.append("SELECT ")
                .append("prod_precio ")
                .append("FROM productos ")
                .append("WHERE prod_id = ?");

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
