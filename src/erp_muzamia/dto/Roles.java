/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp_muzamia.dto;

/**
 *
 * @author User
 */
public class Roles {
    private int role_id;
    private String role_nombre;
    private boolean role_estado;
    private String role_timestamp;

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_nombre() {
        return role_nombre;
    }

    public void setRole_nombre(String role_nombre) {
        this.role_nombre = role_nombre;
    }

    public boolean isRole_estado() {
        return role_estado;
    }

    public void setRole_estado(boolean role_estado) {
        this.role_estado = role_estado;
    }

    public String getRole_timestamp() {
        return role_timestamp;
    }

    public void setRole_timestamp(String role_timestamp) {
        this.role_timestamp = role_timestamp;
    }
}
