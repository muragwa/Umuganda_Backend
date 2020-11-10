package com.muragwa.backend.Service;

import java.util.List;
import java.util.Optional;

import com.muragwa.backend.Domain.Umuganda;

public interface UmugandaService {
    public void createUmuganda(Umuganda umuganda);
    public void updateUmuganda(Umuganda umuganda);
    public void delete(Umuganda umuganda);
    public List<Umuganda> findAll();
    public Optional<Umuganda> findById(int id);
}