package com.microservice.search.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Flight {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	
	String flightNumber;
	String origin;
	String destination;
	String flightDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fare_Id")
    Fares fares;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="inv_Id")
    Inventory inventory;

	public Flight() {
		super();
	}
	

	public Flight(String flightNumber, String origin, String destination, String flightDate, Fares fares,
			Inventory inventory) {
		super();
		this.flightNumber = flightNumber;
		this.origin = origin;
		this.destination = destination;
		this.flightDate = flightDate;
		this.fares = fares;
		this.inventory = inventory;
	}


	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}
	public Fares getFares() {
		return fares;
	}

	public void setFares(Fares fares) {
		this.fares = fares;
	}
	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightNUmber=" + flightNumber + ", origin=" + origin + ", destination="
				+ destination + ", flightDate=" + flightDate + ", fares=" + fares + ", inventory=" + inventory + "]";
	}

 
	
	
}
