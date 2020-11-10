package com.muragwa.backend.Controller;

import java.util.Date;
// import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.muragwa.backend.Domain.Fines;
// import com.muragwa.backend.Domain.Village;
// import com.muragwa.backend.Service.VillageService;
import com.muragwa.backend.ServiceImplementantion.FineServiceImpl;
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
public class FinesController {
    // @Autowired
    // private VillageService villService;
    @Autowired
    private FineServiceImpl finesImpl;
    @RequestMapping(value = "/Fines/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveFines(HttpServletRequest request,@RequestBody InnerFines fines){
        ResponseBean rb = new ResponseBean();
        try {
            Fines f = new Fines();
            f.setAmount(fines.getAmount());
            f.setDate(fines.getDate());
            f.setStatus(fines.getStatus());
            finesImpl.createFines(f);
            rb.setCode(Messages.SUCCESS_CODE);
            rb.setDescription("Fines saved Successfully");
            rb.setObject(fines);
        } catch (Exception e) {
            rb.setCode(Messages.SUCCESS_CODE);
            rb.setDescription("Fines not saved Successfully");
            rb.setObject(fines);
        }
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
    public static class InnerFines {
        private double amount;
        private Date date;
        private String status;

        public double getAmount() {
            return this.amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public Date getDate() {
            return this.date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    
    }
}