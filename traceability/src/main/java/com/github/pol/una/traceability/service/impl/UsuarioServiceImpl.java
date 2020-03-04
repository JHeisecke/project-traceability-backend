package com.github.pol.una.traceability.service.impl;

import com.github.pol.una.traceability.entities.Usuario;
import com.github.pol.una.traceability.repository.UsuarioRepository;
import com.github.pol.una.traceability.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author jvillagra
 */
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public Usuario findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }
}
