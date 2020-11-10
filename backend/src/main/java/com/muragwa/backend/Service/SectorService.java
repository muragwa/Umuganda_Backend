package com.muragwa.backend.Service;

import java.util.List;
import java.util.Optional;

import com.muragwa.backend.Domain.Sector;

public interface SectorService {
    Optional<Sector> findById(int id);
    public List<Sector> findAll();
    List<Sector> findByDistrictId(int id);

}