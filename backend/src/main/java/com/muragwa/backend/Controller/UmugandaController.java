package com.muragwa.backend.Controller;

import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.muragwa.backend.Domain.Umuganda;
import com.muragwa.backend.Domain.Village;
import com.muragwa.backend.Service.UmugandaService;
import com.muragwa.backend.Service.VillageService;
import com.muragwa.backend.ServiceImplementantion.UmugandaServiceImpl;
import com.muragwa.backend.Utility.Messages;
import com.muragwa.backend.Utility.ResponseBean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UmugandaController {
    @Autowired
    UmugandaService umugandaService;
    @Autowired
    UmugandaServiceImpl umugandaServiceImplem;
    @Autowired
    VillageService vService;

    @CrossOrigin
    @RequestMapping(value = "/umuganda/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveUmuganda(HttpServletRequest request, @RequestBody InnerUmuganda umuganda) {
        ResponseBean rb = new ResponseBean();
        try {
            Umuganda u = new Umuganda();
            Optional<Village> v  = vService.findById(umuganda.getVillage());
            Village village = v.get();
            u.setDate(umuganda.getDate());
            u.setValue(umuganda.getValue());
            u.setDescription(umuganda.getDescription());
            u.setVillage(village);

            umugandaServiceImplem.createUmuganda(u);
            
            rb.setCode(Messages.SUCCESS_CODE);
            rb.setDescription("Umuganda well saved");
            rb.setObject(umuganda);
        } catch (Exception e) {
            rb.setCode(Messages.ERROR_CODE);
            rb.setDescription("Umuganda not well saved");
            rb.setObject(umuganda);
        }
        return new ResponseEntity<Object>(rb, HttpStatus.OK);
    }

    public static class InnerUmuganda {
        private Date date;
        private String description;
        private long value;
        private int village;

        public Date getDate() {
            return this.date;
        }

        public long getValue() {
            return value;
        }

        public void setValue(long value) {
            this.value = value;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setDate(Date date) {
		this.date = date;
	}

	public int getVillage() {
		return this.village;
	}

	public void setVillage(int village) {
		this.village = village;
	}

        
}
}