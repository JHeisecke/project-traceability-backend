package com.github.pol.una.traceability.repository;

import com.github.pol.una.traceability.dto.LineaBaseDTO;
import com.github.pol.una.traceability.entities.LineaBase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LineaBaseRepository extends JpaRepository<LineaBase, LineaBaseDTO> {

    LineaBase findById(Long id);

    List<LineaBase> findAll();




}
