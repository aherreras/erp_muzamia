/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package erp_muzamia.dao;

import erp_muzamia.dto.Proveedores;
import java.util.List;

/**
 *
 * @author User
 */
public interface DaoProveedores {
    
    public List<Object[]> listaProveedores();
    
    public String registrarProveedor (Proveedores proveedor);
    
    public String modificarProveedor (Proveedores proveedor);
    
    public List<Proveedores> lstProveedores();
    
}
