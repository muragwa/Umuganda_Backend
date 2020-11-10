package com.muragwa.backend.Service;

import java.util.List;
import java.util.Optional;

import com.muragwa.backend.Domain.Cell;

public interface CellService {
    Optional<Cell> findById(int id);
    public List<Cell> findAll();
    public List<Cell> findBySectorId(int id);
}