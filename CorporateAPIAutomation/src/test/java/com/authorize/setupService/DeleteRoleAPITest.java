package com.authorize.setupService;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

import dataProvider.Excel2Json;

public class DeleteRoleAPITest extends BaseSetupServiceApi {
	
	@Test(dataProvider = "getRequestJSON", dataProviderClass = Excel2Json.class)
	public void testDeleteRole(JSONObject requestJSON) throws JSONException {
	
		Response responseJSON = getAPIResponse(requestJSON, "login", "POST");

		if (responseJSON.getStatusCode() == 200) {
			
			Assert.assertEquals(responseJSON.jsonPath().getString("Params.RoleID"),
					requestJSON.getJSONObject("Params").getString("RoleID"), "RoleID not found on Response Params");
			Assert.assertNull(responseJSON.jsonPath().getString("Data"), "Response Data is not null");
		
		} else {
			
			Assert.assertEquals(responseJSON.jsonPath().getString("Params.RoleID"),
					requestJSON.getJSONObject("Params").getString("RoleID"), "RoleID not found on Response Params");
			Assert.assertNull(responseJSON.jsonPath().getString("Data"), "Response Data is not null");
			Assert.assertNotNull(responseJSON.jsonPath().getString("Reasons.ReasonCode"));
		}

		System.out.println("**********Response from [deleteRole]**********");
		System.out.println(responseJSON.getBody().asString());
		System.out.println();

	}
	
}
