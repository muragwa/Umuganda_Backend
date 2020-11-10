package com.muragwa.backend.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.muragwa.backend.Domain.System_User;
import com.muragwa.backend.Service.SystemUserService;
import com.muragwa.backend.Utility.Encryption;
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
public class UserController {
    @Autowired
    private SystemUserService systemservice;
    @CrossOrigin
    @RequestMapping(value = "/user/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createsystemuser(HttpServletRequest request, @RequestBody System_User systemuser) {
		
		ResponseBean rb = new ResponseBean();
		try {
			systemservice.create(systemuser);
			rb.setCode(Messages.SUCCESS_CODE);
			rb.setDescription(Messages.save);
			rb.setObject(systemuser);
			
		}catch(Exception ex) {
			rb.setCode(Messages.ERROR_CODE);
			rb.setDescription("failed to register");
		}
		return new ResponseEntity<Object>(rb, HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/user/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> login(HttpServletRequest request, @RequestBody InnerUser user){

		ResponseBean rb = new ResponseBean();
		try {
			if(user != null){
				Map<String, Object> map = new HashMap<>();
				if ((systemservice.findByUsernameAndPassword(user.getUsername(), Encryption.md5(user.getPassword())) != null)) {
					System_User system_User = systemservice.findByUsernameAndPassword(user.getUsername(), Encryption.md5(user.getPassword()));
					rb.setCode(Messages.SUCCESS_CODE);
					rb.setDescription(Messages.login);
					map.put("userr", system_User);
					rb.setObject(map);
				} else {
					rb.setCode(Messages.ERROR_CODE);
					rb.setDescription("Failed to match username and password");
					rb.setObject(null);
				}
			}else{
				rb.setCode(Messages.ERROR_CODE);
				rb.setDescription("Failed to match it");
				rb.setObject(null);
			}
		} catch (Exception e) {
			rb.setDescription("failed to pass it");
			rb.setObject(null);
		}
	return new	ResponseEntity<Object>(rb, HttpStatus.OK);
	}


	// Inner Class of user
    public static class InnerUser {
		
		private String username;
		private String password;
		
		
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
	}
}