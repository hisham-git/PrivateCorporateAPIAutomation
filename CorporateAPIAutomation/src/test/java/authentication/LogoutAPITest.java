package authentication;

import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jayway.restassured.response.Response;

public class LogoutAPITest extends BaseAuthenticationApi {

	@Test
	public void testLogoutAPI() throws JSONException, JsonProcessingException {

		Response responseJSON = getAPIResponse(null, "POST", "logout");

		if (responseJSON.getStatusCode() == 200) {
			
			Assert.assertNull(responseJSON.jsonPath().getString("Data"), "Response Data is not null");
		//	Assert.assertNull(responseJSON.getCookie("JSESSIONID"), "User session is not cleared");

		} else {
			
			Assert.assertNotNull(responseJSON.jsonPath().getString("Reasons.ReasonCode"));
		}

		System.out.println("**********Response from [logout]**********");
		System.out.println(responseJSON.getBody().asString());
		System.out.println();

	}

}
