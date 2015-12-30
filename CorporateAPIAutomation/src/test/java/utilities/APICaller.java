package utilities;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class APICaller {

	public static void main(String[] args) {

	    	RestAssured.useRelaxedHTTPSValidation("SSL");
	        
	        System.out.println(AppConstant.BASE_URL + "/dev_api/v1/contacts/2/addresses/10" );
	        
	        Response responseAPI = 
	        		when()
	                	.get(AppConstant.BASE_URL + "/dev_api/v1/contacts/2/addresses/10")
	                .then()
	                	.statusCode(200)
	             //   .body(matchesJsonSchemaInClasspath(jsonSchemaValidatorPath))
	                	.extract().response();
	        
	        System.out.println(responseAPI.toString());
	}
}
