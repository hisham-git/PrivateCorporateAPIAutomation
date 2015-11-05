package com.authorize.setupService;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import authentication.BaseAuthenticationServiceApi;

import com.jayway.restassured.response.Response;

import dataProvider.Excel2Json;

public class InsertRoleAPITest extends BaseAuthenticationServiceApi {

	@Test(dataProvider = "getRequestJSON", dataProviderClass = Excel2Json.class)
	public void testInsertRoleAPI(JSONObject requestJSON) throws JSONException {

		Response responseAPI = getAPIResponse(requestJSON, "insertRole", "POST");

		if (responseAPI.getStatusCode() == 200) {

			// Success Response should contain request Params
			Assert.assertEquals(responseAPI.jsonPath().getString("Params.Name"),
					requestJSON.getJSONObject("Params").getString("Name"), "Name not found on Response Params");
			Assert.assertEquals(responseAPI.jsonPath().getString("Params.Description"),
					requestJSON.getJSONObject("Params").getString("Description"), "Description not found on Response Params");
			Assert.assertEquals(responseAPI.jsonPath().getList("Params.LogicalRoles"),
					requestJSON.getJSONObject("Params").getJSONArray("LogicalRoles"), "LogicalRoles not found on Response Params");

			// Success Response Data Assertions
			Assert.assertNotNull(responseAPI.jsonPath().getString("Data.ID"));
			Assert.assertNotNull(responseAPI.jsonPath().getString("Data.oca"));
			Assert.assertEquals(responseAPI.jsonPath().getString("Data.Name"),
					requestJSON.getJSONObject("Params").getString("Name"), "Name not found on Response Params");
			Assert.assertEquals(responseAPI.jsonPath().getString("Data.Description"),
					requestJSON.getJSONObject("Params").getString("Description"), "Description not found on Response Params");
			Assert.assertEquals(responseAPI.jsonPath().getList("Data.LogicalRoles"),
					requestJSON.getJSONObject("Params").getJSONArray("LogicalRoles"), "LogicalRoles not found on Response Params");

		} else {

			// Failure Response should contain request Params
			Assert.assertEquals(responseAPI.jsonPath().getString("Params.Name"),
					requestJSON.getJSONObject("Params").getString("Name"), "Name not found on Response Params");
			Assert.assertEquals(responseAPI.jsonPath().getString("Params.Description"),
					requestJSON.getJSONObject("Params").getString("Description"), "Description not found on Response Params");
			Assert.assertEquals(responseAPI.jsonPath().getList("Params.LogicalRoles"),
					requestJSON.getJSONObject("Params").getJSONArray("LogicalRoles"), "LogicalRoles not found on Response Params");			

			// Failure Response Data should be null 
			Assert.assertNull(responseAPI.jsonPath().getString("Data"), "Response Data is not null");
			
			// Failure Response should have reason code
			Assert.assertNotNull(responseAPI.jsonPath().getString("Reasons.ReasonCode"));
		}

		System.out.println("**********Response from [insertRole]**********");
		System.out.println(responseAPI.getBody().asString());
		System.out.println();

	}

}
