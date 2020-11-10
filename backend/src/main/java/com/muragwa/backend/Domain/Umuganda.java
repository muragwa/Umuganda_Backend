package com.muragwa.backend.Domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Umuganda
 */
@Entity
public class Umuganda {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String description;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
    private Long value;
    @ManyToOne
	private Registrant registrant;
	@ManyToOne
	private Village village;

	public Village getVillage() {
		return this.village;
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Long getValue() {
		return this.value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	public Registrant getRegistrant() {
		return this.registrant;
	}

	public void setRegistrant(Registrant registrant) {
		this.registrant = registrant;
	}

}