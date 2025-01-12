/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp_muzamia.dto;

/**
 *
 * @author User
 */
public class TiposOperacion {
    
    private int tope_id;
    private String tope_descripcion;
    private boolean tope_estado;
    private String tope_timestamp;

    public int getTope_id() {
        return tope_id;
    }

    public void setTope_id(int tope_id) {
        this.tope_id = tope_id;
    }

    public String getTope_descripcion() {
        return tope_descripcion;
    }

    public void setTope_descripcion(String tope_descripcion) {
        this.tope_descripcion = tope_descripcion;
    }

    public boolean isTope_estado() {
        return tope_estado;
    }

    public void setTope_estado(boolean tope_estado) {
        this.tope_estado = tope_estado;
    }

    public String getTope_timestamp() {
        return tope_timestamp;
    }

    public void setTope_timestamp(String tope_timestamp) {
        this.tope_timestamp = tope_timestamp;
    }
}
