/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package erp_muzamia.dao;

import erp_muzamia.dto.DetOperacionVenta;
import java.util.List;

/**
 *
 * @author User
 */
public interface DaoVenta {
    
    public List<DetOperacionVenta> getDetalle (int idOperacion);
    
}
