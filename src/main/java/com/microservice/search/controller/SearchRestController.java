package com.microservice.search.controller;

import com.microservice.search.component.SearchComponent;
import com.microservice.search.domain.Flight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RefreshScope
@CrossOrigin
@RestController
@RequestMapping("/search")
class SearchRestController {

	private static final Logger logger = LoggerFactory.getLogger(SearchComponent.class);

	private SearchComponent searchComponent;

	@Value("${orginairports.shutdown}")
	private String originAirportShutdownList;
	
	@Autowired
	public SearchRestController(SearchComponent searchComponent){
		this.searchComponent = searchComponent;
	}


//	@RequestMapping(value="/get", method = RequestMethod.POST)
//	List<Flight> search(@RequestBody SearchQuery query){
//		System.out.println("Input : "+ query);
//		return searchComponent.search(query);
//	}



	@RequestMapping(value="/get", method = RequestMethod.POST)
	List<Flight> search(@RequestBody SearchQuery query){
		logger.info("Input : "+ query);
		logger.info("originAirportShutdownList: " + originAirportShutdownList);
		if(Arrays.asList(originAirportShutdownList.split(",")).contains(query.getOrigin())){
			logger.info("The origin airport is in shutdown state");
			return new ArrayList<Flight>();
		}

		return searchComponent.search(query);
	}

}
