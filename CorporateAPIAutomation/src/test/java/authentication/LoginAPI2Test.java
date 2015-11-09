package authentication;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.dataProvider.Excel2ConfigKey;

import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;


public class LoginAPI2Test {

	@Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
	public void testLoginAPI(Map<String, String> config) throws JSONException {

		// Building request using requestSpecBuilder
		RequestSpecBuilder builder = new RequestSpecBuilder();

		// Setting API's body
		String requestJSON = config.get("Param");

		builder.setBody(requestJSON);

		// Setting content type as application/json or application/xml
		builder.setContentType("application/json; charset=UTF-8");

		RequestSpecification requestSpec = builder.build();

		Response responseJSON =	
				given()
					.spec(requestSpec)
				.when()
					.post(config.get("URL"))
				.then()
					.statusCode(200)
					//.body(matchesJsonSchemaInClasspath(config.get("SchemaPath")))
					.body(matchesJsonSchemaInClasspath("C:\\Users\\HISHAM\\git\\com.corporate.api\\CorporateAPIAutomation\\CorporateAPIAutomation\\src\\test\\resources\\jsonSchema\\login_pass.json"))
					.body("Params.UserName", equalTo("anik"))
					.body("Params.Password", equalTo("12345678"))
					.body("Data.UserName", equalTo("anik"))
					.body("Data.LastName", equalTo("Hoque"))
					.body("Data.FirstName", equalTo("Mushraful"))
					.extract().response();

		
		System.out.println(responseJSON.getCookies());
		System.out.println(responseJSON.getSessionId());
		System.out.println(responseJSON.getStatusLine());

		System.out.println(responseJSON.getBody().asString());

		if (responseJSON.getStatusCode() == 200) {
			if ( responseJSON.jsonPath().getList("Reasons") == null ) {
				Assert.assertEquals(responseJSON.jsonPath().getString("Params.UserName"),
						"anik", "UserName not found on Response Params");
				Assert.assertEquals(responseJSON.jsonPath().getString("Params.Password"),
						"12345678", "UserName not found on Response Params");

				Assert.assertEquals(responseJSON.jsonPath().getString("Data.UserName"),
						"anik", "UserName not found on Response Data");
				Assert.assertNotNull(responseJSON.jsonPath().getString("Data.LastName"));
				Assert.assertNotNull(responseJSON.jsonPath().getString("Data.FirstName"));
			} else {
				System.out.println(responseJSON.jsonPath().getList("Reasons"));
				Assert.assertNotNull(responseJSON.jsonPath().getList("Reasons"), "Reasons field is null");
				Assert.assertNull(responseJSON.jsonPath().getString("Data"), "Response Data is not null");	
			}



			//	Assert.assertNotNull(responseJSON.jsonPath().getString("Data.LastName"));
			//	Assert.assertNotNull(responseJSON.jsonPath().getString("Data.FirstName"));

			/*	} else {

			Assert.assertEquals(responseJSON.jsonPath().getString("Params.UserName"),
					"anik", "UserName not found on Response Params");
			Assert.assertNull(responseJSON.jsonPath().getString("Data"), "Response Data is not null");
			Assert.assertNotNull(responseJSON.jsonPath().getString("Reasons.ReasonCode"));
		}*/

		}

		System.out.println("**********Response from [Login]**********");
		System.out.println(responseJSON.getBody().asString());
		System.out.println();

	}

}
