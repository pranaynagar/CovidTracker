package com.example.demo;

import com.example.demo.User.Type;

public class Driver {

	public static void main(String[] args) {

		User g1 = new GeneralUser(Type.GENERAL, "Pranay", 452005, Long.valueOf(222));
		System.out.println(g1.register(Type.GENERAL, g1));

		User g2 = new GeneralUser(Type.GENERAL, "User2", 452005, Long.valueOf(222));
		g2.register(Type.GENERAL, g2);

		User a1 = new AdminUser(Type.GENERAL, "Admin1", 452005, Long.valueOf(222));
		System.out.println(a1.register(Type.ADMIN, a1));

		User a2 = new AdminUser(Type.GENERAL, "Admin2", 452005, Long.valueOf(222));
		a2.register(Type.ADMIN, a2);

		String[] sym = { "cold" };

		((GeneralUser) g1).setSymptoms(sym);
		((GeneralUser) g1).setContact(true);
		((GeneralUser) g1).setTravel(false);

		UserService us = new UserService();
		System.out.println(us.selfAssessment(g1));

	}
}
