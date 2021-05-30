package com.microservice.search.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Fares {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "fare_id")
	long id;
    
    String fare;
    String currency;

    
	public Fares(String fare,String currency) {
		super();
		this.fare = fare;
		this.currency = currency;
	}

	public Fares() {
		super();
	}


	@Override
	public String toString() {
		return "Fares [id=" + id + ", fare=" + fare + ", currency=" + currency + "]";
	}
    
    
}
