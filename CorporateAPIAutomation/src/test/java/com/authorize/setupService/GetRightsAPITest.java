package com.authorize.setupService;

import static com.jayway.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import authentication.BaseAuthenticationServiceApi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import dataProvider.Excel2Json;

public class GetRightsAPITest extends BaseAuthenticationServiceApi {
	
	
	@Test(dataProvider = "getRequestJSON", dataProviderClass = Excel2Json.class)
	public void testGetRightsAPI(JSONObject requestJSON) throws JSONException {

		Response responseAPI = getAPIResponse(requestJSON, "getRights", "POST");

		if (responseAPI.getStatusCode() == 200) {
			
			// Success Response should contain request Params
			Assert.assertEquals(responseAPI.jsonPath().getList("Params.RoleIDs"),
					requestJSON.getJSONObject("Params").getJSONArray("RoleIDs"), "RoleIDs not found on Response Params");
	
			// Success Response Data Assertions
			Assert.assertNotNull(responseAPI.jsonPath().getList("Data.Actions"));
			Assert.assertNotNull(responseAPI.jsonPath().getList("Data.Capabilities"));
		
		} else {
			
			// Failure Response Data should be null 
			Assert.assertNull(responseAPI.jsonPath().getString("Data"), "Response Data is not null");
			
			// Failure Response should have reason code
			Assert.assertNotNull(responseAPI.jsonPath().getString("Reasons.ReasonCode"));
		}

		System.out.println("**********Response from [getRights]**********");
		System.out.println(responseAPI.getBody().asString());
		System.out.println();

	}

}
