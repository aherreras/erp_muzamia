/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package erp_muzamia.dao;

import java.util.List;
import erp_muzamia.dto.Productos;

/**
 *
 * @author User
 */
public interface DaoProductos {

    public String ins_Productos(Productos productos);

    public String upd_Productos(Productos productos);
    
    public List<Object[]> lst_Productos_1();
    
    public List<Object[]> lst_Productos_1_1();
    
    public List<Productos> lst_Productos_2();
        
    public List<Productos> lst_Productos_2_1();
    
    public List<Productos> lst_Productos_x_Categoria_2(int id);
    
    public double fnd_Precio_x_Producto(int id);
    
}
