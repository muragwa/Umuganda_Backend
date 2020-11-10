package com.muragwa.backend.Dao;

import java.util.List;
import java.util.Optional;

import com.muragwa.backend.Domain.Sector;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SectorDao extends JpaRepository<Sector, Integer>{
    Optional<Sector> findById(int id);
    List<Sector> findByDistrictId(int id);
}