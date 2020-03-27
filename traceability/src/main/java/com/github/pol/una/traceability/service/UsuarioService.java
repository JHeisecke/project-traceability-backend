package com.github.pol.una.traceability.service;

import com.github.pol.una.traceability.dto.RolDTO;
import com.github.pol.una.traceability.dto.UsuarioDTO;
import com.github.pol.una.traceability.entities.Usuario;
import com.github.pol.una.traceability.exceptions.BusinessException;
import com.github.pol.una.traceability.exceptions.UserException;
import org.apache.catalina.User;

import java.util.List;

/**
 * @author jvillagra
 */
public interface UsuarioService {

    UsuarioDTO findByUsername(String username);

    UsuarioDTO login(UsuarioDTO usuarioDTO) throws UserException;

    List<UsuarioDTO> getAll();

    UsuarioDTO saveUser(UsuarioDTO usuarioDTO);

    void deleteUser(String username) throws UserException;
}
