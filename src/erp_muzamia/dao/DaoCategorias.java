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

    public String ins_Categorias(Categorias categorias, int tipo_cate);

    public String upd_Categorias(Categorias categorias, int tipo_cate);

    public List<Object[]> lst_Categorias_1();
    
    public List<Object[]> lst_Categorias_1_1();

    public List<Categorias> lst_Categorias_2();

    public List<Categorias> lst_Categorias_2_1(int cate_id);

}
