package com.wolox.automation.wappi.models;

public class Information {
	
	private String name;
	private String lastName; 
	private String birthDate; 
	private String country; 
	private String sex;
	
	public Information(String name, String lastName, String birthDate, String country, String sex) {
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.country = country;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public String getCountry() {
		return country;
	}

	public String getSex() {
		return sex;
	}
	
	

}
