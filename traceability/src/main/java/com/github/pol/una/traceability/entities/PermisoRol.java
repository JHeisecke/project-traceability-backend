package com.github.pol.una.traceability.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author jvillagra
 */
@Entity
@Table(name = "permiso_rol", schema = "public")
public class PermisoRol {
    @Column(name = "id_rol")
    private Long idRol;

    @Column(name = "id_permiso")
    private Long idPermiso;

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public Long getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Long idPermiso) {
        this.idPermiso = idPermiso;
    }
}
