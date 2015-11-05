package authentication;

import static com.jayway.restassured.RestAssured.basic;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;

import org.json.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class BaseAuthenticationServiceApi {

	@BeforeClass
	public void setUp() {
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI = "https://10.0.0.107:8443";
		RestAssured.basePath = "/authentication/authenticationService/";
		RestAssured.authentication = basic("joeAdmin","123");
	}

	public Response getAPIResponse( JSONObject requestJSON, String requestMethod, String api ) throws JsonProcessingException {

		Response responseAPI = null;

		if ( !(null == requestJSON) ) {
			// Building request using requestSpecBuilder
			RequestSpecBuilder builder = new RequestSpecBuilder();

			// Setting API's body
			builder.setBody(requestJSON);

			// Setting content type as application/json or application/xml
			builder.setContentType("application/json; charset=UTF-8");

			RequestSpecification requestSpec = builder.build();

			if ( requestMethod.equalsIgnoreCase("GET") ) {

				responseAPI = 
						given()
							.spec(requestSpec)
						.when()
							.get("/"+ api)
						.then()
							.extract().response();

			} else if ( requestMethod.equalsIgnoreCase("POST") ) {

				responseAPI = 
						given()
							.spec(requestSpec)
						.when()
							.post("/"+ api)
						.then()
							.extract().response();

			} else {

				System.out.println("Request Method doesn't match");
				return null;
			}

		} else {

			if ( requestMethod.equalsIgnoreCase("GET") ) {

				responseAPI = 
						when()
						.get("/"+ api)
						.then()
						.extract().response();

			} else if ( requestMethod.equalsIgnoreCase("POST") ) {

				responseAPI = 
						when()
						.post("/"+ api)
						.then()
						.extract().response();

			} else {

				System.out.println("Request Method doesn't match");
				return null;
			}
		}
		return responseAPI;

	}		


	@AfterMethod
	public void afterMethod() {

	}

}
