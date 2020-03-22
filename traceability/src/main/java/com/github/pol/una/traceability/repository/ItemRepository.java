package com.github.pol.una.traceability.repository;

import com.github.pol.una.traceability.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author yedaloc
 */
public interface ItemRepository extends JpaRepository<Item,Long> {

    Optional<Item> findById(Long id);
}
