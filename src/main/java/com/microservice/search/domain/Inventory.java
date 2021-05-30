package com.microservice.search.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
public class Inventory {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "inv_id")
	long id;
    
    int count;
    
 
    public Inventory() {
		super();
	}

	public Inventory(int count) {
		super();
		this.count = count;
	}


	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", count=" + count + "]";
	}
    
    
}
