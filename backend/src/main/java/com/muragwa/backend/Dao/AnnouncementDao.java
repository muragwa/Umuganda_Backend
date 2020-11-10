package com.muragwa.backend.Dao;

import com.muragwa.backend.Domain.Announcement;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementDao extends JpaRepository<Announcement, Integer>{
    
}