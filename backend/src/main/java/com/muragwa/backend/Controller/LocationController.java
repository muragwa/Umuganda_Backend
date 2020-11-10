package com.muragwa.backend.Controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;


import com.muragwa.backend.Domain.Cell;
import com.muragwa.backend.Domain.District;
import com.muragwa.backend.Domain.Sector;
import com.muragwa.backend.Domain.Village;
import com.muragwa.backend.Service.CellService;
import com.muragwa.backend.Service.DistrictService;
import com.muragwa.backend.Service.SectorService;
import com.muragwa.backend.Service.VillageService;
import com.muragwa.backend.Utility.Messages;
import com.muragwa.backend.Utility.ResponseBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * LocationController
 */
@CrossOrigin
@Controller
public class LocationController {
    //@Autowired
	//private ProvinceService provincedservice;
	@Autowired
	private DistrictService districtservice;
	@Autowired
	private SectorService sectorservice;
	@Autowired
	private CellService cellservice;
	@Autowired
	private VillageService villageservice;
	
	@CrossOrigin
	@RequestMapping(value= "/District/all", method =RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findall(){
		
		ResponseBean rb = new ResponseBean();
		try {			
					List<District> list = districtservice.findAll();
					rb.setCode(Messages.SUCCESS_CODE);
					rb.setDescription("district retrieved");
					rb.setObject(list);


		} catch (Exception ex) {
			rb.setCode(Messages.ERROR_CODE);
			rb.setDescription("error occured while retrieving branchuser");
		}

		return new ResponseEntity<Object>(rb, HttpStatus.OK);
	}
	@CrossOrigin
	@RequestMapping(value= "/Sector/{id}", method =RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findallSector(HttpServletRequest request, @PathVariable int id){
		
		ResponseBean rb = new ResponseBean();
		try {			
				
					List<Sector> list = sectorservice.findByDistrictId(id);
					rb.setCode(Messages.SUCCESS_CODE);
					rb.setDescription("Sector retrieved");
					rb.setObject(list);


		} catch (Exception ex) {
			rb.setCode(Messages.ERROR_CODE);
			rb.setDescription("error occured while retrieving district");
		}

		return new ResponseEntity<Object>(rb, HttpStatus.OK);
	}
	@CrossOrigin
	@RequestMapping(value= "/Cell/{id}", method =RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findallCell(HttpServletRequest request,@PathVariable int id){
		
		ResponseBean rb = new ResponseBean();
		try {			
					List<Cell> list = cellservice.findBySectorId(id);
					rb.setCode(Messages.SUCCESS_CODE);
					rb.setDescription("Cell retrieved");
					rb.setObject(list);


		} catch (Exception ex) {
			rb.setCode(Messages.ERROR_CODE);
			rb.setDescription("error occured while retrieving branchuser");
		}

		return new ResponseEntity<Object>(rb, HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value= "/Village/{id}", method =RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findallVillage(HttpServletRequest request, @PathVariable int id){
		
		ResponseBean rb = new ResponseBean();
		try {			
					List<Village> list = villageservice.findByCellId(id);
					rb.setCode(Messages.SUCCESS_CODE);
					rb.setDescription("village retrieved");
					rb.setObject(list);


		} catch (Exception ex) {
			rb.setCode(Messages.ERROR_CODE);
			rb.setDescription("error occured while retrieving branchuser");
		}

		return new ResponseEntity<Object>(rb, HttpStatus.OK);
	}
}