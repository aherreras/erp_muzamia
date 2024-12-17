/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package erp_muzamia.dao;

import java.util.List;
import erp_muzamia.dto.Clientes;

/**
 *
 * @author User
 */
public interface DaoClientes {
    
    public Clientes getCliente(Integer dni);
    
    public Integer getID(Integer dni);
    
    public List<Object[]> lstClientes();    
    
    public List<Clientes> lstClientes_2();
    
    public List<Clientes> getClientePorNombre(String nombres);
    
    public String insCliente(Clientes clientes);
    
    public String updCliente(Clientes clientes);
    
}
