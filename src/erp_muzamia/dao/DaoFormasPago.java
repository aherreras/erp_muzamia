/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package erp_muzamia.dao;

import java.util.List;
import erp_muzamia.dto.FormasPago;

/**
 *
 * @author User
 */
public interface DaoFormasPago {

    public String ins_FormasPago(FormasPago metodosPago);

    public String upd_FormasPago(FormasPago metodosPago);

    public List<Object[]> lst_FormasPago_1();

    public List<FormasPago> lst_FormasPago_2();

}
