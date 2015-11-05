package com.authorize.setupService;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import authentication.BaseAPIService;

import com.jayway.restassured.RestAssured;

public class BaseSetupServiceApi extends BaseAPIService {

	@BeforeClass
	public void setUp() {
		RestAssured.basePath = "/authorize/setup/";
	}

	@AfterClass
	public void afterClass() {

	}

}
