package com.github.pol.una.traceability.dto;

import com.github.pol.una.traceability.entities.Rol;

import java.util.List;

/**
 * @author jvillagra
 */
public class UsuarioDTO {

    private Long id;
    private String nombreCompleto;
    private String username;
    private String password;
    private String email;
    private List<RolDTO> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<RolDTO> getRoles(){
        return roles;
    }

    public void setRoles(List<RolDTO> roles){
        this.roles = roles;
    }
}
