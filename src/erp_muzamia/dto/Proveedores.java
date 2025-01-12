/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp_muzamia.dto;

/**
 *
 * @author User
 */
public class Proveedores {
    private int prov_id;
    private String prov_razon_social;
    private String prov_ruc;
    private String prov_direccion;
    private String prov_celular;
    private String prov_fec_ingreso;
    private boolean prov_estado;
    private String prov_timestamp;

    public int getProv_id() {
        return prov_id;
    }

    public void setProv_id(int prov_id) {
        this.prov_id = prov_id;
    }

    public String getProv_razon_social() {
        return prov_razon_social;
    }

    public void setProv_razon_social(String prov_razon_social) {
        this.prov_razon_social = prov_razon_social;
    }

    public String getProv_ruc() {
        return prov_ruc;
    }

    public void setProv_ruc(String prov_ruc) {
        this.prov_ruc = prov_ruc;
    }

    public String getProv_direccion() {
        return prov_direccion;
    }

    public void setProv_direccion(String prov_direccion) {
        this.prov_direccion = prov_direccion;
    }

    public String getProv_celular() {
        return prov_celular;
    }

    public void setProv_celular(String prov_celular) {
        this.prov_celular = prov_celular;
    }

    public String getProv_fec_ingreso() {
        return prov_fec_ingreso;
    }

    public void setProv_fec_ingreso(String prov_fec_ingreso) {
        this.prov_fec_ingreso = prov_fec_ingreso;
    }

    public boolean isProv_estado() {
        return prov_estado;
    }

    public void setProv_estado(boolean prov_estado) {
        this.prov_estado = prov_estado;
    }

    public String getProv_timestamp() {
        return prov_timestamp;
    }

    public void setProv_timestamp(String prov_timestamp) {
        this.prov_timestamp = prov_timestamp;
    }
}
