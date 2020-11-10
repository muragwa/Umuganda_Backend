package com.muragwa.backend.Controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.muragwa.backend.Domain.Attendance;
import com.muragwa.backend.Domain.Umuganda;
import com.muragwa.backend.Service.UmugandaService;
import com.muragwa.backend.ServiceImplementantion.AttendanceServiceImpl;
import com.muragwa.backend.Utility.Messages;
import com.muragwa.backend.Utility.ResponseBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AttendanceController {
    @Autowired
    private AttendanceServiceImpl attendanceImpl;
    @Autowired
    private UmugandaService umugandaService;
    @RequestMapping(value = "/attendance/save",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveAttendance(HttpServletRequest request, @RequestBody InnerAttendance attendance){
        ResponseBean rb = new ResponseBean();
        try {
            Attendance a = new Attendance();
            Optional<Umuganda> u =  umugandaService.findById(attendance.getUmuganda());
            Umuganda umuganda = u.get();
            a.setStatus(attendance.getStatus());
            a.setUmuganda(umuganda);
            attendanceImpl.createAttendance(a);
            rb.setCode(Messages.SUCCESS_CODE);
            rb.setDescription("Attendance well saved");
            rb.setObject(attendance);
        } catch (Exception e) {
            rb.setCode(Messages.ERROR_CODE);
            rb.setDescription("Attendance not well saved");
            rb.setObject(attendance);
        }
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
    public static class InnerAttendance {
        private String status;
        private int umuganda;

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getUmuganda() {
            return this.umuganda;
        }

        public void setUmuganda(int umuganda) {
            this.umuganda = umuganda;
        }

    }
}