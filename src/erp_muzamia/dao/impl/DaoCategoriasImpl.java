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
import erp_muzamia.dao.DaoCategorias;
import erp_muzamia.dto.Categorias;
import erp_muzamia.sql.ConectaDb;
import java.sql.CallableStatement;
/**
 *
 * @author User
 */
public class DaoCategoriasImpl implements DaoCategorias{
    
    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public DaoCategoriasImpl() {
        db = new ConectaDb();
        this.sql = new StringBuilder();
    }
    
    @Override
    public List<Object[]> lst_Categorias() {
        List<Object[]> list = null;
        sql.append("SELECT ")
                .append("cate_id,")
                .append("cate_descripcion ")
                .append("FROM CATEGORIAS ")
                .append("WHERE cate_estado = 1;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] reg = new Object[2];

                    reg[0] = rs.getInt(1);
                    reg[1] = rs.getString(2);

                    list.add(reg);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }
    
    @Override
    public List<Categorias> lst_Categorias_2() {
        List<Categorias> list= new ArrayList<Categorias>();
        Categorias categorias = null;
        sql.append("SELECT ")
                .append("cate_id,")
                .append("cate_descripcion,")
                .append("cate_estado ")
                .append("FROM CATEGORIAS ")
                .append("WHERE cate_estado = 1;");

        try (Connection cn = db.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql.toString())) {


            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    categorias = new Categorias();

                    categorias.setCate_id(rs.getInt(1));
                    categorias.setCate_descripcion(rs.getString(2));
                    categorias.setCate_estado(rs.getBoolean(3));
                    
                    list.add(categorias);

                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public List<Categorias> lst_Categorias_3() {
        List<Categorias> list= new ArrayList<Categorias>();
        Categorias categorias = null;
        sql.append("SELECT ")
                .append("cate_id,")
                .append("cate_descripcion,")
                .append("cate_estado,")
                .append("cate_timestamp ")
                .append("FROM CATEGORIAS;");

        try (Connection cn = db.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql.toString())) {


            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    categorias = new Categorias();

                    categorias.setCate_id(rs.getInt(1));
                    categorias.setCate_descripcion(rs.getString(2));
                    categorias.setCate_estado(rs.getBoolean(3));
                    categorias.setCate_timestamp(rs.getString(4));
                    
                    list.add(categorias);

                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public String ins_Categoria(Categorias categorias) {
        String sp = "{call sp_insCategoria(?,?)}";

        try (Connection cn = db.getConnection(); CallableStatement cs = cn.prepareCall(sp)) {

            cs.setString(1, categorias.getCate_descripcion());
            cs.setBoolean(2, categorias.isCate_estado());

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
    public String upd_Categoria(Categorias categorias) {
        String sp = "{call sp_updCategoria(?,?,?)}";

        try (Connection cn = db.getConnection(); CallableStatement cs = cn.prepareCall(sp)) {

            cs.setInt(1, categorias.getCate_id());
            cs.setString(2, categorias.getCate_descripcion());
            cs.setBoolean(3, categorias.isCate_estado());

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
