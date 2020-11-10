package com.muragwa.backend.ServiceImplementantion;

import java.util.List;
import java.util.Optional;

import com.muragwa.backend.Dao.CitizenDao;
import com.muragwa.backend.Domain.Citizen;
import com.muragwa.backend.Service.CitizenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitizenServiceImpl implements CitizenService {

    @Autowired
    private CitizenDao citizenDao;

    @Override
    public void createCitizen(Citizen citizen) {
        citizenDao.save(citizen);

    }

    @Override
    public void updateCitizen(Citizen citizen) {
        citizenDao.save(citizen);

    }

    @Override
    public void deleteCitizen(Citizen citizen) {
        citizenDao.delete(citizen);

    }

    @Override
    public List<Citizen> findAllCitizen() {
        return citizenDao.findAll();
    }

    @Override
    public Optional<Citizen> findById(int id) {
        return citizenDao.findById(id);
    }

}