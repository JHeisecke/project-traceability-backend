package com.github.pol.una.traceability.service.impl;

import com.github.pol.una.traceability.entities.Rol;
import com.github.pol.una.traceability.entities.Usuario;
import com.github.pol.una.traceability.entities.UsuarioRolProyecto;
import com.github.pol.una.traceability.repository.RolRepository;
import com.github.pol.una.traceability.repository.UsuarioRepository;
import com.github.pol.una.traceability.repository.UsuarioRolProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jvillagra
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioRolProyectoRepository usuarioRolProyectoRepository;

    @Autowired
    private RolRepository rolRepository;

    /**
     * Servicio utilizado para encontrar usuario y cargar sus datos con el UserDetails de Spring Security
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username);
        if(usuario == null){
            throw new UsernameNotFoundException(username);
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Rol rol : findUserRoles(usuario) ){
            grantedAuthorities.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        return new User(usuario.getUsername(), usuario.getPassword(), grantedAuthorities);
    }

    private List<Rol> findUserRoles(Usuario usuario){

        List<UsuarioRolProyecto> rolesPorProyecto = usuarioRolProyectoRepository.findByIdUsuario(usuario.getId());
        List<Rol> rolesUsuario = new ArrayList<>();
        for(UsuarioRolProyecto usuarioRolProyecto : rolesPorProyecto) {
            rolesUsuario.add(rolRepository.findById(usuarioRolProyecto.getIdRol()).get());
        }
        return rolesUsuario;
    }
}
