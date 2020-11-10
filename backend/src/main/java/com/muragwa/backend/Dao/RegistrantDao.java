package com.muragwa.backend.Dao;

import java.util.Optional;

import com.muragwa.backend.Domain.Registrant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RegistrantDao extends JpaRepository<Registrant, Integer>{
    Optional<Registrant> findByUuid(String uuid);
	Optional<Registrant> findById(int id);
}