package com.github.pol.una.traceability.dto;
import io.github.jokoframework.utils.dto_mapping.BaseDTO;

public class Usuario extends BaseDTO {

    private Long id;
    private String nombreCompleto;
    private String username;
    private String password;
    private String email;

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


    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("id", id)
                .append("nombreCompleto", nombreCompleto)
                .append("username", username)
                .append("password", password)
                .append("email", email)
                .toString();
    }
}
