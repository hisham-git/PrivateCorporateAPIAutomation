package com.authorize.setupService;

import static com.jayway.restassured.RestAssured.given;

import java.util.Map;

import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class TestDeleteRoleApi extends BaseSetupServiceApi {
	
	
	@Test(dataProvider = "dp")
	public void testDeleteRole(Map<String, Object> header, Map<String, Object> params)
			throws JSONException, InterruptedException, JsonProcessingException {
	
		RequestSpecification requestSpec = specBuilder(header, params);

		Response responseAPI = 
				given()
					.spec(requestSpec)
				.when()
					.get("/deleteRole")
				.then()
					.extract().response();

		if (responseAPI.getStatusCode() == 200) {
			
			Assert.assertNotNull(responseAPI.jsonPath().getString("Params.RoleID"));
			Assert.assertNull(responseAPI.jsonPath().getString("Data"), "Response Data is not null");
		
		} else {

			Assert.assertNull(responseAPI.jsonPath().getString("Data"), "Response Data is not null");
			Assert.assertNotNull(responseAPI.jsonPath().getString("Reasons.ReasonCode"));
		}

		System.out.println("**********Response from [deleteRole]**********");
		System.out.println(responseAPI.getBody().asString());
		System.out.println();

	}
	
	@DataProvider
	public Object[][] dp() {
		return new Object[][] {
				new Object[] { "jcarter01.dsi@gmail.com", "jcarter01.dsi@gmail.com" },
				new Object[] { "jcarter01.dsi@gmail", "jcarter01.dsi@gmail.com" },
				new Object[] { "jcarter01.dsi.gmail.com", "jcarter01.dsi@gmail.com" },
				new Object[] { "jcarter01.dsi@gmail.com", "" },
				new Object[] { "", "jcarter01.dsi@gmail.com" },
				new Object[] { "", "" } };
	}



}
