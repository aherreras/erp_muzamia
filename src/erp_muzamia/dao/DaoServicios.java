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

    public String ins_Servicios(Servicios servicios);

    public String upd_Servicios(Servicios servicios);
    
    public List<Object[]> lst_Servicios_1();
    
    public List<Object[]> lst_Servicios_1_1();
    
    public List<Servicios> lst_Servicios_2();
        
    public List<Servicios> lst_Servicios_2_1();
    
    public List<Object[]> lst_Servicios_x_Categoria_1_1(int id);
    
    public List<Object[]> lst_Servicios_x_Categoria_1_2();
    
    public List<Object[]> lst_Servicios_x_Categoria_1_3();
    
    public List<Servicios> lst_Servicios_x_Categoria_2(int id);
    
    public double fnd_Precio_x_Servicio(int id);
    
}
