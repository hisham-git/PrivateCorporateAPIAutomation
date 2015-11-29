package utilities;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Util {
    static RequestSpecBuilder builder;
    public static Response callApi(String url, String body, String jsonSchemaValidatorPath, String JSESSIONID){
    	RestAssured.useRelaxedHTTPSValidation();
    	builder = new RequestSpecBuilder();
        builder.setBody(body);
        builder.setContentType("application/json; charset=UTF-8");
        if (null !=JSESSIONID) {
            builder.addCookie("JSESSIONID", JSESSIONID);
        }
        Response responseAPI = given()
                .spec(builder.build())
                .when()
                .post(AppConstant.BASE_URL + url)
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath(jsonSchemaValidatorPath))
                .extract().response();
        
        return responseAPI;
    }

    public static String getCookie(){
    	RestAssured.useRelaxedHTTPSValidation();
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBody("{\"Header\":{},\"Params\":{\"UserName\":\"ntm\",\"Password\":\"12345678\"}}");
        builder.setContentType("application/json; charset=UTF-8");
        //builder.add
        return given()
                .spec(builder.build())
                .when()
                .post(AppConstant.BASE_URL + "/web-corporate/authentication/login")
                .then()
                .statusCode(200)
                .extract().response().getCookie("JSESSIONID");
    }
}
