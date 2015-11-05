package com.authorize.checkService;

import static com.jayway.restassured.RestAssured.given;

import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class TestGetUserActionsApi extends BaseAuthorizeServiceApi {
	
	  
	  @Test(dataProvider = "dp")
	  public void testGetUserActions (String header, String params) throws JSONException, InterruptedException {

		  RequestSpecification requestSpec = specBuilder(header, params);

			Response responseAPI = 
					given()
						.spec(requestSpec)
					.when()
						.post("/getUserActions")
					.then()
						.extract().response();

			if (responseAPI.getStatusCode() == 200) {
				Assert.assertNotNull(responseAPI.jsonPath().getList("Data.Actions"));
				Assert.assertNotNull(responseAPI.jsonPath().getString("Data.Actions.Action01.ID"));

			} else {
				Assert.assertNull(responseAPI.jsonPath().getString("Data"), "Response Data is not null");
				Assert.assertNotNull(responseAPI.jsonPath().getString("Reasons.ReasonCode"));
			}

			System.out.println("**********Response from [GetUserActions]**********");
			System.out.println(responseAPI.getBody().asString());
			System.out.println();
			
		}

	  @DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { "", "" },
	      new Object[] { null, null },
	      new Object[] { "a", "b" },
	      new Object[] { null, "b" },
	      new Object[] { "", "b" },
	      new Object[] { "a", null },
	      new Object[] { "a", "" }
	    };
	  }


}
