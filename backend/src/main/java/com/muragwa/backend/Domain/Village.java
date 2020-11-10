package com.muragwa.backend.Domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Village
 */
@Entity
public class Village {
    @Id
    private int id;
    private String name;
    @ManyToOne
    private Cell cell;
    

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Cell getCell() {
		return this.cell;
	}

	public void setCell(Cell cell) {
		this.cell = cell;
	}

	

    
}