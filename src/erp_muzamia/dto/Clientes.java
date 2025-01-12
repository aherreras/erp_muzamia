/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp_muzamia.dto;

/**
 *
 * @author User
 */
public class Clientes {
    
    private int clie_id;
    private String clie_nombres;
    private String clie_apellidos;
    private int clie_dni;
    private boolean clie_estado;
    private String clie_timestamp;

    public int getClie_id() {
        return clie_id;
    }

    public void setClie_id(int clie_id) {
        this.clie_id = clie_id;
    }

    public String getClie_nombres() {
        return clie_nombres;
    }

    public void setClie_nombres(String clie_nombres) {
        this.clie_nombres = clie_nombres;
    }

    public String getClie_apellidos() {
        return clie_apellidos;
    }

    public void setClie_apellidos(String clie_apellidos) {
        this.clie_apellidos = clie_apellidos;
    }

    public int getClie_dni() {
        return clie_dni;
    }

    public void setClie_dni(int clie_dni) {
        this.clie_dni = clie_dni;
    }

    public boolean isClie_estado() {
        return clie_estado;
    }

    public void setClie_estado(boolean clie_estado) {
        this.clie_estado = clie_estado;
    }

    public String getClie_timestamp() {
        return clie_timestamp;
    }

    public void setClie_timestamp(String clie_timestamp) {
        this.clie_timestamp = clie_timestamp;
    }
}
