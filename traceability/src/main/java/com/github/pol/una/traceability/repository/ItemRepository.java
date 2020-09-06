package com.github.pol.una.traceability.repository;

import com.github.pol.una.traceability.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author yedaloc
 */
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByIdProyecto(Long idProyecto);

    List<Item> findByIdLineaBase(Long idLineaBase);

    List<Item> findByIdProyectoAndIdFase(Long idProyecto, Long idFase);

    List<Item> findByIdProyectoAndIdFaseAndIdLineaBaseIsNull(Long idProyecto, Long idFase);

    List<Item> findByIdFaseOrderByIdDesc(Long idFase);
}
