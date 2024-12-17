/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp_muzamia.dto;

/**
 *
 * @author User
 */
public class Servicios {
    
    private Integer serv_id;
    private String serv_nombre;
    private String serv_descripcion;
    private double serv_precio;
    private Integer cate_id;
    private boolean serv_estado;
    private String serv_timestamp;

    public Integer getServ_id() {
        return serv_id;
    }

    public void setServ_id(Integer serv_id) {
        this.serv_id = serv_id;
    }

    public String getServ_nombre() {
        return serv_nombre;
    }

    public void setServ_nombre(String serv_nombre) {
        this.serv_nombre = serv_nombre;
    }

    public String getServ_descripcion() {
        return serv_descripcion;
    }

    public void setServ_descripcion(String serv_descripcion) {
        this.serv_descripcion = serv_descripcion;
    }

    public double getServ_precio() {
        return serv_precio;
    }

    public void setServ_precio(double serv_precio) {
        this.serv_precio = serv_precio;
    }

    public Integer getCate_id() {
        return cate_id;
    }

    public void setCate_id(Integer cate_id) {
        this.cate_id = cate_id;
    }

    public boolean isServ_estado() {
        return serv_estado;
    }

    public void setServ_estado(boolean serv_estado) {
        this.serv_estado = serv_estado;
    }

    public String getServ_timestamp() {
        return serv_timestamp;
    }

    public void setServ_timestamp(String serv_timestamp) {
        this.serv_timestamp = serv_timestamp;
    }
}
