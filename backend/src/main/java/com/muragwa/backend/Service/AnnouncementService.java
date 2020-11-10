package com.muragwa.backend.Service;

import java.util.List;
import java.util.Optional;

import com.muragwa.backend.Domain.Announcement;

public interface AnnouncementService {
    public void createAnnouncement(Announcement announcement);
    public void updateAnnouncement(Announcement announcement);
    public void delete(Announcement announcement);
    public List<Announcement> findAll();
    public Optional<Announcement> findById(int id);
}