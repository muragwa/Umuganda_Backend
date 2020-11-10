package com.muragwa.backend.Service;

import java.util.List;
import java.util.Optional;

import com.muragwa.backend.Domain.Attendance;

public interface AttendanceService {
    public void createAttendance(Attendance attendance);
    public void updateAttendance(Attendance attendance);
    public void delete(Attendance attendance);
    public List<Attendance> findAll();
    public Optional<Attendance> findById(int id);
}