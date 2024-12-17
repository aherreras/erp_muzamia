/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package erp_muzamia.dao;

import java.util.List;
import erp_muzamia.dto.Servicios;
/**
 *
 * @author User
 */
public interface DaoServicios {
    
    public List<Object[]> lst_Servicios_x_Cate(Integer id);
    
    public List<Servicios> lst_Servicios_x_Cate_2(Integer id);
    
    public List<Object[]> lst_Servicios();
    
    public List<Object[]> lst_Servicios_2();
    
    public List<Servicios> lst_Servicios_3();
    
    public Double get_Precio_Servicio(Integer id);
    
    public String ins_Servicio (Servicios servicios);
    
    public String upd_Servicio (Servicios servicios);
    
}
