package com.muragwa.backend.Dao;

import java.util.Optional;

import com.muragwa.backend.Domain.Umuganda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UmugandaDao extends JpaRepository<Umuganda, Integer>{
    Optional<Umuganda> findById(int id);
}