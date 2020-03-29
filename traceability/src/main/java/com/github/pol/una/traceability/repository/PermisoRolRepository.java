package com.github.pol.una.traceability.repository;

import com.github.pol.una.traceability.dto.PermisoRolDTO;
import com.github.pol.una.traceability.entities.PermisoRol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermisoRolRepository extends JpaRepository<PermisoRol, PermisoRolDTO> {

    List<PermisoRol> findByIdRol(Long idRol);

    PermisoRol findByIdRolAndIdPermisoAndIdRecurso(Long idRol, Long idPermiso, Long idRecurso);

    List<PermisoRol> findByIdRolAndIdPermiso(Long idRol, Long idPermiso);
}
