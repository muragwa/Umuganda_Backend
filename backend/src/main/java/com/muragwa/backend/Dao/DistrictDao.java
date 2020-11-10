package com.muragwa.backend.Dao;

import java.util.Optional;

import com.muragwa.backend.Domain.District;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DistrictDao extends JpaRepository<District, Integer> {
    Optional<District> findById(int id);
}