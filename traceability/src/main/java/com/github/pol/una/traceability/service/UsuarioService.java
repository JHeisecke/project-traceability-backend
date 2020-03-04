package com.github.pol.una.traceability.service;

import com.github.pol.una.traceability.dto.UsuarioDTO;
import com.github.pol.una.traceability.entities.Usuario;

/**
 * @author jvillagra
 */
public interface UsuarioService {

    Usuario findByUsername(String username);

}
