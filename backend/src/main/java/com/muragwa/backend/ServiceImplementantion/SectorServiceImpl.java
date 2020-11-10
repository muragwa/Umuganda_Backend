package com.muragwa.backend.ServiceImplementantion;

import java.util.List;
import java.util.Optional;

import com.muragwa.backend.Dao.SectorDao;
import com.muragwa.backend.Domain.Sector;
import com.muragwa.backend.Service.SectorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectorServiceImpl implements SectorService {
    @Autowired
    private SectorDao sectorDao;

    @Override
    public Optional<Sector> findById(int id) {
        return sectorDao.findById(id);
    }

    @Override
    public List<Sector> findAll() {
        return sectorDao.findAll();
    }

    @Override
    public List<Sector> findByDistrictId(int id) {
        return sectorDao.findByDistrictId(id);
    }
    
}