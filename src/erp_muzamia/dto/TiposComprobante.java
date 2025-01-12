/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp_muzamia.dto;

/**
 *
 * @author User
 */
public class TiposComprobante {
    private int tcom_id;
    private String tcom_descripcion;
    private boolean tcom_estado;
    private String tcom_timestamp;

    public int getTcom_id() {
        return tcom_id;
    }

    public void setTcom_id(int tcom_id) {
        this.tcom_id = tcom_id;
    }

    public String getTcom_descripcion() {
        return tcom_descripcion;
    }

    public void setTcom_descripcion(String tcom_descripcion) {
        this.tcom_descripcion = tcom_descripcion;
    }

    public boolean isTcom_estado() {
        return tcom_estado;
    }

    public void setTcom_estado(boolean tcom_estado) {
        this.tcom_estado = tcom_estado;
    }

    public String getTcom_timestamp() {
        return tcom_timestamp;
    }

    public void setTcom_timestamp(String tcom_timestamp) {
        this.tcom_timestamp = tcom_timestamp;
    }
}
