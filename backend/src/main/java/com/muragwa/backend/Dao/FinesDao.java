package com.muragwa.backend.Dao;

import com.muragwa.backend.Domain.Fines;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FinesDao extends JpaRepository<Fines, Integer>{
    
}