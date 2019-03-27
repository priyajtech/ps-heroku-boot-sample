package com.boot.model;

public class Patient {
	private String firstName;
	private String dob;
	private String drugName;
	private String ae;	
	
	public Patient() {
		super();
	}
	
	public Patient(String firstName, String dob, String drugName, String ae) {
		super();
		this.firstName = firstName;
		this.dob = dob;
		this.drugName = drugName;
		this.ae = ae;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public String getAe() {
		return ae;
	}
	public void setAe(String ae) {
		this.ae = ae;
	}
	
	
}
