/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp_muzamia.dto;

/**
 *
 * @author User
 */
public class Pasivos {
    private int pasi_id;
    private String pasi_descripcion;
    private double pasi_importe;
    private int pasi_nro_cuotas;
    private double pasi_interes;
    private boolean pasi_estado;
    private String pasi_timestamp; 

    public int getPasi_id() {
        return pasi_id;
    }

    public void setPasi_id(int pasi_id) {
        this.pasi_id = pasi_id;
    }

    public String getPasi_descripcion() {
        return pasi_descripcion;
    }

    public void setPasi_descripcion(String pasi_descripcion) {
        this.pasi_descripcion = pasi_descripcion;
    }

    public double getPasi_importe() {
        return pasi_importe;
    }

    public void setPasi_importe(double pasi_importe) {
        this.pasi_importe = pasi_importe;
    }

    public int getPasi_nro_cuotas() {
        return pasi_nro_cuotas;
    }

    public void setPasi_nro_cuotas(int pasi_nro_cuotas) {
        this.pasi_nro_cuotas = pasi_nro_cuotas;
    }

    public double getPasi_interes() {
        return pasi_interes;
    }

    public void setPasi_interes(double pasi_interes) {
        this.pasi_interes = pasi_interes;
    }

    public boolean isPasi_estado() {
        return pasi_estado;
    }

    public void setPasi_estado(boolean pasi_estado) {
        this.pasi_estado = pasi_estado;
    }

    public String getPasi_timestamp() {
        return pasi_timestamp;
    }

    public void setPasi_timestamp(String pasi_timestamp) {
        this.pasi_timestamp = pasi_timestamp;
    }
}
