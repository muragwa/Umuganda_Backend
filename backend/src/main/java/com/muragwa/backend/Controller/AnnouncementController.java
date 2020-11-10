package com.muragwa.backend.Controller;

import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.muragwa.backend.Domain.Announcement;
import com.muragwa.backend.Domain.Village;
// import com.muragwa.backend.Service.AnnouncementService;
import com.muragwa.backend.Service.VillageService;
import com.muragwa.backend.ServiceImplementantion.AnnouncementServImplementation;
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
public class AnnouncementController {
    
   // @Autowired
    //private AnnouncementService announceService;
    @Autowired
    private VillageService villageService;
    @Autowired
    private AnnouncementServImplementation announceImpl;

    @RequestMapping(value = "/announcement/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> SaveAnnouncement(HttpServletRequest request,@RequestBody InnerAnnouncement announce){
        ResponseBean rb = new ResponseBean();
        try {
            Announcement ann = new Announcement();
            Optional<Village> v = villageService.findById(announce.getVillage());
            Village village = v.get();
            ann.setDate(announce.getDate());
            ann.setDescription(announce.getDescription());
            ann.setVillage(village);
            announceImpl.createAnnouncement(ann);
            rb.setCode(Messages.SUCCESS_CODE);
            rb.setDescription("Saved successfully");
            rb.setObject(announce);

        } catch (Exception e) {
            rb.setCode(Messages.ERROR_CODE);
            rb.setDescription("Not saved successfully");
            rb.setObject(announce);
        }
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    public static class InnerAnnouncement {
    private String description;
    private Date date;
    private int village;

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return this.date;
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