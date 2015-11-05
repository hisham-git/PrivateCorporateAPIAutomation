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
	
		Response responseAPI = getAPIResponse(requestJSON, "login", "POST");

		if (responseAPI.getStatusCode() == 200) {
			
			Assert.assertEquals(responseAPI.jsonPath().getString("Params.RoleID"),
					requestJSON.getJSONObject("Params").getString("RoleID"), "RoleID not found on Response Params");
			Assert.assertNull(responseAPI.jsonPath().getString("Data"), "Response Data is not null");
		
		} else {
			
			Assert.assertEquals(responseAPI.jsonPath().getString("Params.RoleID"),
					requestJSON.getJSONObject("Params").getString("RoleID"), "RoleID not found on Response Params");
			Assert.assertNull(responseAPI.jsonPath().getString("Data"), "Response Data is not null");
			Assert.assertNotNull(responseAPI.jsonPath().getString("Reasons.ReasonCode"));
		}

		System.out.println("**********Response from [deleteRole]**********");
		System.out.println(responseAPI.getBody().asString());
		System.out.println();

	}
	
}
