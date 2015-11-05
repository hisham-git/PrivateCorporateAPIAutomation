package authentication;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jayway.restassured.response.Response;

import dataProvider.Excel2Json;

public class LogoutAPITest extends BaseAuthenticationServiceApi {

	@Test
	public void testLoginAPI() throws JSONException {

		Response responseAPI = getAPIResponse(null, "logout", "POST");

		if (responseAPI.getStatusCode() == 200) {
			
			Assert.assertNull(responseAPI.jsonPath().getString("Data"), "Response Data is not null");
			Assert.assertNull(responseAPI.getCookie("JSESSIONID"), "User session is not cleared");

		} else {
			
			Assert.assertNotNull(responseAPI.jsonPath().getString("Reasons.ReasonCode"));
		}

		System.out.println("**********Response from [logout]**********");
		System.out.println(responseAPI.getBody().asString());
		System.out.println();

	}

}
