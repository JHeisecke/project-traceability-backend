package com.github.pol.una.traceability.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "fase", schema = "public")
public class Fase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_proyecto")
    private Long idProyecto;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_alta", updatable = false)
    private Date fechaAlta;

    @Column (name = "fecha_modificacion")
    private Date fechaModificacion;

    @Column(name = "orden")
    private Long orden;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProyecto() {return idProyecto;}

    public void setIdProyecto(Long idProyecto)  {this.idProyecto = idProyecto; }

    public String getEstado() { return estado; }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFecha_modificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Long getOrden() {
        return orden;
    }

    public void setOrden(Long orden) {
        this.orden = orden;
    }
}