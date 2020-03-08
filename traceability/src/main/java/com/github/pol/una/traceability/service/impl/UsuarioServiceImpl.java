package com.github.pol.una.traceability.service.impl;

import com.github.pol.una.traceability.dto.UsuarioDTO;
import com.github.pol.una.traceability.entities.Usuario;
import com.github.pol.una.traceability.exceptions.UserException;
import com.github.pol.una.traceability.repository.UsuarioRepository;
import com.github.pol.una.traceability.service.UsuarioService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

/**
 * @author jvillagra
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EntityManager em;

    @Override
    public Usuario login(UsuarioDTO usuarioDTO) throws UserException {

        Usuario usuario = usuarioRepository.findByUsernameAndPassword(usuarioDTO.getUsername(),
                                                                        usuarioDTO.getPassword());
        if(usuario !=null){
            Session session = em.unwrap(Session.class);
            session.persist(usuario);
            return usuario;
        }else{
            throw new UserException("login.password.error", "Las credenciales ingresadas son incorrectas");
        }
    }

    @Override
    public Usuario findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }
}
