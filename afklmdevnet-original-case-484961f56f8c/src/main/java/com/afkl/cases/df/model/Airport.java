package com.afkl.cases.df.model;
/**
 * 
 * DTO sent back as Original-case api as response
 */
public class Airport {

	private String code;
	private String name;
	private String desc;
	//private Airport parent;
	private String parentCode;
	
	
	
	public String getParentCode() {
		return parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
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
		return desc;
	}
	public void setDescription(String desc) {
		this.desc = desc;
	}
	
	/*public Airport getParent() {
		return parent;
	}
	public void setParent(Airport parent) {
		this.parent = parent;
	}*/
	
	
}
