/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package erp_muzamia.dao;

import java.util.List;
import erp_muzamia.dto.Periodos;

/**
 *
 * @author User
 */
public interface DaoPeriodos {

    public String ins_Periodos(Periodos periodos);

    public String upd_Periodos(Periodos periodos);
    
    public List<Object[]> lst_Periodos_1();
    
    public List<Object[]> lst_Periodos_1_1(List<Integer> ids);
    
    public List<Periodos> lst_Periodos_2();
    
    public Object[] fnd_Periodos_1(int id);
    
    public Periodos fnd_Periodos_2(int id);
    
}
