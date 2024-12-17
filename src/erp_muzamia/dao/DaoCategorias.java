/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package erp_muzamia.dao;

import java.util.List;
import erp_muzamia.dto.Categorias;
/**
 *
 * @author User
 */
public interface DaoCategorias {
    
    public List<Object[]> lst_Categorias();
    
    public List<Categorias> lst_Categorias_2();
    
    public List<Categorias> lst_Categorias_3();
    
    public String ins_Categoria(Categorias categorias);
    
    public String upd_Categoria(Categorias categorias);
    
}
