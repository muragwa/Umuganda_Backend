package com.muragwa.backend.Service;

import java.util.List;
import java.util.Optional;

import com.muragwa.backend.Domain.Village;

public interface VillageService {
    Optional<Village> findById(int id);
    public List<Village> findAll();
    List<Village> findByCellId(int id);
}