/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp_muzamia.dto;

/**
 *
 * @author User
 */
public class Activos {
    private int acti_id;
    private String acti_descripcion;
    private double acti_importe;
    private int acti_nro_cuotas;
    private double acti_interes;
    private boolean acti_estado;
    private String acti_timestamp;

    public int getActi_id() {
        return acti_id;
    }

    public void setActi_id(int acti_id) {
        this.acti_id = acti_id;
    }

    public String getActi_descripcion() {
        return acti_descripcion;
    }

    public void setActi_descripcion(String acti_descripcion) {
        this.acti_descripcion = acti_descripcion;
    }

    public double getActi_importe() {
        return acti_importe;
    }

    public void setActi_importe(double acti_importe) {
        this.acti_importe = acti_importe;
    }

    public int getActi_nro_cuotas() {
        return acti_nro_cuotas;
    }

    public void setActi_nro_cuotas(int acti_nro_cuotas) {
        this.acti_nro_cuotas = acti_nro_cuotas;
    }

    public double getActi_interes() {
        return acti_interes;
    }

    public void setActi_interes(double acti_interes) {
        this.acti_interes = acti_interes;
    }

    public boolean isActi_estado() {
        return acti_estado;
    }

    public void setActi_estado(boolean acti_estado) {
        this.acti_estado = acti_estado;
    }

    public String getActi_timestamp() {
        return acti_timestamp;
    }

    public void setActi_timestamp(String acti_timestamp) {
        this.acti_timestamp = acti_timestamp;
    }
}
