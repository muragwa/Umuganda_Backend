package com.muragwa.backend.Service;

import java.util.List;
import java.util.Optional;


import com.muragwa.backend.Domain.District;

public interface DistrictService {
    Optional<District> findById(int id);
    public List<District> findAll();
}