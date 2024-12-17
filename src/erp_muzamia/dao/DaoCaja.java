/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package erp_muzamia.dao;

import java.util.List;
import erp_muzamia.dto.Caja;

/**
 *
 * @author User
 */
public interface DaoCaja {
    
    public List<Object[]> lstCajas();
    
    public List<Caja> lstCajas_2();
    
    public List<Object[]> listarCajas(List<Integer> ids);
    
    public Caja listarCajas(Integer id);
    
}
