package com.muragwa.backend.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Attendance
 */
@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String status;
    @ManyToOne
    private Registrant registrant;
    @ManyToOne
    private Umuganda umuganda;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public Registrant getRegistrant() {
		return this.registrant;
	}

	public void setRegistrant(Registrant registrant) {
		this.registrant = registrant;
	}


	public Umuganda getUmuganda() {
		return this.umuganda;
	}

	public void setUmuganda(Umuganda umuganda) {
		this.umuganda = umuganda;
	}

       
}