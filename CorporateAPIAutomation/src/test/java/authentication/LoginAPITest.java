package authentication;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

import dataProvider.Excel2Json;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginAPITest extends BaseAPIService {

	@Test(dataProvider = "getRequestJSON", dataProviderClass = Excel2Json.class)
	public void testLoginAPI(JSONObject requestJSON) throws JSONException, IOException {

		/*Response responseJSON = getAPIResponse(requestJSON, "login", "POST");

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
		System.out.println();*/
		//System.out.println(requestJSON);
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Map<String,String >> map;
		map = mapper.readValue(String.valueOf(requestJSON), new TypeReference<Map<String, Map<String ,String >>>(){});
		System.out.println(map.get("Params").get("UserName"));
	}

}














