package com.muragwa.backend.ServiceImplementantion;

import java.util.List;
import java.util.Optional;

import com.muragwa.backend.Dao.CellDao;
import com.muragwa.backend.Domain.Cell;
import com.muragwa.backend.Service.CellService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CellServiceImpl implements CellService {
    @Autowired
    private CellDao cellDao;

    @Override
    public Optional<Cell> findById(int id) {
        return cellDao.findById(id);
    }

    @Override
    public List<Cell> findAll() {
        return cellDao.findAll();
    }

    @Override
    public List<Cell> findBySectorId(int id) {
        return cellDao.findBySectorId(id);
    }

    
}