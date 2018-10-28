package com.afkl.cases.df.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.afkl.cases.df.model.HttpStatusCountInfo;
import com.afkl.cases.df.rest.service.MetricsService;

@RestController
@CrossOrigin
public class MetricsController {
	
	
	   Logger logger = LoggerFactory.getLogger(MetricsController.class);
	   
	   
	   @Autowired
	   private MetricsService metricsService;
	
	   @RequestMapping(method= RequestMethod.GET, value="/monitor")
	   public List<HttpStatusCountInfo> storeTraceInfo(){
		   return metricsService.fetchMetrics();
	   }
}
