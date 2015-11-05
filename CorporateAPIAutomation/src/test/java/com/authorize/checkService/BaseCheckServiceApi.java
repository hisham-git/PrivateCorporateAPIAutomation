package com.authorize.checkService;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import authentication.BaseAPIService;

import com.jayway.restassured.RestAssured;

public class BaseCheckServiceApi extends BaseAPIService {

	@BeforeClass
	public void setUp() {
		RestAssured.basePath = "/authorize/check/";
	}

	@AfterClass
	public void afterClass() {

	}

}
