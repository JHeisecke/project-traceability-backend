package com.github.pol.una.traceability.service.impl;

import com.github.pol.una.traceability.dto.UsuarioDTO;
import com.github.pol.una.traceability.entities.Usuario;
import com.github.pol.una.traceability.exceptions.UserException;
import com.github.pol.una.traceability.repository.UsuarioRepository;
import com.github.pol.una.traceability.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jvillagra
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDTO login(UsuarioDTO usuarioDTO) throws UserException {
        if(usuarioRepository.findByUsername(usuarioDTO.getUsername())!= null){
            if(usuarioRepository.findByUsernameAndPassword(usuarioDTO.getUsername(), usuarioDTO.getPassword())!= null){
                return usuarioDTO;
            }else{
                throw new UserException("login.password.error", "La contraseña ingresada es incorrecta");
            }
        }else {
            throw new UserException("login.user.notFound", "El usuario no existe");
        }
    }

    @Override
    public Usuario findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }
}
