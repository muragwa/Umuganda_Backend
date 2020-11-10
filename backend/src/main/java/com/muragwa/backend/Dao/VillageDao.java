package com.muragwa.backend.Dao;

import java.util.List;
import java.util.Optional;

import com.muragwa.backend.Domain.Village;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VillageDao extends JpaRepository<Village, Integer> {
    Optional<Village> findById(int id);
    List<Village> findByCellId(int id);
}