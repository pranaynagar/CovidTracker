package com.example.demo;

import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class User {

	enum Type {
		ADMIN, GENERAL
	}

	String name;
	Long number;
	int pincode;
	int id;
	Type type;

	Map<Integer, User> generalUserMap = new LinkedHashMap();
	Map<Integer, User> adminUserMap = new LinkedHashMap();

	public User(Type type, String name, int pincode, long number) {
		this.type = type;
		this.name = name;
		this.pincode = pincode;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public JSONObject register(Type type, User user) {

		int id = createID(type);
		String responseVal = type == Type.GENERAL ? "userID" : "adminID";

		JSONObject errorObj = new JSONObject();
		JSONObject obj = new JSONObject();
		try {
			errorObj.put(responseVal, "Error");
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {

			switch (type) {
			case GENERAL:
				generalUserMap.put(id, user);
				break;
			case ADMIN:
				adminUserMap.put(id, user);
				break;
			default:
				return errorObj;
			}

			
			obj.put(responseVal, id);

		} catch (Exception e) {
			e.printStackTrace();
			return errorObj;
		}

		System.out.println("Registerd User: " + user.getName());

		return obj;
	}

	private int createID(Type type2) {
		// TODO Auto-generated method stub
		return 1;
	}

	public User getUser(Type type, int id) {
		switch (type) {
		case GENERAL:
			return generalUserMap.get(id);
		case ADMIN:
			return adminUserMap.get(id);
		default:
			return null;
		}
	}

}
