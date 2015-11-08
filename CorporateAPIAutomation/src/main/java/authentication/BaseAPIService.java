package authentication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;

public abstract class BaseAPIService {
		
	// @BeforeSuite
	public void baseSetUp() {
		RestAssured.useRelaxedHTTPSValidation();
	//	RestAssured.baseURI = "http://10.0.0.12:8080/web-corporate/api/submit/";
	//	RestAssured.baseURI = "http://10.0.0.111:8080";
		RestAssured.baseURI = "http://10.0.0.10:8080/";
		
	//	RestAssured.authentication = basic("joeAdmin","123");
	}
	
	public Response getAPIResponse( JSONObject requestJSON, String requestMethod, String api ) throws JSONException, JsonProcessingException{

		
		Response responseJSON = null;
	

		if ( null != requestJSON ) {
			
			System.out.println(RestAssured.basePath);
			
			// Building request using requestSpecBuilder
			RequestSpecBuilder builder = new RequestSpecBuilder();

			// Setting API's body
			System.out.println(requestJSON.toString());
			
			String requestJSONasString = requestJSON.toString();
			
			builder.setBody(requestJSONasString);

			// Setting content type as application/json or application/xml
			builder.setContentType("application/json; charset=UTF-8");

			RequestSpecification requestSpec = builder.build();
			
		//	System.out.println(requestSpec.toString());

			if ( requestMethod.equalsIgnoreCase("GET") ) {

				responseJSON = 
						given()
							.spec(requestSpec)
						.when()
							.get("/"+ api)
						.then()
							.extract().response();

			} else if ( requestMethod.equalsIgnoreCase("POST") ) {

				responseJSON = 
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

				responseJSON = 
						when()
						.get("/"+ api)
						.then()
						.extract().response();

			} else if ( requestMethod.equalsIgnoreCase("POST") ) {

				responseJSON = 
						when()
						.post("/"+ api)
						.then()
						.extract().response();

			} else {

				System.out.println("Request Method doesn't match");
				return null;
			}
		}
		return responseJSON;

	}

}
