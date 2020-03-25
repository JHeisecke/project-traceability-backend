package com.github.pol.una.traceability.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "proyecto", schema = "public")
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado")
    private String estado;

    @Column (name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column (name = "fecha_fin")
    private LocalDate fechaFin;

    @Column (name = "id_lider")
    private long idLider;

    @Column(name = "usuario_alta")
    private long usuarioAlta;

    @Column (name = "usuario_modificacion")
    private long usuarioModificacion;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDate getFechaFin() { return fechaFin; }

    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }

    public long getIdLider() { return idLider; }

    public void setIdLider(long idLider) {
        this.idLider = idLider;
    }

    public long getUsuarioAlta() { return usuarioAlta; }

    public void setUsuarioAlta(long usuarioAlta) {
        this.usuarioAlta = usuarioAlta;
    }

    public long getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(long usuarioModificacion) { this.usuarioModificacion = usuarioModificacion; }
}
