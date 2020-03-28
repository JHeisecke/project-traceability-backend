package com.github.pol.una.traceability.dto;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author yedaloc
 */
public class ItemDTO {

    private Long id;
    private Long idFase;
    private String nombre;
    private Long idItemPadre;
    private String estado;
    private Long idLineaBase;
    private LocalDate fechaAlta;
    private LocalDate fechaModificacion;
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

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDate getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDate fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
