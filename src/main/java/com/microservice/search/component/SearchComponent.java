package com.microservice.search.component;


import com.microservice.search.controller.SearchQuery;
import com.microservice.search.domain.Flight;
import com.microservice.search.domain.Inventory;
import com.microservice.search.repository.FlightRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class SearchComponent {
	private FlightRepository flightRepository;
	private static final Logger logger = LoggerFactory.getLogger(SearchComponent.class);
	
	
	@Autowired
	public SearchComponent(FlightRepository flightRepository){
		this.flightRepository = flightRepository;
	}

	public List<Flight> search(SearchQuery query){
		List<Flight> flights= flightRepository.findByOriginAndDestinationAndFlightDate(
										query.getOrigin(),
										query.getDestination(),
										query.getFlightDate()); 
		List<Flight> searchResult = new ArrayList<Flight>();
		searchResult.addAll(flights);
		flights.forEach(flight -> {
			flight.getFares();
			int inv = flight.getInventory().getCount();
			if(inv < 0) {
				searchResult.remove(flight);
			}
		});
		return searchResult; 
	}

	public void updateInventory(String flightNumber, String flightDate, int inventory) {
		logger.info("Updating inventory for flight "+ flightNumber + " innventory "+ inventory); 
		Flight flight = flightRepository.findByFlightNumberAndFlightDate(flightNumber,flightDate);
		Inventory inv = flight.getInventory();
		inv.setCount(inventory);
		flightRepository.save(flight); 
	}	 
}
