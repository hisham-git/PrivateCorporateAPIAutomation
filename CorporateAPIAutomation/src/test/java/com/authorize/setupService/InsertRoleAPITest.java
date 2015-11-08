package com.authorize.setupService;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

import dataProvider.Excel2Json;

public class InsertRoleAPITest extends BaseSetupServiceApi {

	@Test(dataProvider = "getRequestJSON", dataProviderClass = Excel2Json.class)
	public void testInsertRoleAPI(JSONObject requestJSON) throws JSONException, JsonProcessingException {

		Response responseJSON = getAPIResponse(requestJSON, "POST", "insertRole");

		if (responseJSON.getStatusCode() == 200) {

			// Success Response should contain request Params
			Assert.assertEquals(responseJSON.jsonPath().getString("Params.Name"),
					requestJSON.getJSONObject("Params").getString("Name"), "Name not found on Response Params");
			Assert.assertEquals(responseJSON.jsonPath().getString("Params.Description"),
					requestJSON.getJSONObject("Params").getString("Description"), "Description not found on Response Params");
			Assert.assertEquals(responseJSON.jsonPath().getList("Params.LogicalRoles"),
					requestJSON.getJSONObject("Params").getJSONArray("LogicalRoles"), "LogicalRoles not found on Response Params");

			// Success Response Data Assertions
			Assert.assertNotNull(responseJSON.jsonPath().getString("Data.ID"));
			Assert.assertNotNull(responseJSON.jsonPath().getString("Data.oca"));
			Assert.assertEquals(responseJSON.jsonPath().getString("Data.Name"),
					requestJSON.getJSONObject("Params").getString("Name"), "Name not found on Response Params");
			Assert.assertEquals(responseJSON.jsonPath().getString("Data.Description"),
					requestJSON.getJSONObject("Params").getString("Description"), "Description not found on Response Params");
			Assert.assertEquals(responseJSON.jsonPath().getList("Data.LogicalRoles"),
					requestJSON.getJSONObject("Params").getJSONArray("LogicalRoles"), "LogicalRoles not found on Response Params");

		} else {

			// Failure Response should contain request Params
			Assert.assertEquals(responseJSON.jsonPath().getString("Params.Name"),
					requestJSON.getJSONObject("Params").getString("Name"), "Name not found on Response Params");
			Assert.assertEquals(responseJSON.jsonPath().getString("Params.Description"),
					requestJSON.getJSONObject("Params").getString("Description"), "Description not found on Response Params");
			Assert.assertEquals(responseJSON.jsonPath().getList("Params.LogicalRoles"),
					requestJSON.getJSONObject("Params").getJSONArray("LogicalRoles"), "LogicalRoles not found on Response Params");			

			// Failure Response Data should be null 
			Assert.assertNull(responseJSON.jsonPath().getString("Data"), "Response Data is not null");
			
			// Failure Response should have reason code
			Assert.assertNotNull(responseJSON.jsonPath().getString("Reasons.ReasonCode"));
		}

		System.out.println("**********Response from [insertRole]**********");
		System.out.println(responseJSON.getBody().asString());
		System.out.println();

	}

}
