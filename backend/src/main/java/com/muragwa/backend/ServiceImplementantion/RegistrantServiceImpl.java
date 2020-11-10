package com.muragwa.backend.ServiceImplementantion;

import java.util.List;
import java.util.Optional;

import com.muragwa.backend.Dao.RegistrantDao;
import com.muragwa.backend.Domain.Registrant;
import com.muragwa.backend.Service.RegistrantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrantServiceImpl implements RegistrantService {
    @Autowired
    private RegistrantDao regDao;

    @Override
    public Registrant createRegistrant(Registrant registrant) {
        return regDao.save(registrant);
    }

    @Override
    public void updateRegistrant(Registrant registrant) {
        regDao.save(registrant);
    }

    @Override
    public void deleteRegistrant(int id) {
        regDao.deleteById(id);

    }

    @Override
    public Optional<Registrant> findById(int id) {
        return regDao.findById(id);
    }

    @Override
    public Optional<Registrant> findByUuid(String uuid) {
        return regDao.findByUuid(uuid);
    }

    @Override
    public List<Registrant> findAll() {
        return regDao.findAll();
    }
}