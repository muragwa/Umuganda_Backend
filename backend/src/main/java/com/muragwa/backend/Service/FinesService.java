package com.muragwa.backend.Service;

import java.util.List;
import java.util.Optional;

import com.muragwa.backend.Domain.Fines;

public interface FinesService {
    public void createFines(Fines fines);
    public void updateFines(Fines fines);
    public void deleteFines(Fines fines);
    public List<Fines> findAllFines();
    public Optional<Fines> findById(int id);
}