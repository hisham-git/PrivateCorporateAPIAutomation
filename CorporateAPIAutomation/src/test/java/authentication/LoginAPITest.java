package authentication;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jayway.restassured.response.Response;

import dataProvider.Excel2Json;

public class LoginAPITest extends BaseAuthenticationServiceApi {

	@Test(dataProvider = "getRequestJSON", dataProviderClass = Excel2Json.class)
	public void testLoginAPI(JSONObject requestJSON) throws JSONException, InterruptedException, JsonProcessingException {

		Response responseAPI = getAPIResponse(requestJSON, "login", "POST");

		if (responseAPI.getStatusCode() == 200) {

			Assert.assertEquals(responseAPI.jsonPath().getString("Params.UserName"),
					requestJSON.getJSONObject("Params").getString("UserName"), "UserName not found on Response Params");			
			Assert.assertNotNull(responseAPI.jsonPath().getString("Data.LastName"));
			Assert.assertNotNull(responseAPI.jsonPath().getString("Data.FirstName"));

		} else {
			
			Assert.assertEquals(responseAPI.jsonPath().getString("Params.UserName"),
					requestJSON.getJSONObject("Params").getString("UserName"), "UserName not found on Response Params");
			Assert.assertNull(responseAPI.jsonPath().getString("Data"), "Response Data is not null");
			Assert.assertNotNull(responseAPI.jsonPath().getString("Reasons.ReasonCode"));
		}

		System.out.println("**********Response from [Login]**********");
		System.out.println(responseAPI.getBody().asString());
		System.out.println();

	}

}
