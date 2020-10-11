package com.github.pol.una.traceability.repository;

import com.github.pol.una.traceability.dto.UsuarioDTO;
import com.github.pol.una.traceability.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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

    @Query(value = "SELECT usu.id, usu.nombre_completo " +
                  "FROM usuario usu " +
                  "JOIN usuario_rol ur on usu.id = ur.id_usuario " +
                  "JOIN permiso_rol pr on ur.id_rol = pr.id_rol " +
                  "WHERE pr.id_recurso = 4 " +
                  "GROUP BY usu.id, usu.nombre_completo " +
                  "HAVING COUNT(pr.id_permiso) >= 4", nativeQuery = true)
    List<Object[]> findTeamLeaders();

}
