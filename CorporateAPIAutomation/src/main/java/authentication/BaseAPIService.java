package authentication;

import static com.jayway.restassured.RestAssured.basic;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.jayway.restassured.RestAssured;

public abstract class BaseAPIService {
	
	@BeforeClass
	  public void setUp() {
			RestAssured.useRelaxedHTTPSValidation();
			RestAssured.baseURI = "https://10.0.0.107:8443";
			RestAssured.basePath = "/authentication/authenticationService/";
			RestAssured.authentication = basic("joeAdmin","123");
		}

}
