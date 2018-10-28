package com.afkl.cases.df.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.afkl.cases.df.model.Fare;
import com.afkl.cases.df.rest.service.FlightService;

@RestController
@CrossOrigin
public class FlightController {

   @Autowired
   private FlightService flightService;
   
   Logger logger = LoggerFactory.getLogger(FlightController.class);
	
   @RequestMapping(method= RequestMethod.GET, value="/fares/{fromDestination}/{toDestination}")
   public Fare getFareDetails( @PathVariable String fromDestination,  @PathVariable String toDestination){
	logger.info("****** getFareDetails called");
	return flightService.getFareDetails(fromDestination, toDestination);
   }
   
	
   @RequestMapping(method= RequestMethod.GET, value="/airports")
   public String[] getAirports(){
	   logger.info("****** getAirports called");
		String[] airports = null;
		try {
			airports = flightService.getAirports();
		} catch (Exception e) {
			logger.error(e.getMessage() + "in getAirports");
		}
		return airports;
   }
}
