package com.github.pol.una.traceability.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "item", schema = "public")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "id_fase")
    private Long idFase;

    @Column (name = "id_item_padre")
    private Long idItemPadre;

    @Column (name = "nombre")
    private String nombre;

    @Column(name = "estado")
    private String estado;

    @Column (name = "id_linea_base")
    private Long idLineaBase;

    @Column (name = "fecha_alta", updatable = false)
    private Date fechaAlta;

    @Column (name = "fecha_modificacion")
    private Date fechaModificacion;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "prioridad")
    private String prioridad;

    @Column(name = "id_proyecto")
    private Long idProyecto;

    @Column(name = "version")
    private Long version;

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

    public Long getVersion() {return version;}

    public void setVersion(Long version)  {this.version = version; }
}
