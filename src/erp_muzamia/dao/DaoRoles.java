/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package erp_muzamia.dao;

import erp_muzamia.dto.Roles;
import java.util.List;

/**
 *
 * @author User
 */
public interface DaoRoles {    

    public String ins_Roles(Roles roles);

    public String upd_Roles(Roles roles);

    public List<Object[]> lst_Roles_1();

    public List<Roles> lst_Roles_2();
}
