/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp_muzamia.dto;

/**
 *
 * @author User
 */
public class Operaciones {
    private int oper_id;
    private int tope_id;
    private int user_id;
    private int tcom_id;
    private boolean oper_flag_emit_comp;
    private boolean oper_flag_impr_comp;
    private int fpag_id;
    private int peri_id;
    private int clie_id;
    private double oper_monto;
    private double oper_pagado;
    private double oper_saldo;
    private String oper_fecha;
    private int esta_id;
    private String oper_timestamp;

    public int getOper_id() {
        return oper_id;
    }

    public void setOper_id(int oper_id) {
        this.oper_id = oper_id;
    }

    public int getTope_id() {
        return tope_id;
    }

    public void setTope_id(int tope_id) {
        this.tope_id = tope_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTcom_id() {
        return tcom_id;
    }

    public void setTcom_id(int tcom_id) {
        this.tcom_id = tcom_id;
    }

    public boolean isOper_flag_emit_comp() {
        return oper_flag_emit_comp;
    }

    public void setOper_flag_emit_comp(boolean oper_flag_emit_comp) {
        this.oper_flag_emit_comp = oper_flag_emit_comp;
    }

    public boolean isOper_flag_impr_comp() {
        return oper_flag_impr_comp;
    }

    public void setOper_flag_impr_comp(boolean oper_flag_impr_comp) {
        this.oper_flag_impr_comp = oper_flag_impr_comp;
    }

    public int getFpag_id() {
        return fpag_id;
    }

    public void setFpag_id(int fpag_id) {
        this.fpag_id = fpag_id;
    }

    public int getPeri_id() {
        return peri_id;
    }

    public void setPeri_id(int peri_id) {
        this.peri_id = peri_id;
    }

    public int getClie_id() {
        return clie_id;
    }

    public void setClie_id(int clie_id) {
        this.clie_id = clie_id;
    }

    public double getOper_monto() {
        return oper_monto;
    }

    public void setOper_monto(double oper_monto) {
        this.oper_monto = oper_monto;
    }

    public double getOper_pagado() {
        return oper_pagado;
    }

    public void setOper_pagado(double oper_pagado) {
        this.oper_pagado = oper_pagado;
    }

    public double getOper_saldo() {
        return oper_saldo;
    }

    public void setOper_saldo(double oper_saldo) {
        this.oper_saldo = oper_saldo;
    }

    public String getOper_fecha() {
        return oper_fecha;
    }

    public void setOper_fecha(String oper_fecha) {
        this.oper_fecha = oper_fecha;
    }

    public int getEsta_id() {
        return esta_id;
    }

    public void setEsta_id(int esta_id) {
        this.esta_id = esta_id;
    }

    public String getOper_timestamp() {
        return oper_timestamp;
    }

    public void setOper_timestamp(String oper_timestamp) {
        this.oper_timestamp = oper_timestamp;
    }
}
