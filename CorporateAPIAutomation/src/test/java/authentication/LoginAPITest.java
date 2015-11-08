package authentication;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jayway.restassured.response.Response;

import dataProvider.Excel2Json;

public class LoginAPITest extends BaseAuthenticationApi {

	@Test(dataProvider = "getRequestJSON", dataProviderClass = Excel2Json.class)
	public void testLoginAPI(JSONObject requestJSON) throws JSONException, JsonProcessingException {

		Response responseJSON = getAPIResponse(requestJSON, "POST", "login");
		
	//	System.out.println(responseJSON.asString());

		if (responseJSON.getStatusCode() == 200) {
			if ( responseJSON.jsonPath().getList("Reasons") == null ) {
				Assert.assertEquals(responseJSON.jsonPath().getString("Params.UserName"),
						requestJSON.getJSONObject("Params").getString("UserName"), "UserName not found on Response Params");
				Assert.assertEquals(responseJSON.jsonPath().getString("Params.Password"),
						requestJSON.getJSONObject("Params").getString("Password"), "Password not found on Response Params");
				
				Assert.assertEquals(responseJSON.jsonPath().getString("Data.UserName"),
						requestJSON.getJSONObject("Params").getString("UserName"), "UserName not found on Response Data");
			/*	Assert.assertNotNull(responseJSON.jsonPath().getString("Data.LastName"));
				Assert.assertNotNull(responseJSON.jsonPath().getString("Data.FirstName"));*/
			} else {
				System.out.println(responseJSON.jsonPath().getList("Reasons"));
				Assert.assertNotNull(responseJSON.jsonPath().getList("Reasons"), "Reasons field is null");
				Assert.assertNull(responseJSON.jsonPath().getString("Data"), "Response Data is not null");	
			}
			
		}

		System.out.println("**********Response from [Login]**********");
		System.out.println(responseJSON.getBody().asString());
		System.out.println();

	}

}
