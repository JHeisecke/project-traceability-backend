package com.github.pol.una.traceability.service.impl;

import com.github.pol.una.traceability.dto.RolDTO;
import com.github.pol.una.traceability.dto.UsuarioDTO;
import com.github.pol.una.traceability.entities.Usuario;
import com.github.pol.una.traceability.exceptions.RolException;
import com.github.pol.una.traceability.exceptions.UserException;
import com.github.pol.una.traceability.mapper.impl.UsuarioMapper;
import com.github.pol.una.traceability.repository.UsuarioRepository;
import com.github.pol.una.traceability.service.RolService;
import com.github.pol.una.traceability.service.UsuarioRolService;
import com.github.pol.una.traceability.service.UsuarioService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jvillagra
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioMapper mapper;
    @Autowired
    private EntityManager em;
    @Autowired
    private RolService rolService;
    @Autowired
    private UsuarioRolService usuarioRolService;

    @Override
    public UsuarioDTO login(UsuarioDTO usuarioDTO) throws UserException {

        Usuario usuario = usuarioRepository.findByUsernameAndPassword(usuarioDTO.getUsername(),
                                                                        usuarioDTO.getPassword());
        if(usuario !=null){
            Session session = em.unwrap(Session.class);
            session.persist(usuario);
            return findByUsername(usuarioDTO.getUsername());
        }else{
            throw new UserException("login.password.error", "Las credenciales ingresadas son incorrectas");
        }
    }

    @Override
    public List<UsuarioDTO> getAll() {
        List<Usuario> listaUsuarios = usuarioRepository.findAll();
        List<UsuarioDTO> usuarioDTOS = new ArrayList<>();
        for(Usuario usu : listaUsuarios){
            UsuarioDTO usuarioDTO = mapper.mapToDto(usu);
            listarRolesUsuarios(usuarioDTO);
            usuarioDTOS.add(usuarioDTO);
        }
        return usuarioDTOS;
    }

    @Override
    public UsuarioDTO saveUser(UsuarioDTO usuarioDTO) {

        Usuario usuario = usuarioRepository.findByUsername(usuarioDTO.getUsername());
        if(usuario != null) {
            usuarioDTO.setId(usuario.getId());
        }
        usuarioRepository.save(mapper.mapToEntity(usuarioDTO));
        for(RolDTO rol : usuarioDTO.getRoles()){
            usuario= usuarioRepository.findByUsername(usuarioDTO.getUsername());
            usuarioRolService.asignarRolUsuario(usuario.getId(), rol.getId());
        }
        return usuarioDTO;
    }

    @Override
    public UsuarioDTO findByUsername(String username) {
        UsuarioDTO usuarioDTO = mapper.mapToDto(usuarioRepository.findByUsername(username));
        listarRolesUsuarios(usuarioDTO);
        return usuarioDTO;
    }

    private void listarRolesUsuarios(UsuarioDTO usuarioDTO) {
        try {
            usuarioDTO.setRoles(rolService.getRolesByUsuarioId(usuarioDTO.getId()));
        } catch (RolException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(String username) throws UserException {
        Usuario usuario = usuarioRepository.findByUsername(username);
        if(usuario != null) {
            usuarioRepository.delete(usuario);
        } else {
            throw new UserException("notFound", "No se encontró el usuario "+username);
        }
    }

}
