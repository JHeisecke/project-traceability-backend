package com.github.pol.una.traceability.service;

import com.github.pol.una.traceability.dto.RolDTO;
import com.github.pol.una.traceability.dto.UsuarioDTO;
import com.github.pol.una.traceability.entities.Usuario;
import com.github.pol.una.traceability.exceptions.UserException;

import java.util.List;

/**
 * @author jvillagra
 */
public interface UsuarioService {

    Usuario findByUsername(String username);

    Usuario login(UsuarioDTO usuarioDTO) throws UserException;

    List<UsuarioDTO> getAll();
}
