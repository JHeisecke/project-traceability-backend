package com.github.pol.una.traceability.dto;

import java.util.Date;

/**
 * @author yedaloc
 */
public class ItemDTO {

    private Long id;
    private Long idFase;
    private Long idItemPadre;
    private String estado;
    private Long idLineaBase;
    private Date fechaAlta;
    private Date fechaModificacion;
    private Long usuarioModificacion;
    private Long usuarioAlta;
    private String observacion;
    private String descripcion;
    private String prioridad;
    private Long idProyecto;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdFase() {return idFase;}

    public void setIdFase(Long idFase)  {this.idFase = idFase; }

    public Long getIdItemPadre() {return idItemPadre;}

    public void setIdItemPadre(Long idItemPadre)  {this.idItemPadre = idItemPadre; }

    public String getEstado() { return estado; }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getIdLineaBase() {return idLineaBase;}

    public void setIdLineaBase(Long idLineaBase)  {this.idLineaBase = idLineaBase; }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public long getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(long usuarioModificacion) { this.usuarioModificacion = usuarioModificacion; }

    public long getUsuarioAlta() {return usuarioAlta; }

    public void setUsuarioAlta(long usuarioAlta) {
        this.usuarioAlta = usuarioAlta;
    }

    public String getObservacion() { return observacion; }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public Long getIdProyecto() {return idProyecto;}

    public void setIdProyecto(Long idProyecto)  {this.idProyecto = idProyecto; }



}
