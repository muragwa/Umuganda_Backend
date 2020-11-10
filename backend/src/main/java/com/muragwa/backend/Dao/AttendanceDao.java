package com.muragwa.backend.Dao;

import java.util.Optional;

import com.muragwa.backend.Domain.Attendance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AttendanceDao extends JpaRepository<Attendance, Integer>{
    Optional<Attendance> findById(int id);
}
    
