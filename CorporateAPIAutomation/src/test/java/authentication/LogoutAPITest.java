package authentication;

import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class LogoutAPITest extends BaseAPIService {

	@Test
	public void testLoginAPI() throws JSONException {

		Response responseJSON = getAPIResponse(null, "logout", "POST");

		if (responseJSON.getStatusCode() == 200) {
			
			Assert.assertNull(responseJSON.jsonPath().getString("Data"), "Response Data is not null");
			Assert.assertNull(responseJSON.getCookie("JSESSIONID"), "User session is not cleared");

		} else {
			
			Assert.assertNotNull(responseJSON.jsonPath().getString("Reasons.ReasonCode"));
		}

		System.out.println("**********Response from [logout]**********");
		System.out.println(responseJSON.getBody().asString());
		System.out.println();

	}

}
