/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp_muzamia.dto;

/**
 *
 * @author User
 */
public class Niveles {
    private int nvel_id;
    private String nvel_codigo;
    private String nvel_categoria;
    private String nvel_descripcion;
    private double nvel_base;
    private double nvel_comision;
    private double nvel_bonif;
    private boolean nvel_estado;
    private String nvel_timestamp;

    public int getNvel_id() {
        return nvel_id;
    }

    public void setNvel_id(int nvel_id) {
        this.nvel_id = nvel_id;
    }

    public String getNvel_codigo() {
        return nvel_codigo;
    }

    public void setNvel_codigo(String nvel_codigo) {
        this.nvel_codigo = nvel_codigo;
    }

    public String getNvel_categoria() {
        return nvel_categoria;
    }

    public void setNvel_categoria(String nvel_categoria) {
        this.nvel_categoria = nvel_categoria;
    }

    public String getNvel_descripcion() {
        return nvel_descripcion;
    }

    public void setNvel_descripcion(String nvel_descripcion) {
        this.nvel_descripcion = nvel_descripcion;
    }

    public double getNvel_base() {
        return nvel_base;
    }

    public void setNvel_base(double nvel_base) {
        this.nvel_base = nvel_base;
    }

    public double getNvel_comision() {
        return nvel_comision;
    }

    public void setNvel_comision(double nvel_comision) {
        this.nvel_comision = nvel_comision;
    }

    public double getNvel_bonif() {
        return nvel_bonif;
    }

    public void setNvel_bonif(double nvel_bonif) {
        this.nvel_bonif = nvel_bonif;
    }

    public boolean isNvel_estado() {
        return nvel_estado;
    }

    public void setNvel_estado(boolean nvel_estado) {
        this.nvel_estado = nvel_estado;
    }

    public String getNvel_timestamp() {
        return nvel_timestamp;
    }

    public void setNvel_timestamp(String nvel_timestamp) {
        this.nvel_timestamp = nvel_timestamp;
    }
}
