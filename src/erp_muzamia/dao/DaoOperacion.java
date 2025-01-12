/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package erp_muzamia.dao;

import java.util.List;
import erp_muzamia.dto.Operaciones;

/**
 *
 * @author User
 */
public interface DaoOperacion {

    public int ins_Operaciones(Operaciones operaciones);

    public String upd_Operaciones(Operaciones operaciones);

    public List<Object[]> lst_Operaciones_1();
    
    public List<Object[]> lst_Operaciones_1_1();

    public List<Operaciones> lst_Operaciones_2();

    public List<Operaciones> lst_Operaciones_flt_1(String fecIni, String fecFin);

    public Object[] get_Operaciones_1(int id);

    public Operaciones get_Operaciones_2(int id);

}
