package com.muragwa.backend.ServiceImplementantion;

import java.util.List;
import java.util.Optional;

import com.muragwa.backend.Dao.AnnouncementDao;
import com.muragwa.backend.Domain.Announcement;
import com.muragwa.backend.Service.AnnouncementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnouncementServImplementation implements AnnouncementService {

    @Autowired
    private AnnouncementDao announceDao;
    @Override
    public void createAnnouncement(Announcement announcement) {
        announceDao.save(announcement);

    }

    @Override
    public void updateAnnouncement(Announcement announcement) {
        announceDao.save(announcement);

    }

    @Override
    public void delete(Announcement announcement) {
        announceDao.delete(announcement);

    }

    @Override
    public List<Announcement> findAll() {
        
        return announceDao.findAll();
    }

    @Override
    public Optional<Announcement> findById(int id) {
        return announceDao.findById(id);
    }
    
}