package authentication;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import authentication.BaseAPIService;

import com.jayway.restassured.RestAssured;

public class BaseAuthenticationApi extends BaseAPIService {

	@BeforeClass
	public void setUp() {
		RestAssured.basePath = "/web-corporate/authentication/";
		
	}


}
