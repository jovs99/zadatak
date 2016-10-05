package com.zadatak.model;

public class Sequence {
	private int id;
	private String submittedBy;
	private String purpose;
	private String date;
	
	public Sequence(){}
	
	public Sequence(int id, String submittedBy, String purpose, String date){
		this.id = id;
		this.submittedBy = submittedBy;
        this.purpose = purpose;
        this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
