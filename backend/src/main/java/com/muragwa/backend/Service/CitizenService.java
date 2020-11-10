package com.muragwa.backend.Service;

import java.util.List;
import java.util.Optional;

import com.muragwa.backend.Domain.Citizen;

public interface CitizenService {
    public void createCitizen(Citizen citizen);
    public void updateCitizen(Citizen citizen);
    public void deleteCitizen(Citizen citizen);
    public List<Citizen> findAllCitizen();
    public Optional<Citizen> findById(int id);
}