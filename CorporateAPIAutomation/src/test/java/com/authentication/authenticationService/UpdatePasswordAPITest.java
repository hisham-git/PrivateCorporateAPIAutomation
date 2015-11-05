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
	public void testUpdatePasswordApi(JSONObject requestJSON)
			throws JSONException, InterruptedException, JsonProcessingException {

		Response responseAPI = getAPIResponse(requestJSON, "updatePassword", "POST");

		if ( responseAPI.getStatusCode() == 200 ) {
			Assert.assertEquals(responseAPI.jsonPath().getString("Params.Password"),
					requestJSON.getJSONObject("Params").getString("Password"), "Password not found on Response Params");
			Assert.assertEquals(responseAPI.jsonPath().getString("Params.ConfirmPassword"),
					requestJSON.getJSONObject("Params").getString("ConfirmPassword"), "ConfirmPassword not found on Response Params");
			
			if (responseAPI.getCookie("JSESSIONID") != null) {	
				Assert.assertEquals(responseAPI.jsonPath().getString("Params.ExistingPassword"),
						requestJSON.getJSONObject("Params").getString("ExistingPassword"), "ExistingPassword not found on Response Data");
			} else {
				Assert.assertEquals(responseAPI.jsonPath().getString("Params.PasswordResetToken"),
						requestJSON.getJSONObject("Params").getString("PasswordResetToken"), "PasswordResetToken not found on Response Params");
			}
			
			Assert.assertNull(responseAPI.jsonPath().getString("Data"), "Response Data is not null");

		} else {
			Assert.assertNull(responseAPI.jsonPath().getString("Data"), "Response Data is not null");
			Assert.assertNotNull(responseAPI.jsonPath().getString("Params"));
			Assert.assertNotNull(responseAPI.jsonPath().getString("Reasons.ReasonCode"));
		}

		System.out.println("**********Response from [updatePassword]**********");
		System.out.println(responseAPI.getBody().asString());
		System.out.println();

	}

}
