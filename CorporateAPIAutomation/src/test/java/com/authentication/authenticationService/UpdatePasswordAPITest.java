package com.authentication.authenticationService;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jayway.restassured.response.Response;

import dataProvider.Excel2Json;

public class UpdatePasswordAPITest extends BaseAuthenticationServiceApi {

	@Test(dataProvider = "getRequestJSON", dataProviderClass = Excel2Json.class)
	public void testUpdatePasswordAPI(JSONObject requestJSON)
			throws JSONException, InterruptedException, JsonProcessingException {

		Response responseJSON = getAPIResponse(requestJSON, "POST", "updatePassword");

		if ( responseJSON.getStatusCode() == 200 ) {
			Assert.assertEquals(responseJSON.jsonPath().getString("Params.Password"),
					requestJSON.getJSONObject("Params").getString("Password"), "Password not found on Response Params");
			Assert.assertEquals(responseJSON.jsonPath().getString("Params.ConfirmPassword"),
					requestJSON.getJSONObject("Params").getString("ConfirmPassword"), "ConfirmPassword not found on Response Params");
			
			if (responseJSON.getCookie("JSESSIONID") != null) {	
				Assert.assertEquals(responseJSON.jsonPath().getString("Params.ExistingPassword"),
						requestJSON.getJSONObject("Params").getString("ExistingPassword"), "ExistingPassword not found on Response Data");
			} else {
				Assert.assertEquals(responseJSON.jsonPath().getString("Params.PasswordResetToken"),
						requestJSON.getJSONObject("Params").getString("PasswordResetToken"), "PasswordResetToken not found on Response Params");
			}
			
			Assert.assertNull(responseJSON.jsonPath().getString("Data"), "Response Data is not null");

		} else {
			Assert.assertNull(responseJSON.jsonPath().getString("Data"), "Response Data is not null");
			Assert.assertNotNull(responseJSON.jsonPath().getString("Params"));
			Assert.assertNotNull(responseJSON.jsonPath().getString("Reasons.ReasonCode"));
		}

		System.out.println("**********Response from [updatePassword]**********");
		System.out.println(responseJSON.getBody().asString());
		System.out.println();

	}

}
