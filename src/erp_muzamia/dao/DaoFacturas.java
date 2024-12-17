/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp_muzamia.dao;

import java.util.List;
import erp_muzamia.dto.Detalle;
import erp_muzamia.dto.Facturas;
/**
 *
 * @author User
 */
public interface DaoFacturas {
    
    public List<Facturas> listarFacturas();
    
    public Integer registrarFactura(Facturas facturas);
    
    public List<Object[]> lstCatOperacion();
    
    public List<Object[]> lstComprobantes();
    
    public List<Object[]> lstProveedores();
    
}
