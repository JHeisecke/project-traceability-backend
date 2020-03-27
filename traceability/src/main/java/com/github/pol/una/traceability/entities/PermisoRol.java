package com.github.pol.una.traceability.entities;

import javax.persistence.*;

/**
 * @author jvillagra
 */
@Entity
@Table(name = "permiso_rol", schema = "public")
public class PermisoRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_rol")
    private Long idRol;

    @Column(name = "id_permiso")
    private Long idPermiso;

    @Column(name = "id_recurso")
    private Long idRecurso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(Long idRecurso) {
        this.idRecurso = idRecurso;
    }
}
