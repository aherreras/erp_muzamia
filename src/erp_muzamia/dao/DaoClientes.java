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

    public String ins_Clientes(Clientes clientes);

    public String upd_Clientes(Clientes clientes);

    public List<Object[]> lst_Clientes_1();

    public List<Object[]> lst_Clientes_1_2();

    public List<Clientes> lst_Clientes_2();

    public Clientes fnd_Clientes(int dni);

    public List<Clientes> fnd_Clientes_x_Nombre(String nombres);

}
