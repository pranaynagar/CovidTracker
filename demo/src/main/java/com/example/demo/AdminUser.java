package com.example.demo;

import org.json.JSONObject;

import com.example.demo.User.Type;

public class AdminUser extends User{
	
	public AdminUser(Type type, String name, int pincode, long number) {
		super(type, name, pincode, number);
	}

	public JSONObject registerAdmin(Type type, User user) {
		return register(type, user);
	}
	
}
