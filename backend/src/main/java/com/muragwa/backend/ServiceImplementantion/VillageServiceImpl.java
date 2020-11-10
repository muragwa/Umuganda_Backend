package com.muragwa.backend.ServiceImplementantion;

import java.util.List;
import java.util.Optional;

import com.muragwa.backend.Dao.VillageDao;
import com.muragwa.backend.Domain.Village;
import com.muragwa.backend.Service.VillageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VillageServiceImpl implements VillageService {
    @Autowired
    private VillageDao villageDao;

    @Override
    public Optional<Village> findById(int id) {
        return villageDao.findById(id);
    }

    @Override
    public List<Village> findAll() {
        return villageDao.findAll();
        
    }

    @Override
    public List<Village> findByCellId(int id) {
        return villageDao.findByCellId(id);
    }

    
    
}