package com.github.pol.una.traceability.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "LineaBase", schema = "public")
public class LineaBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name ="id_proyecto")
    private Long idProyecto;

    @Column (name = "id_fase")
    private Long idFase;

    @Column(name = "estado")
    private String estado;

    @Column (name = "fecha_alta", updatable = false)
    private Date fechaAlta;

    @Column (name = "fecha_modificacion")
    private Date fechaModificacion;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Long idProyecto) {
        this.idProyecto = idProyecto;
    }

    public void setIdFase(Long idFase) {
        this.idFase = idFase;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Long getIdFase() {
        return idFase;
    }
}
