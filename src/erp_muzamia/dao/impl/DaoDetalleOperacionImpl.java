/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp_muzamia.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;
import erp_muzamia.dto.DetalleOperacion;
import erp_muzamia.sql.ConectaDb;
import erp_muzamia.dao.DaoDetalleOperacion;

/**
 *
 * @author User
 */
public class DaoDetalleOperacionImpl implements DaoDetalleOperacion {

    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public DaoDetalleOperacionImpl() {
        db = new ConectaDb();
        this.sql = new StringBuilder();
    }

    @Override
    public String ins_DetalleOperacion(DetalleOperacion detalleOperacion) {
        String sp = "{call sp_insDetalle_operacion(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        Integer user_id = detalleOperacion.getUser_id();
        Integer serv_id = detalleOperacion.getServ_id();
        Integer prod_id = detalleOperacion.getProd_id();
        Integer prov_id = detalleOperacion.getProv_id();
        Integer acti_id = detalleOperacion.getActi_id();
        Integer pasi_id = detalleOperacion.getPasi_id();
        Integer esta_id = detalleOperacion.getEsta_id();

        try ( Connection cn = db.getConnection();  CallableStatement cs = cn.prepareCall(sp)) {

            cs.setInt(1, detalleOperacion.getOper_id());

            if (user_id == null || user_id == 0) {
                cs.setNull(2, Types.INTEGER);
            } else {
                cs.setInt(2, user_id);
            }

            if (serv_id == null || serv_id == 0) {
                cs.setNull(3, Types.INTEGER);
            } else {
                cs.setInt(3, serv_id);
            }

            if (prod_id == null || prod_id == 0) {
                cs.setNull(4, Types.INTEGER);
            } else {
                cs.setInt(4, prod_id);
            }

            if (prov_id == null || prov_id == 0) {
                cs.setNull(5, Types.INTEGER);
            } else {
                cs.setInt(5, prov_id);
            }

            if (acti_id == null || acti_id == 0) {
                cs.setNull(6, Types.INTEGER);
            } else {
                cs.setInt(6, acti_id);
            }

            if (pasi_id == null || pasi_id == 0) {
                cs.setNull(7, Types.INTEGER);
            } else {
                cs.setInt(7, pasi_id);
            }

//            if (sid == null && pid != null) {
//                cs.setNull(2, Types.INTEGER);
//                cs.setInt(3, pid);
//            } else if (sid != null && pid == null) {
//                cs.setInt(2, sid);
//                cs.setNull(3, Types.INTEGER);
//            } else {
//                cs.setNull(2, Types.INTEGER);                
//                cs.setNull(3, Types.INTEGER);
//            }
//            cs.setString(5, detalleOperacion.getDope_s_p());
            cs.setDouble(8, detalleOperacion.getDope_precio());
            cs.setInt(9, detalleOperacion.getDope_cantidad());
            cs.setDouble(10, detalleOperacion.getDope_subtotal());
            cs.setDouble(11, detalleOperacion.getDope_descuento());
            cs.setDouble(12, detalleOperacion.getDope_total());

            if (esta_id == null || esta_id == 0) {
                cs.setNull(13, Types.INTEGER);
            } else {
                cs.setInt(13, esta_id);
            }

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
    public List<DetalleOperacion> fnd_DetalleOperacion_2(int id) {
        List<DetalleOperacion> list = null;
        DetalleOperacion det = null;
        sql.append("SELECT ")
                .append("dope_id,")
                .append("oper_id,")
                .append("serv_id,")
                .append("prod_id,")
                .append("dope_s_p,")
                .append("dope_precio,")
                .append("dope_cantidad,")
                .append("dope_subtotal,")
                .append("dope_descuento,")
                .append("dope_total ")
                .append("FROM DET_OPERACION ")
                .append("WHERE oper_id = ?");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();

            ps.setInt(1, id);

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    det = new DetalleOperacion();
                    det.setDope_id(rs.getInt(1));
                    det.setOper_id(rs.getInt(2));
                    det.setServ_id(rs.getInt(3));
                    det.setProd_id(rs.getInt(4));
//                    det.setDope_s_p(rs.getString(5));
                    det.setDope_precio(rs.getDouble(6));
                    det.setDope_cantidad(rs.getInt(7));
                    det.setDope_subtotal(rs.getDouble(8));
                    det.setDope_descuento(rs.getDouble(9));
                    det.setDope_total(rs.getDouble(10));

                    list.add(det);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public List<Object[]> fnd_DetalleOperacion_1_1(int id) {
        List<Object[]> list = null;
        Object[] obj = null;
        int num = 1;
        sql.append("SELECT ")
                .append("d.serv_id,")
                .append("s.serv_nombre,")
                .append("cate_id,")
                .append("s.cate_descripcion,")
                .append("d.user_id,")
                .append("user_nombres,")
                .append("user_apellidos,")
                .append("dope_precio,")
                .append("dope_cantidad,")
                .append("dope_subtotal,")
                .append("dope_descuento,")
                .append("dope_total ")
                .append("FROM DET_OPERACION d ")
                .append("LEFT JOIN (SELECT serv_id,")
                .append("serv_nombre,")
                .append("s.cate_id,")
                .append("cate_descripcion ")
                .append("FROM SERVICIOS s ")
                .append("INNER JOIN CATEGORIAS c ")
                .append("ON s.cate_id = c.cate_id ")
                .append("WHERE cate_estado = 1) s ")
                .append("ON d.serv_id = s.serv_id ")
                .append("LEFT JOIN USUARIOS u ")
                .append("ON d.user_id = u.user_id ")
                .append("WHERE oper_id = ?");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();

            ps.setInt(1, id);

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    obj = new Object[12];
                    
                    obj[0] = num;
                    obj[1] = rs.getInt(1);
                    obj[2] = rs.getString(2);
                    obj[3] = rs.getInt(3);
                    obj[4] = rs.getString(4);
                    obj[5] = rs.getInt(5);
                    obj[6] = rs.getString(6) + " " + rs.getString(7);
                    obj[7] = rs.getDouble(8);
                    obj[8] = rs.getInt(9);
                    obj[9] = rs.getDouble(10);
                    obj[10] = rs.getDouble(11);
                    obj[11] = rs.getDouble(12);

                    list.add(obj);
                    num++;
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public List<Object[]> fnd_DetalleOperacion_1(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
