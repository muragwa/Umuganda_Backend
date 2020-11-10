package com.muragwa.backend.ServiceImplementantion;

import java.util.List;
import java.util.Optional;

import com.muragwa.backend.Dao.AttendanceDao;
import com.muragwa.backend.Domain.Attendance;
import com.muragwa.backend.Service.AttendanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceDao attend;
    @Override
    public void createAttendance(Attendance attendance) {
        attend.save(attendance);

    }

    @Override
    public void updateAttendance(Attendance attendance) {
        attend.save(attendance);

    }

    @Override
    public void delete(Attendance attendance) {
        attend.delete(attendance);

    }

    @Override
    public List<Attendance> findAll() {
        return attend.findAll();
    }

    @Override
    public Optional<Attendance> findById(int id) {
        return attend.findById(id);
    }
    
}