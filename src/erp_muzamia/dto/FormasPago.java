/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp_muzamia.dto;

/**
 *
 * @author User
 */
public class FormasPago {
    
    private int fpag_id;
    private String fpag_descripcion;
    private double fpag_comision;
    private boolean fpag_estado;
    private String fpag_timestamp;

    public int getFpag_id() {
        return fpag_id;
    }

    public void setFpag_id(int fpag_id) {
        this.fpag_id = fpag_id;
    }

    public String getFpag_descripcion() {
        return fpag_descripcion;
    }

    public void setFpag_descripcion(String fpag_descripcion) {
        this.fpag_descripcion = fpag_descripcion;
    }

    public double getFpag_comision() {
        return fpag_comision;
    }

    public void setFpag_comision(double fpag_comision) {
        this.fpag_comision = fpag_comision;
    }

    public boolean isFpag_estado() {
        return fpag_estado;
    }

    public void setFpag_estado(boolean fpag_estado) {
        this.fpag_estado = fpag_estado;
    }

    public String getFpag_timestamp() {
        return fpag_timestamp;
    }

    public void setFpag_timestamp(String fpag_timestamp) {
        this.fpag_timestamp = fpag_timestamp;
    }
}
