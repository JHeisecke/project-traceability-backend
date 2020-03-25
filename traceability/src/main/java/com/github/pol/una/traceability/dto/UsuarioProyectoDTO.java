package com.github.pol.una.traceability.dto;

/**
 * @author jvillagra
 */
public class UsuarioProyectoDTO {

    private Long id;
    private Long idUsuario;
    private Long idProyecto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Long idProyecto) {
        this.idProyecto = idProyecto;
    }
}
