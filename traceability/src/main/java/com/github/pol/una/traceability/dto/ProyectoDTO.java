package com.github.pol.una.traceability.dto;

public class ProyectoDTO {

    private Long id;
    private String nombre;
    private String estado;
    private String fecha_inicio;
    private String fecha_fin;
    private Long id_lider;
    private String fecha_alta;
    private String fecha_modificacion;
    private Long usuario_alta;
    private Long usuario_modificacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Long getId_lider() {
        return id_lider;
    }

    public void setId_lider(Long id_lider) {
        this.id_lider = id_lider;
    }

    public String getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(String fecha_alta) { this.fecha_alta = fecha_alta;}

    public String getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(String fecha_modificacion) { this.fecha_modificacion = fecha_modificacion; }

    public Long getUsuario_alta() {
        return usuario_alta;
    }

    public void setUsuario_alta(Long usuario_alta) {
        this.usuario_alta = usuario_alta;
    }

    public Long getUsuario_modificacion() {
        return usuario_modificacion;
    }

    public void setUsuario_modificacion(Long usuario_modificacion) {
        this.usuario_modificacion = usuario_modificacion;
    }


}
