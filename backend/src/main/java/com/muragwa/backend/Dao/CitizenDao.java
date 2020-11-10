package com.muragwa.backend.Dao;

import com.muragwa.backend.Domain.Citizen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CitizenDao extends JpaRepository<Citizen, Integer>{
    
}