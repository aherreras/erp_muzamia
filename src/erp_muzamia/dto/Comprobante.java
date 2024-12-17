/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp_muzamia.dto;

/**
 *
 * @author User
 */
public class Comprobante {
    private int comp_id;
    private String comp_descripcion;
    private boolean comp_estado;

    public int getComp_id() {
        return comp_id;
    }

    public void setComp_id(int comp_id) {
        this.comp_id = comp_id;
    }

    public String getComp_descripcion() {
        return comp_descripcion;
    }

    public void setComp_descripcion(String comp_descripcion) {
        this.comp_descripcion = comp_descripcion;
    }

    public boolean isComp_estado() {
        return comp_estado;
    }

    public void setComp_estado(boolean comp_estado) {
        this.comp_estado = comp_estado;
    }
}
