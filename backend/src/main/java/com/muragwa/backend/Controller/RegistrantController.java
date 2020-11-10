package com.muragwa.backend.Controller;

import java.util.Optional;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.servlet.http.HttpServletRequest;

import com.muragwa.backend.Domain.Category;
import com.muragwa.backend.Domain.Gender;
import com.muragwa.backend.Domain.Registrant;
import com.muragwa.backend.Domain.System_User;
import com.muragwa.backend.Domain.Village;
import com.muragwa.backend.Service.RegistrantService;
import com.muragwa.backend.Service.SystemUserService;
import com.muragwa.backend.Service.VillageService;
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
public class RegistrantController {
    @Autowired
    private RegistrantService registrantService; 
    @Autowired
    private SystemUserService sus;
    @Autowired
    private VillageService villService;
    @CrossOrigin
    @RequestMapping(value = "/Registrant/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createRegistrant(HttpServletRequest request, @RequestBody InnerRegistrant reg) {
		
		ResponseBean rb = new ResponseBean();
		try {
        
            Registrant rg = new Registrant();
            Optional<Village> v = villService.findById(reg.getVillage());
            Village village = v.get();
            rg.setEmail(reg.getEmail());
            rg.setNames(reg.getNames());
            rg.setGender(reg.getGender());
            rg.setIdentity(reg.getIdentity());
            rg.setPhone(reg.getPhone());
            rg.setUsername(reg.getUsername());
            rg.setPassword(reg.getPassword());
            rg.setVillage(village);
            rg.setReg_Category(reg.getReg_Category());
			registrantService.createRegistrant(rg);
			rb.setCode(Messages.SUCCESS_CODE);
			rb.setDescription("saved well");
            rb.setObject(reg);
            
            System_User su = new System_User();
            su.setEmail(reg.getEmail());
            su.setNames(reg.getNames());
            su.setGender(reg.getGender());
            su.setIdentity(reg.getIdentity());
            su.setPhone(reg.getPhone());
            su.setUsername(reg.getUsername());
            su.setPassword(reg.getPassword());
            su.setRole("user");
            su.setRegistrant(rg);
            sus.create(su);
            rb.setCode(Messages.SUCCESS_CODE);
			rb.setDescription("saved well");
            rb.setObject(reg);
		}catch(Exception ex) {
			rb.setCode(Messages.ERROR_CODE);
			rb.setDescription("failed to register");
		}
		return new ResponseEntity<Object>(rb, HttpStatus.OK);
    }
    /**
     * InnerRegistrantController
     */
    public static class InnerRegistrant {
        private String names;
        private String active;
        @Enumerated(EnumType.STRING)
        private Gender gender;
        private String email;
        private String phone;
        private String identity;
        private String picture;
        @Enumerated(EnumType.STRING)
        private Category reg_Category;
        private int village;
        private String username;
        private String password;

        public String getUsername() {
            return this.username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return this.password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getVillage() {
            return this.village;
        }

        public void setVillage(int village) {
            this.village = village;
        }

	public String getNames() {
		return this.names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	
	public Gender getGender() {
		return this.gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdentity() {
		return this.identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}


	public Category getReg_Category() {
		return this.reg_Category;
	}

	public void setReg_Category(Category reg_Category) {
		this.reg_Category = reg_Category;
	}

        
    }

    /**
     * InnerRegistrantController
     */
    public static class InnerUser {
    
        private String names;
        private String active;
        @Enumerated(EnumType.STRING)
        private Gender gender;
        private String email;
        private String phone;
        private String identity;
        private String picture;
        @Enumerated(EnumType.STRING)
        private Category reg_Category;
        private int village;
        private String username;
        private String password;

        public String getNames() {
            return this.names;
        }

        public void setNames(String names) {
            this.names = names;
        }

        public String getActive() {
            return this.active;
        }

        public void setActive(String active) {
            this.active = active;
        }

    
        public Gender getGender() {
            return this.gender;
        }

        public void setGender(Gender gender) {
            this.gender = gender;
        }

        public String getEmail() {
            return this.email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return this.phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getIdentity() {
            return this.identity;
        }

        public void setIdentity(String identity) {
            this.identity = identity;
        }

        public String getPicture() {
            return this.picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

       

        public Category getReg_Category() {
            return this.reg_Category;
        }

        public void setReg_Category(Category reg_Category) {
            this.reg_Category = reg_Category;
        }

        public int getVillage() {
            return this.village;
        }

        public void setVillage(int village) {
            this.village = village;
        }

        public String getUsername() {
            return this.username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return this.password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

    }
}