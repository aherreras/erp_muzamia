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
import erp_muzamia.dao.DaoDetOperacion;
import erp_muzamia.dto.DetOperacion;
import erp_muzamia.sql.ConectaDb;

/**
 *
 * @author User
 */
public class DaoDetOperacionImpl implements DaoDetOperacion {

    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public DaoDetOperacionImpl() {
        db = new ConectaDb();
        this.sql = new StringBuilder();
    }

    @Override
    public String registrarDetOperacion(DetOperacion detOperacion) {
        String sp = "{call sp_InsertDet_Operacion(?,?,?,?,?,?,?,?,?,?)}";
        Integer eid = detOperacion.getUser_id();
        Integer sid = detOperacion.getServ_id();
        Integer pid = detOperacion.getProd_id();

        try ( Connection cn = db.getConnection();  CallableStatement cs = cn.prepareCall(sp)) {

            cs.setInt(1, detOperacion.getOper_id());

            if (eid == null) {
                cs.setNull(2, Types.INTEGER);
            } else {
                cs.setInt(2, eid);
            }

            if (sid == null) {
                cs.setNull(3, Types.INTEGER);
            } else {
                cs.setInt(3, sid);
            }

            if (pid == null) {
                cs.setNull(4, Types.INTEGER);
            } else {
                cs.setInt(4, pid);
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
            cs.setString(5, detOperacion.getDope_s_p());
            cs.setDouble(6, detOperacion.getDope_precio());
            cs.setInt(7, detOperacion.getDope_cantidad());
            cs.setDouble(8, detOperacion.getDope_subtotal());
            cs.setDouble(9, detOperacion.getDope_descuento());
            cs.setDouble(10, detOperacion.getDope_total());

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
    public List<DetOperacion> get_DetOperacion(int id) {
        List<DetOperacion> list = null;
        DetOperacion det = null;
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
                    det = new DetOperacion();
                    det.setDope_id(rs.getInt(1));
                    det.setOper_id(rs.getInt(2));
                    det.setServ_id(rs.getInt(3));
                    det.setProd_id(rs.getInt(4));
                    det.setDope_s_p(rs.getString(5));
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
    public List<Object[]> get_DetOperacion_2(int id) {
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
}
