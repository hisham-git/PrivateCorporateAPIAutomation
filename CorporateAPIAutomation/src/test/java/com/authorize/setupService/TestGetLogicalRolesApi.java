package com.authorize.setupService;

import static com.jayway.restassured.RestAssured.when;

import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class TestGetLogicalRolesApi {
	
	@Test
	public void testGetLogicalRoles ()
			throws JSONException, InterruptedException {

		Response responseAPI = 
				when()
					.get("/getLogicalRoles")
				.then()
					.extract().response();

		if (responseAPI.getStatusCode() == 200) {
			
			Assert.assertNotNull(responseAPI.jsonPath().getString("Data.Role.ID"));
			Assert.assertNotNull(responseAPI.jsonPath().getString("Data.Role.Name"));
			Assert.assertNotNull(responseAPI.jsonPath().getString("Data.Role.Description"));

		} else {

			Assert.assertNull(responseAPI.jsonPath().getString("Data"), "Response Data is not null");
			Assert.assertNotNull(responseAPI.jsonPath().getString("Reasons.ReasonCode"));
		}

		System.out.println("**********Response from [getLogicalRoles]**********");
		System.out.println(responseAPI.getBody().asString());
		System.out.println();

	}



}
