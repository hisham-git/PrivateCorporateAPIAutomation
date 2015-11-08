package com.authentication.authenticationService;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import authentication.BaseAPIService;

import com.jayway.restassured.RestAssured;

public class BaseAuthenticationServiceApi extends BaseAPIService {

	@BeforeClass
	public void setUp() {
		RestAssured.basePath = "/web-corporate/authentication/authentication/";
	}

	@AfterClass
	public void afterClass() {

	}

}
