package com.muragwa.backend.ServiceImplementantion;

import java.util.List;
import java.util.Optional;

import com.muragwa.backend.Dao.DistrictDao;
import com.muragwa.backend.Domain.District;
import com.muragwa.backend.Service.DistrictService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictDao districtDao;

    @Override
    public Optional<District> findById(int id) {
        return districtDao.findById(id);
    }

    @Override
    public List<District> findAll() {
        return districtDao.findAll();
    }
    
}