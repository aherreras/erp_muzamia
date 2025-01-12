/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package erp_muzamia.dao;

import java.util.List;
import erp_muzamia.dto.DetalleOperacion;

/**
 *
 * @author User
 */
public interface DaoDetalleOperacion {
    
    public String ins_DetalleOperacion (DetalleOperacion detalleOperacion);
    
    public List<Object[]> fnd_DetalleOperacion_1 (int id);
    
    public List<Object[]> fnd_DetalleOperacion_1_1 (int id);
    
    public List<DetalleOperacion> fnd_DetalleOperacion_2 (int id);
    
}
