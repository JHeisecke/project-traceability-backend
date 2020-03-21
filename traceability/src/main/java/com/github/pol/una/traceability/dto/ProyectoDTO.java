package com.github.pol.una.traceability.dto;

import java.util.Date;

public class ProyectoDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private String estado;
    private Date fechaInicio;
    private Date fechaFin;
    private Long idLider;
    private Date fechaAlta;
    private Date fechaModificacion;
    private Long usuarioAlta;
    private Long usuarioModificacion;

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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Long getIdLider() {
        return idLider;
    }

    public void setIdLider(Long idLider) {
        this.idLider = idLider;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) { this.fechaAlta = fechaAlta;}

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) { this.fechaModificacion = fechaModificacion; }

    public Long getUsuarioAlta() { return usuarioAlta; }

    public void setUsuarioAlta(Long usuarioAlta) {
        this.usuarioAlta = usuarioAlta;
    }

    public Long getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(Long usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
