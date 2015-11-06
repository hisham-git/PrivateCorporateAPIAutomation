package authentication;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

import dataProvider.Excel2Json;

public class LoginAPITest extends BaseAPIService {

	@Test(dataProvider = "getRequestJSON", dataProviderClass = Excel2Json.class)
	public void testLoginAPI(JSONObject requestJSON) throws JSONException {

		Response responseJSON = getAPIResponse(requestJSON, "login", "POST");

		if (responseJSON.getStatusCode() == 200) {

			Assert.assertEquals(responseJSON.jsonPath().getString("Params.UserName"),
					requestJSON.getJSONObject("Params").getString("UserName"), "UserName not found on Response Params");			
			Assert.assertNotNull(responseJSON.jsonPath().getString("Data.LastName"));
			Assert.assertNotNull(responseJSON.jsonPath().getString("Data.FirstName"));

		} else {
			
			Assert.assertEquals(responseJSON.jsonPath().getString("Params.UserName"),
					requestJSON.getJSONObject("Params").getString("UserName"), "UserName not found on Response Params");
			Assert.assertNull(responseJSON.jsonPath().getString("Data"), "Response Data is not null");
			Assert.assertNotNull(responseJSON.jsonPath().getString("Reasons.ReasonCode"));
		}

		System.out.println("**********Response from [Login]**********");
		System.out.println(responseJSON.getBody().asString());
		System.out.println();

	}

}
