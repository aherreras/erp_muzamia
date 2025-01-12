/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp_muzamia.dto;

/**
 *
 * @author User
 */
public class Categorias {
    
    private int cate_id;
    private String cate_descripcion;
    private boolean cate_estado;
    private String cate_timestamp;

    public int getCate_id() {
        return cate_id;
    }

    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }

    public String getCate_descripcion() {
        return cate_descripcion;
    }

    public void setCate_descripcion(String cate_descripcion) {
        this.cate_descripcion = cate_descripcion;
    }

    public boolean isCate_estado() {
        return cate_estado;
    }

    public void setCate_estado(boolean cate_estado) {
        this.cate_estado = cate_estado;
    }

    public String getCate_timestamp() {
        return cate_timestamp;
    }

    public void setCate_timestamp(String cate_timestamp) {
        this.cate_timestamp = cate_timestamp;
    }
}
