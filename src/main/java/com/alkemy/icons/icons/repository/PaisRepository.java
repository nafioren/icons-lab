package com.alkemy.icons.icons.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alkemy.icons.icons.entity.PaisEntity;

@Repository
public interface PaisRepository extends JpaRepository<PaisEntity, Long> {

    List<PaisEntity> findAll(Specification<PaisEntity> specs);

}