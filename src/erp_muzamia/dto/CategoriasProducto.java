/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp_muzamia.dto;

/**
 *
 * @author User
 */
public class CategoriasProducto {
    
    private int cpro_id;
    private String cpro_descripcion;
    private boolean cpro_estado;
    private String cpro_timestamp;

    public int getCpro_id() {
        return cpro_id;
    }

    public void setCpro_id(int cpro_id) {
        this.cpro_id = cpro_id;
    }

    public String getCpro_descripcion() {
        return cpro_descripcion;
    }

    public void setCpro_descripcion(String cpro_descripcion) {
        this.cpro_descripcion = cpro_descripcion;
    }

    public boolean isCpro_estado() {
        return cpro_estado;
    }

    public void setCpro_estado(boolean cpro_estado) {
        this.cpro_estado = cpro_estado;
    }

    public String getCpro_timestamp() {
        return cpro_timestamp;
    }

    public void setCpro_timestamp(String cpro_timestamp) {
        this.cpro_timestamp = cpro_timestamp;
    }
}
