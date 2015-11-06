package com.authorize.setupService;

import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class GetLogicalRolesAPITest extends BaseSetupServiceApi{
	
	@Test
	public void testGetLogicalRolesAPI ()
			throws JSONException {
		
		Response responseJSON = getAPIResponse(null, "getLogicalRoles", "GET");

		if (responseJSON.getStatusCode() == 200) {
			
			Assert.assertNotNull(responseJSON.jsonPath().getList("Data.ID"));
			Assert.assertNotNull(responseJSON.jsonPath().getList("Data.Name"));
			Assert.assertNotNull(responseJSON.jsonPath().getList("Data.Description"));

		} else {

			Assert.assertNull(responseJSON.jsonPath().getList("Data"), "Response Data is not null");
			Assert.assertNotNull(responseJSON.jsonPath().getString("Reasons.ReasonCode"));
		}

		System.out.println("**********Response from [getLogicalRoles]**********");
		System.out.println(responseJSON.getBody().asString());
		System.out.println();

	}



}
