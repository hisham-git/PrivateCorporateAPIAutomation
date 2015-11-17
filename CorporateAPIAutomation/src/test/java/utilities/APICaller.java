package utilities;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class APICaller {
    static RequestSpecBuilder builder;
    public static void callApi(String url, String body, String jsonSchemaValidatorPath){
        builder = new RequestSpecBuilder();
        builder.setBody(body);
        builder.setContentType("application/json; charset=UTF-8");
        RequestSpecification requestSpec = builder.build();
        given()
            .spec(requestSpec)
        .when()
            .post(url)
        .then()
            .statusCode(200)
            .body(matchesJsonSchemaInClasspath(jsonSchemaValidatorPath))
        .extract().response();
    }
}
