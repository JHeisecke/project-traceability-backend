package com.github.pol.una.traceability.repository;

import com.github.pol.una.traceability.dto.PermisoRolDTO;
import com.github.pol.una.traceability.entities.PermisoRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface PermisoRolRepository extends JpaRepository<PermisoRol, PermisoRolDTO> {

    List<PermisoRol> findByIdRol(Long idRol);

    PermisoRol findByIdRolAndIdPermisoAndIdRecurso(Long idRol, Long idPermiso, Long idRecurso);

    List<PermisoRol> findByIdRolAndIdPermiso(Long idRol, Long idPermiso);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM public.permiso_Rol WHERE id_rol= :idRol", nativeQuery = true)
    void deleteByIdRol(@Param("idRol") Long idRol);
}
