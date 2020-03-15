package com.github.pol.una.traceability.entities;

import javax.persistence.*;

@Entity
@Table(name = "usuario_rol_proyecto", schema = "public")
public class UsuarioRolProyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_proyecto")
    private Long idProyecto;

    @Column(name = "id_rol")
    private Long idRol;

    @Column(name = "id_usuario")
    private Long idUsuario;

    public Long getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Long idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
