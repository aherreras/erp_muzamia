/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package erp_muzamia.dao;

import java.util.List;
import erp_muzamia.dto.Usuarios;

/**
 *
 * @author User
 */
public interface DaoUsuarios {

    public String ins_Usuarios(Usuarios usuarios);

    public String upd_Usuarios(Usuarios usuarios);

    public List<Object[]> lst_Usuarios_1();

    public List<Object[]> lst_Usuarios_1_1();

    public List<Usuarios> lst_Usuarios_2();
    
    public List<Usuarios> lst_Usuarios_2_1();

    public Usuarios fnd_Usuarios(String cod);

}
