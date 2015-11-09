package authentication.authorize;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.testng.annotations.Test;
import utilities.dataProvider.Excel2ConfigKey;

import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

/**
 * Created by sazzad on 11/9/15.
 */
public class RoleTest {
    @Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
    public void testInsertRoleAPI(Map<String, String> config) throws JSONException {
        // Building request using requestSpecBuilder
        RequestSpecBuilder builder = new RequestSpecBuilder();
        // Setting API's body
        String requestJSON = config.get("Param");
        builder.setBody(requestJSON);
        // Setting content type as application/json or application/xml
        builder.setContentType("application/json; charset=UTF-8");

        RequestSpecification requestSpec = builder.build();

        Response responseJSON =
                given()
                        .spec(requestSpec)
                        .when()
                        .post(config.get("URL"))
                        .then()
                        .statusCode(200)
                        .body(matchesJsonSchemaInClasspath(config.get("SchemaPath")))
                        .extract().response();

    }
    @Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
    public void testUpdateRoleAPI(Map<String, String> config) throws JSONException {
        // Building request using requestSpecBuilder
        RequestSpecBuilder builder = new RequestSpecBuilder();
        // Setting API's body
        String requestJSON = config.get("Param");
        builder.setBody(requestJSON);
        // Setting content type as application/json or application/xml
        builder.setContentType("application/json; charset=UTF-8");

        RequestSpecification requestSpec = builder.build();

        Response responseJSON =
                given()
                        .spec(requestSpec)
                        .when()
                        .post(config.get("URL"))
                        .then()
                        .statusCode(200)
                        .body(matchesJsonSchemaInClasspath(config.get("SchemaPath")))
                        .extract().response();

    }
    @Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
    public void testDeleteRoleAPI(Map<String, String> config) throws JSONException {
        // Building request using requestSpecBuilder
        RequestSpecBuilder builder = new RequestSpecBuilder();
        // Setting API's body
        String requestJSON = config.get("Param");
        builder.setBody(requestJSON);
        // Setting content type as application/json or application/xml
        builder.setContentType("application/json; charset=UTF-8");

        RequestSpecification requestSpec = builder.build();

        Response responseJSON =
                given()
                        .spec(requestSpec)
                        .when()
                        .post(config.get("URL"))
                        .then()
                        .statusCode(200)
                        .body(matchesJsonSchemaInClasspath(config.get("SchemaPath")))
                        .extract().response();

    }

}
