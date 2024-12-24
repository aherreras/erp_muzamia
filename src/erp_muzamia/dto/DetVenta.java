/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp_muzamia.dto;

/**
 *
 * @author User
 */
public class DetVenta extends DetOperacionVenta {

    public DetVenta(Integer oper_id) {
        super(oper_id);
    }
    
    private String user_nombres;
    private String user_apellidos;
    private String serv_nombre;

    public String getUser_nombres() {
        return user_nombres;
    }

    public void setUser_nombres(String user_nombres) {
        this.user_nombres = user_nombres;
    }

    public String getUser_apellidos() {
        return user_apellidos;
    }

    public void setUser_apellidos(String user_apellidos) {
        this.user_apellidos = user_apellidos;
    }

    public String getServ_nombre() {
        return serv_nombre;
    }

    public void setServ_nombre(String serv_nombre) {
        this.serv_nombre = serv_nombre;
    }
}
