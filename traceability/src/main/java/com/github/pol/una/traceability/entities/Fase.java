package com.github.pol.una.traceability.entities;

import javax.persistence.*;

public class Fase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_proyecto")
    private Long idProyecto;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_alta")
    private String fechaAlta;

    @Column (name = "fecha_modificacion")
    private String fechaModificacion;

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

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFecha_modificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    }
