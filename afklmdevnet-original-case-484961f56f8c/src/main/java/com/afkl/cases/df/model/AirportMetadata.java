package com.afkl.cases.df.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
/**
 * 
 * 
 * This class is for fetching data from mockservice
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT) 
public class AirportMetadata {
	
	
	private AirportMetadata parent;
	private String code;
	private String name;
	private String description;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public AirportMetadata getParent() {
		return parent;
	}
	public void setParent(AirportMetadata parent) {
		this.parent = parent;
	}
	
	
}
