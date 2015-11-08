package authentication;

import static com.jayway.restassured.RestAssured.given;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import dataProvider.Excel2Json;

public class LogoutAPI2Test {

	@Test
	public void testLogoutAPI() throws JSONException {

		
		
		// Building request using requestSpecBuilder
					RequestSpecBuilder builder = new RequestSpecBuilder();

					// Setting API's body
					String jsongTest = "{\"Header\": {},\"Params\": {}}";
					//builder.setBody("{"Header": {},"Params": {"UserName": "anik","Password": "12345678"}}");
					builder.setBody(jsongTest);

					// Setting content type as application/json or application/xml
					builder.setContentType("application/json; charset=UTF-8");

					RequestSpecification requestSpec = builder.build();
					
					Response responseJSON =	
								given()
									.spec(requestSpec)
								.when()
									.post("http://10.0.0.111:8080/web-corporate/authentication/logout")
								.then()
									.extract().response();
		
	//	System.out.println(responseJSON.getHeaders());
		System.out.println(responseJSON.getCookies());
		System.out.println(responseJSON.getSessionId());
		System.out.println(responseJSON.getStatusLine());
		
					
		if (responseJSON.getStatusCode() == 200) {

			Assert.assertEquals(responseJSON.jsonPath().getString("Module"),
					"authentication", "authentication not found on Response Module");
			
			Assert.assertEquals(responseJSON.jsonPath().getString("Service"),
					"authentication", "authentication not found on Response Service");
			
			Assert.assertEquals(responseJSON.jsonPath().getString("Action"),
					"logout", "logout not found on Response Action");
			
			Assert.assertNull(responseJSON.jsonPath().getString("Header"), "Response Header is not null");
			Assert.assertNull(responseJSON.jsonPath().getString("Params"), "Response Params is not null");
			Assert.assertNull(responseJSON.jsonPath().getString("Data"), "Response Data is not null");

		} else {
			
			System.out.println("Error from Server side");
		}

		System.out.println("**********Response from [Logout]**********");
		System.out.println(responseJSON.getBody().asString());
		System.out.println();

	}

}
