package com.authorize.setupService;

import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class GetLogicalRolesAPITest extends BaseSetupServiceApi{
	
	@Test
	public void testGetLogicalRolesAPI ()
			throws JSONException {
		
		Response responseAPI = getAPIResponse(null, "getLogicalRoles", "GET");

		if (responseAPI.getStatusCode() == 200) {
			
			Assert.assertNotNull(responseAPI.jsonPath().getList("Data.ID"));
			Assert.assertNotNull(responseAPI.jsonPath().getList("Data.Name"));
			Assert.assertNotNull(responseAPI.jsonPath().getList("Data.Description"));

		} else {

			Assert.assertNull(responseAPI.jsonPath().getList("Data"), "Response Data is not null");
			Assert.assertNotNull(responseAPI.jsonPath().getString("Reasons.ReasonCode"));
		}

		System.out.println("**********Response from [getLogicalRoles]**********");
		System.out.println(responseAPI.getBody().asString());
		System.out.println();

	}



}
