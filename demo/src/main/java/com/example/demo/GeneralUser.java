package com.example.demo;

import org.json.JSONObject;

import com.example.demo.User.Type;

public class GeneralUser extends User {

	String[] symptoms;
	boolean travel, contact;
	String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public GeneralUser(Type type, String name, int pincode, long number) {
		super(type, name, pincode, number);
	}

	public String[] getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String[] symptoms) {
		this.symptoms = symptoms;
	}

	public boolean isTravel() {
		return travel;
	}

	public void setTravel(boolean travel) {
		this.travel = travel;
	}

	public boolean isContact() {
		return contact;
	}

	public void setContact(boolean contact) {
		this.contact = contact;
	}

	public JSONObject registerGeneral(Type type, User user) {
		return register(type, user);
	}

}
