package com.afkl.cases.df.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class HttpStatusInfoEntity {

	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String count;
	private String code;
	
	private String uri;
	

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public HttpStatusInfoEntity(Integer id, String count, String code, String uri) {
		super();
		this.id = id;
		this.count = count;
		this.code = code;
		this.uri = uri;
	}

	public HttpStatusInfoEntity() {
		super();
	}
	
	
	
	
}
