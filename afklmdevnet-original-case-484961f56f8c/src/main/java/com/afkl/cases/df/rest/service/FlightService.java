package com.afkl.cases.df.rest.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.stereotype.Service;

import com.afkl.cases.df.model.AirportMetadata;
import com.afkl.cases.df.model.Fare;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FlightService {

	public FlightService() {
	}

	Logger logger = LoggerFactory.getLogger(FlightService.class);

	private static final String space = " ";
	private static final String closeBrace = ")";
	private static final String openBrace = "(";
	private static final String SLASH = "/";
	private static final String LOCATIONS = "locations";
	private static final String _EMBEDDED = "_embedded";

	@Value("${com.afkl.api.fares}")
	private String fareUri;

	@Value("${com.afkl.api.airports}")
	private String airportUri;

	@Value("${com.afkl.url}")
	private String afklUrl;

	@Autowired
	private OAuth2RestOperations restTemplate;

	public Fare getFareDetails(String fromDestination, String toDestination) {
		Fare fare = null;
		try {
			StringBuilder stringBuilder = new StringBuilder(afklUrl);
			stringBuilder.append(fareUri).append(fromDestination).append(SLASH).append(toDestination);
			String url = stringBuilder.toString();
			fare = restTemplate.getForObject(url, Fare.class);
		
		} catch (Exception e) {
			logger.error(e.getMessage() + "in getFareDetails()");
			throw e;
		} 
		return fare;
	}

	public String[] getAirports() throws IOException {

		ObjectMapper mapper = new ObjectMapper();
		int airportArrayIndex = 0;
		String[] airportArray = null;

		try {
			// frame url
			StringBuilder stringBuilder = new StringBuilder(afklUrl);
			stringBuilder.append(airportUri);
			String url = stringBuilder.toString();

			// fetch airport from mock
			JsonNode jsonNode = restTemplate.getForObject(url, JsonNode.class);

			// response formattting
			JsonNode locationsNode = jsonNode.get(_EMBEDDED).get(LOCATIONS);

			TypeReference<List<AirportMetadata>> typeReference = new TypeReference<List<AirportMetadata>>() {
			};
			ArrayList<AirportMetadata> aiportMetadatsList = mapper.readValue(locationsNode.toString(), typeReference);
			airportArray = new String[aiportMetadatsList.size()];
			for (AirportMetadata airport : aiportMetadatsList) {
				StringBuilder sb = new StringBuilder();
				airportArray[airportArrayIndex++] = sb.append(openBrace).append(airport.getCode()).append(closeBrace)
						.append(space).append(airport.getName()).toString();
			}
			
		} catch (JsonParseException | JsonMappingException e) {
			logger.error(e.getMessage() + "in getAirports()");
			throw e;
		} catch (IOException e) {
			logger.error(e.getMessage() + "in getAirports()");
			throw e;
		} catch (Exception e) {
			logger.error(e.getMessage() + "in getAirports()");
			throw e;
		}
		return airportArray;
	}

}
