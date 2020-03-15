package com.github.pol.una.traceability.repository;

import com.github.pol.una.traceability.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author jvillagra
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);

    Usuario findByEmail(String email);

    Usuario findByUsernameAndPassword(String username, String password);

    Usuario findByUsernameAndPasswordAndEmail(String username, String password, String email);

    Optional<Usuario> findById(Long id);

}
