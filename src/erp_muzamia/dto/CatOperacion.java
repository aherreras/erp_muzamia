/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp_muzamia.dto;

/**
 *
 * @author User
 */
public class CatOperacion {
    private int cope_id;
    private String cope_descripcion;
    private boolean cope_estado;

    public int getCope_id() {
        return cope_id;
    }

    public void setCope_id(int cope_id) {
        this.cope_id = cope_id;
    }

    public String getCope_descripcion() {
        return cope_descripcion;
    }

    public void setCope_descripcion(String cope_descripcion) {
        this.cope_descripcion = cope_descripcion;
    }

    public boolean isCope_estado() {
        return cope_estado;
    }

    public void setCope_estado(boolean cope_estado) {
        this.cope_estado = cope_estado;
    }
}
