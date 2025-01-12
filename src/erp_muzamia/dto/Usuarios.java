/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp_muzamia.dto;

/**
 *
 * @author User
 */
public class Usuarios {
    
    private int user_id;
    private int nvel_id;
    private String user_nombres;
    private String user_apellidos;
    private String user_codigo;    
    private String user_password;
    private String user_fecha_nacimiento;
    private int user_dni;
    private String user_fecha_ingreso;
    private String user_fecha_salida;
    private int role_id;    
    private boolean user_estado;
    private String user_timestamp;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getNvel_id() {
        return nvel_id;
    }

    public void setNvel_id(int nvel_id) {
        this.nvel_id = nvel_id;
    }

    public String getUser_nombres() {
        return user_nombres;
    }

    public void setUser_nombres(String user_nombres) {
        this.user_nombres = user_nombres;
    }

    public String getUser_apellidos() {
        return user_apellidos;
    }

    public void setUser_apellidos(String user_apellidos) {
        this.user_apellidos = user_apellidos;
    }

    public String getUser_codigo() {
        return user_codigo;
    }

    public void setUser_codigo(String user_codigo) {
        this.user_codigo = user_codigo;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_fecha_nacimiento() {
        return user_fecha_nacimiento;
    }

    public void setUser_fecha_nacimiento(String user_fecha_nacimiento) {
        this.user_fecha_nacimiento = user_fecha_nacimiento;
    }

    public int getUser_dni() {
        return user_dni;
    }

    public void setUser_dni(int user_dni) {
        this.user_dni = user_dni;
    }

    public String getUser_fecha_ingreso() {
        return user_fecha_ingreso;
    }

    public void setUser_fecha_ingreso(String user_fecha_ingreso) {
        this.user_fecha_ingreso = user_fecha_ingreso;
    }

    public String getUser_fecha_salida() {
        return user_fecha_salida;
    }

    public void setUser_fecha_salida(String user_fecha_salida) {
        this.user_fecha_salida = user_fecha_salida;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public boolean isUser_estado() {
        return user_estado;
    }

    public void setUser_estado(boolean user_estado) {
        this.user_estado = user_estado;
    }

    public String getUser_timestamp() {
        return user_timestamp;
    }

    public void setUser_timestamp(String user_timestamp) {
        this.user_timestamp = user_timestamp;
    }
}
