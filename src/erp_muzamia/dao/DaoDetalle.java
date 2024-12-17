/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package erp_muzamia.dao;

import java.util.List;
import erp_muzamia.dto.Detalle;

/**
 *
 * @author User
 */
public interface DaoDetalle {
    
    public List<Object[]> verDetalle(Integer id);
    
    public String registrarDetalle(Detalle detalle);

}
