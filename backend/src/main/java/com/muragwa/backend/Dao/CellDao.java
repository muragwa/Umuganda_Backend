package com.muragwa.backend.Dao;

import java.util.List;
import java.util.Optional;

import com.muragwa.backend.Domain.Cell;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CellDao extends JpaRepository<Cell, Integer> {
    Optional<Cell> findById(int id);
    List<Cell> findBySectorId(int id);
}