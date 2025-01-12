/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp_muzamia.dto;

/**
 *
 * @author User
 */
public class Productos {

    private int prod_id;
    private String prod_nombre;
    private String prod_descripcion;
    private double prod_precio;
    private int cpro_id;
    private boolean prod_estado;
    private String prod_timestamp;

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public String getProd_nombre() {
        return prod_nombre;
    }

    public void setProd_nombre(String prod_nombre) {
        this.prod_nombre = prod_nombre;
    }

    public String getProd_descripcion() {
        return prod_descripcion;
    }

    public void setProd_descripcion(String prod_descripcion) {
        this.prod_descripcion = prod_descripcion;
    }

    public double getProd_precio() {
        return prod_precio;
    }

    public void setProd_precio(double prod_precio) {
        this.prod_precio = prod_precio;
    }

    public int getCpro_id() {
        return cpro_id;
    }

    public void setCpro_id(int cpro_id) {
        this.cpro_id = cpro_id;
    }

    public boolean isProd_estado() {
        return prod_estado;
    }

    public void setProd_estado(boolean prod_estado) {
        this.prod_estado = prod_estado;
    }

    public String getProd_timestamp() {
        return prod_timestamp;
    }

    public void setProd_timestamp(String prod_timestamp) {
        this.prod_timestamp = prod_timestamp;
    }
}
