package com.muragwa.backend.ServiceImplementantion;

import java.util.List;
import java.util.Optional;

import com.muragwa.backend.Dao.UmugandaDao;
import com.muragwa.backend.Domain.Umuganda;
import com.muragwa.backend.Service.UmugandaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UmugandaServiceImpl implements UmugandaService {

    @Autowired
    private UmugandaDao umugandaDao;
    @Override
    public void createUmuganda(Umuganda umuganda) {
        umugandaDao.save(umuganda);

    }

    @Override
    public void updateUmuganda(Umuganda umuganda) {
        umugandaDao.save(umuganda);

    }

    @Override
    public void delete(Umuganda umuganda) {
        umugandaDao.delete(umuganda);

    }

    @Override
    public List<Umuganda> findAll() {
        return umugandaDao.findAll();
    }

    @Override
    public Optional<Umuganda> findById(int id) {
        return umugandaDao.findById(id);
    }
    
}