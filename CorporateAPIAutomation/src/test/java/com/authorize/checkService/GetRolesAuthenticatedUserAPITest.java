package com.authorize.checkService;

import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class GetRolesAuthenticatedUserAPITest extends BaseCheckServiceApi {
	
	@Test
	public void testGetRolesAuthenticatedUserAPI()
			throws JSONException {

		Response responseAPI = getAPIResponse(null, "getRolesAuthenticatedUser", "GET");

		if (responseAPI.getStatusCode() == 200) {

			if ( (responseAPI.getCookie("JSESSIONID")) != null) {
				Assert.assertNotNull(responseAPI.jsonPath().getList("Data.ID"));
				Assert.assertNotNull(responseAPI.jsonPath().getList("Data.oca"));
				Assert.assertNotNull(responseAPI.jsonPath().getList("Data.Name"));
				Assert.assertNotNull(responseAPI.jsonPath().getList("Data.Description"));
			} else {
				Assert.assertNull(responseAPI.jsonPath().getList("Data"), "Response Data is not null for Guest user");
			}
			
		} else {
			Assert.assertNull(responseAPI.jsonPath().getList("Data"), "Response Data is not null");
			Assert.assertNotNull(responseAPI.jsonPath().getString("Reasons.ReasonCode"));
		}

		System.out.println("**********Response from [getRolesAuthenticatedUser]**********");
		System.out.println(responseAPI.getBody().asString());
		System.out.println();

		}



}
