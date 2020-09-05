package com.github.pol.una.traceability.repository;

import com.github.pol.una.traceability.dto.FaseDTO;
import com.github.pol.una.traceability.entities.Fase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author jvillagra
 * 2020-09-01
 */
public interface FaseRepository extends JpaRepository<Fase, FaseDTO> {

    Fase findById(Long id);

    List<Fase> findAll();

    List<Fase> findByIdProyecto(Long idProyecto);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM public.fase WHERE id= :id", nativeQuery = true)
    void deleteById(@Param("id") Long id);
}
