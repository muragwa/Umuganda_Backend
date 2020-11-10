package com.muragwa.backend.Controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.servlet.http.HttpServletRequest;

import com.muragwa.backend.Domain.Citizen;
import com.muragwa.backend.Domain.Gender;
import com.muragwa.backend.Domain.Village;
import com.muragwa.backend.Service.CitizenService;
import com.muragwa.backend.Service.VillageService;
import com.muragwa.backend.ServiceImplementantion.CitizenServiceImpl;
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
@CrossOrigin

public class CitizenController {
    @Autowired
    private VillageService villService;
    @Autowired
    private CitizenService citizenService;
    @Autowired
    private CitizenServiceImpl citizenServiceImpl;
    @CrossOrigin
    @RequestMapping(value = "/citizen/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveCItizen(HttpServletRequest request, @RequestBody InnerCitizen citizen){
        ResponseBean rb = new ResponseBean();
        try {
            Citizen c = new Citizen();
            Optional<Village> v = villService.findById(citizen.getVillage());
            Village village = v.get();
            c.setDob(citizen.getDob());
            c.setFirstname(citizen.getFirstname());
            c.setLastname(citizen.getLastname());
            c.setGender(citizen.getGender());
            c.setNationalId(citizen.getNationalId());
            c.setPhone(citizen.getPhone());
            c.setVillage(village);
            //citizenServiceImpl.createCitizen(c);
            citizenService.createCitizen(c);
            rb.setCode(Messages.SUCCESS_CODE);
            rb.setDescription("Citizen Saved successfully");
            rb.setObject(citizen);
        } catch (Exception e) {
            rb.setCode(Messages.ERROR_CODE);
            rb.setDescription("Citizen not Saved successfully");
            
        }
        return new ResponseEntity<Object>(rb, HttpStatus.OK);
    }

    @CrossOrigin
	@RequestMapping(value= "/citizen/all", method =RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findall(){
		
		ResponseBean rb = new ResponseBean();
		try {			
					List<Citizen> list = citizenServiceImpl.findAllCitizen();
					rb.setCode(Messages.SUCCESS_CODE);
					rb.setDescription("Citizen retrieved");
					rb.setObject(list);


		} catch (Exception ex) {
			rb.setCode(Messages.ERROR_CODE);
			rb.setDescription("error occured while retrieving branchuser");
		}

		return new ResponseEntity<Object>(rb, HttpStatus.OK);
	}
    public static class InnerCitizen {
        private String firstname;
        private String lastname;
        private Date dob;
        @Enumerated(EnumType.STRING)
        private Gender gender;
        private String nationalId;
        private String phone;
        private String picture;
        private int village;

        public String getFirstname() {
            return this.firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return this.lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public Date getDob() {
            return this.dob;
        }

        public void setDob(Date dob) {
            this.dob = dob;
        }

        public Gender getGender() {
            return this.gender;
        }

        public void setGender(Gender gender) {
            this.gender = gender;
        }

        public String getNationalId() {
            return this.nationalId;
        }

        public void setNationalId(String nationalId) {
            this.nationalId = nationalId;
        }

        public String getPhone() {
            return this.phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPicture() {
            return this.picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public int getVillage() {
            return this.village;
        }

        public void setVillage(int village) {
            this.village = village;
        }

    }
}