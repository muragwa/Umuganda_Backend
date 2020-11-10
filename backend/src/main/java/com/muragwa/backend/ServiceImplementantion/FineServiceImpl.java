package com.muragwa.backend.ServiceImplementantion;

import java.util.List;
import java.util.Optional;

import com.muragwa.backend.Dao.FinesDao;
import com.muragwa.backend.Domain.Fines;
import com.muragwa.backend.Service.FinesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FineServiceImpl implements FinesService {
    @Autowired
    private FinesDao finesDao;

    @Override
    public void createFines(Fines fines) {
        finesDao.save(fines);

    }

    @Override
    public void updateFines(Fines fines) {
        finesDao.save(fines);

    }

    @Override
    public void deleteFines(Fines fines) {
        finesDao.delete(fines);

    }

    @Override
    public List<Fines> findAllFines() {
        return finesDao.findAll();
    }

    @Override
    public Optional<Fines> findById(int id) {
        return finesDao.findById(id);
    }
    
}