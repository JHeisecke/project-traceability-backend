package com.github.pol.una.traceability.dto;

import java.util.List;

/**
 * @author jvillagra
 */
public class PermisoDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private List<Long> recursos;

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Long> getRecursos() {
        return recursos;
    }

    public void setRecursos(List<Long> recursos) {
        this.recursos = recursos;
    }
}
