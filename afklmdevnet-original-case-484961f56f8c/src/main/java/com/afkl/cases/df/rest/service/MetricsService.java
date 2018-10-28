package com.afkl.cases.df.rest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.afkl.cases.df.entity.HttpStatusInfoEntity;
import com.afkl.cases.df.model.CounterStatus;
import com.afkl.cases.df.model.HttpStatusCountInfo;
import com.afkl.cases.df.repo.HttpStatusInfoRepository;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class MetricsService {


	Logger logger = LoggerFactory.getLogger(MetricsService.class);
	
	@Value("${com.self.url}")
	private String selfUrl;

	@Value("${com.actuator.metrics}")
	private String metricsUri;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HttpStatusInfoRepository httpRepo;
	
	@Autowired
	ModelMapper modelMapper;

	static List<String> codeList =  new ArrayList<>();;
	static List<String> urlList = new ArrayList<>();;
	
	static{
		 urlList = Arrays.asList("metrics", "fare", "airports", "monitor");
		 codeList = Arrays.asList("200", "400", "404", "500");
	}
	
	public List<HttpStatusCountInfo> fetchMetrics() {
		
		List<HttpStatusCountInfo> httpStatusList = new ArrayList<>();
		StringBuilder stringBuilder = new StringBuilder();
		JsonNode responseJson;
		int countRequestCountByStatusTotal = 0;
		int countRequestCountByStatus = 0;
		List<HttpStatusInfoEntity> httpStatusInfoEntityList = new ArrayList<>();
		try {
			stringBuilder.append(selfUrl).append(metricsUri);
			String url = stringBuilder.toString();
			responseJson = restTemplate.getForObject(url, JsonNode.class);

			int tableSize = httpRepo.findAll().size();
			
		/*	for(String code:  codeList){
				for (String uri: urlList) { 
					HttpStatusInfoEntity httpStatusCountEntity = new HttpStatusInfoEntity();
					httpStatusCountEntity.setUri(uri);
					httpStatusCountEntity.setCode(code);
					countRequestCountByStatus = addRequestCountByStatus(responseJson, code, uri);
					httpStatusCountEntity.setCount(String.valueOf(countRequestCountByStatus));
					httpStatusCountEntity.setId(++tableSize);
					httpStatusInfoEntityList.add(httpStatusCountEntity);
					
				}
				
			}*/
			
			for(String code:  codeList){
				HttpStatusInfoEntity httpStatusEntity = new HttpStatusInfoEntity();
				httpStatusEntity.setUri("NA");
				httpStatusEntity.setCode(code);
				countRequestCountByStatus = addRequestCountByStatus(responseJson, code);
				httpStatusEntity.setCount(String.valueOf(countRequestCountByStatus));
				httpStatusEntity.setId(++tableSize);
				countRequestCountByStatusTotal += countRequestCountByStatus;
				httpStatusInfoEntityList.add(httpStatusEntity);
			}
			
			HttpStatusInfoEntity httpStatusEntity = new HttpStatusInfoEntity();
			httpStatusEntity.setUri("NA");
			httpStatusEntity.setCode("total");
			httpStatusEntity.setCount(String.valueOf(countRequestCountByStatusTotal));
			httpStatusEntity.setId(++tableSize);
			httpStatusInfoEntityList.add(httpStatusEntity);
			logger.info("***before saving metrics info");
			httpRepo.save(httpStatusInfoEntityList);
			logger.info("***after saving metrics info");
			
			List<HttpStatusInfoEntity> fetchedHttpEntityList = httpRepo.findAll();
			logger.info("***fetchedHttpEntityList"+fetchedHttpEntityList);
			
			for(HttpStatusInfoEntity entity: fetchedHttpEntityList){
				httpStatusList.add( modelMapper.map(entity, HttpStatusCountInfo.class));
			}
	

		} catch (Exception e) {
			logger.error("Error in MetricsService" +e.getMessage());
		}
		return httpStatusList;
	}

	private int addRequestCountByStatus(JsonNode responseJson, String statusCode) {
		int totalCount = 0;
		 for( CounterStatus counterStatus: CounterStatus.getUriStatusKeyByCode(statusCode)){
			 String key = counterStatus.getKey();
			if (responseJson.get(key) != null){
				totalCount = totalCount + responseJson.get(key).asInt();
			 }
		 }
		return totalCount;
				
	}
	
	private int addRequestCountByStatus(JsonNode responseJson, String statusCode, String uri) {
		int totalCount = 0;
		 for( CounterStatus counterStatus: CounterStatus.getUriStatusKeyByCodeAndUri(statusCode, uri)){
			 String key = counterStatus.getKey();
			if (responseJson.get(key) != null){
				totalCount = totalCount + responseJson.get(key).asInt();
			 }
		 }
		return totalCount;
				
	}
	
	
}
