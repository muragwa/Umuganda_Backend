package com.muragwa.backend.Service;

import java.util.List;
import java.util.Optional;

import com.muragwa.backend.Domain.Registrant;

public interface RegistrantService {
    public Registrant createRegistrant(Registrant registrant);
    public void updateRegistrant(Registrant registrant);
    public void deleteRegistrant(int id);
    public Optional<Registrant>findById(int id);
    public Optional<Registrant> findByUuid(String uuid);
    public List<Registrant> findAll();
}