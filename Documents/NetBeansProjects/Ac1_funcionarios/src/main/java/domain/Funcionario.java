package domain;

import java.sql.Date;

public class Funcionario {
    
    private int funcionarios_id;
    private String numero_identificacion;
    private String nombres;
    private String sexo;
    private String direccion;
    private String telefono;
    private Date fecha_nacimiento;
    private Date fecha_creacion;
    private Date fecha_actualizacion;
    private Object estado_civil_id;
    private Object tipo_documento_id;

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(Date fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }

    public Object getEstado_civil_id() {
        return estado_civil_id;
    }

    public void setEstado_civil_id(Object estado_civil_id) {
        this.estado_civil_id = estado_civil_id;
    }

    public Object getTipo_documento_id() {
        return tipo_documento_id;
    }

    public void setTipo_documento_id(Object tipo_documento_id) {
        this.tipo_documento_id = tipo_documento_id;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getFuncionarios_id() {
        return funcionarios_id;
    }

    public void setFuncionarios_id(int funcionarios_id) {
        this.funcionarios_id = funcionarios_id;
    }

    public String getNumero_identificacion() {
        return numero_identificacion;
    }

    public void setNumero_identificacion(String numero_identificacion) {
        this.numero_identificacion = numero_identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return numero_identificacion + " " + nombres; // toyota prado
    }
}
