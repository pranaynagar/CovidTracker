package com.example.demo;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.User.Type;

@Service
public class UserService {

	@Autowired
	User user;

	public JSONObject selfAssessment(User user) {

//		if (user.getClass() != GeneralUser.class) {
//			return null;
//		}

		String[] symptoms = ((GeneralUser) user).getSymptoms();
		boolean travel = ((GeneralUser) user).isTravel();
		boolean contact = ((GeneralUser) user).isContact();

		JSONObject response = new JSONObject();

		try {
			if (symptoms.length == 0 && !travel && !contact) {
				response.put("riskPercentage", "5");
			}

			if (symptoms.length == 1 && (travel || contact)) {
				response.put("riskPercentage", "50");
			}

			if (symptoms.length == 2 && (travel || contact)) {
				response.put("riskPercentage", "75");
			}

			if (symptoms.length > 2 && (travel || contact)) {
				response.put("riskPercentage", "95");
			}

			return response;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public void updateCovidResult(User admin, int id, String result) {

		GeneralUser generalUser = (GeneralUser) user.getUser(Type.GENERAL, id);

		generalUser.setResult(result);

	}

}
