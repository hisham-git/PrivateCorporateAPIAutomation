package com.authorize.setupService;

import static com.jayway.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class TestGetRightsApi extends BaseSetupServiceApi {
	
	
	@Test(dataProvider = "dp")
	public void testGetRights(Map<String, Boolean> header, Map<String, int[]> params)
			throws JSONException, InterruptedException, JsonProcessingException {
	
		RequestSpecification requestSpec = specBuilder(header, params);

		Response responseAPI = 
				given()
					.spec(requestSpec)
				.when()
					.get("/getRights")
				.then()
					.extract().response();

		if (responseAPI.getStatusCode() == 200) {
	
			Assert.assertNotNull(responseAPI.jsonPath().getList("Params.RoleIDs"));
			Assert.assertNotNull(responseAPI.jsonPath().getList("Data.Actions"));
			Assert.assertNotNull(responseAPI.jsonPath().getList("Data.Capabilities"));
		
		} else {

			Assert.assertNull(responseAPI.jsonPath().getString("Data"), "Response Data is not null");
			Assert.assertNotNull(responseAPI.jsonPath().getString("Reasons.ReasonCode"));
		}

		System.out.println("**********Response from [getRights]**********");
		System.out.println(responseAPI.getBody().asString());
		System.out.println();

	}
	
	@DataProvider
	public Object[][] dp() {
		
		Map<String, String> header = new HashMap<String, Boolean>();
		Map<String, int[]> params = new HashMap<String, int[]>();
		
		
		return new Object[][] {
				new Object[] { header.put(null, null), params.put("RoleIDs", {1,2,3} ) },
				
				new Object[] { header.put("User", false), params.put("RoleID", 10) }};
				
	}



}
