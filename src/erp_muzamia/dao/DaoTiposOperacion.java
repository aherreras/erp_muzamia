/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package erp_muzamia.dao;

import java.util.List;
import erp_muzamia.dto.TiposOperacion;

/**
 *
 * @author User
 */
public interface DaoTiposOperacion {

    public String ins_TiposOperacion(TiposOperacion tiposOperacion);

    public String upd_TiposOperacion(TiposOperacion tiposOperacion);

    public List<Object[]> lst_TiposOperacion_1();

    public List<TiposOperacion> lst_TiposOperacion_2();

}
