package com.authorize.checkService;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class GetUserActionsAPI2Test extends BaseCheckServiceApi {
	
	@Test
	public void testGetUserActionsAPI()
			throws JSONException, JsonProcessingException {

		Response responseJSON = getAPIResponse(null, "POST", "getUserActions");

		if (responseJSON.getStatusCode() == 200) {

			if ( (responseJSON.getCookie("JSESSIONID")) != null) {
				Assert.assertNotNull(responseJSON.jsonPath().getList("Data.ID"));
				Assert.assertNotNull(responseJSON.jsonPath().getList("Data.oca"));
				Assert.assertNotNull(responseJSON.jsonPath().getList("Data.Module"));
				Assert.assertNotNull(responseJSON.jsonPath().getList("Data.Service"));
				Assert.assertNotNull(responseJSON.jsonPath().getList("Data.Action"));
			} else {
				Assert.assertNull(responseJSON.jsonPath().getList("Data"), "Response Data is not null for Guest user");
			}
			
		} else {
			Assert.assertNull(responseJSON.jsonPath().getList("Data"), "Response Data is not null");
			Assert.assertNotNull(responseJSON.jsonPath().getString("Reasons.ReasonCode"));
		}

		System.out.println("**********Response from [getUserActions]**********");
		System.out.println(responseJSON.getBody().asString());
		System.out.println();

		}



}
