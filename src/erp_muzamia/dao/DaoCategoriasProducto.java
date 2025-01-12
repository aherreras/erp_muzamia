/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package erp_muzamia.dao;

import java.util.List;
import erp_muzamia.dto.CategoriasProducto;

/**
 *
 * @author User
 */
public interface DaoCategoriasProducto {

    public String ins_CategoriasProducto(CategoriasProducto categoriasProducto);

    public String upd_CategoriasProducto(CategoriasProducto categoriasProducto);

    public List<Object[]> lst_CategoriasProducto_1();

    public List<CategoriasProducto> lst_CategoriasProducto_2();
    
    public List<CategoriasProducto> lst_CategoriasProducto_2_1();

}
