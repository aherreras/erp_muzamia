/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package erp_muzamia.dao;

import erp_muzamia.dto.Niveles;
import java.util.List;

/**
 *
 * @author User
 */
public interface DaoNiveles {    

    public String ins_Niveles(Niveles niveles);

    public String upd_Niveles(Niveles niveles);

    public List<Object[]> lst_Niveles_1();

    public List<Niveles> lst_Niveles_2();
    
}
