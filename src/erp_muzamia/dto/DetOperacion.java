/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp_muzamia.dto;

/**
 *
 * @author User
 */
public class DetOperacion {

    private Integer dope_id;
    private Integer oper_id;
    private Integer user_id;
    private Integer serv_id;
    private Integer prod_id;
    private String dope_s_p;
    private Double dope_precio;
    private Integer dope_cantidad;
    private Double dope_subtotal;
    private Double dope_descuento;
    private Double dope_total;
    private String dope_timestamp;

    public Integer getDope_id() {
        return dope_id;
    }

    public void setDope_id(Integer dope_id) {
        this.dope_id = dope_id;
    }

    public Integer getOper_id() {
        return oper_id;
    }

    public void setOper_id(Integer oper_id) {
        this.oper_id = oper_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getServ_id() {
        return serv_id;
    }

    public void setServ_id(Integer serv_id) {
        this.serv_id = serv_id;
    }

    public Integer getProd_id() {
        return prod_id;
    }

    public void setProd_id(Integer prod_id) {
        this.prod_id = prod_id;
    }

    public String getDope_s_p() {
        return dope_s_p;
    }

    public void setDope_s_p(String dope_s_p) {
        this.dope_s_p = dope_s_p;
    }

    public Double getDope_precio() {
        return dope_precio;
    }

    public void setDope_precio(Double dope_precio) {
        this.dope_precio = dope_precio;
    }

    public Integer getDope_cantidad() {
        return dope_cantidad;
    }

    public void setDope_cantidad(Integer dope_cantidad) {
        this.dope_cantidad = dope_cantidad;
    }

    public Double getDope_subtotal() {
        return dope_subtotal;
    }

    public void setDope_subtotal(Double dope_subtotal) {
        this.dope_subtotal = dope_subtotal;
    }

    public Double getDope_descuento() {
        return dope_descuento;
    }

    public void setDope_descuento(Double dope_descuento) {
        this.dope_descuento = dope_descuento;
    }

    public Double getDope_total() {
        return dope_total;
    }

    public void setDope_total(Double dope_total) {
        this.dope_total = dope_total;
    }

    public String getDope_timestamp() {
        return dope_timestamp;
    }

    public void setDope_timestamp(String dope_timestamp) {
        this.dope_timestamp = dope_timestamp;
    }
}
