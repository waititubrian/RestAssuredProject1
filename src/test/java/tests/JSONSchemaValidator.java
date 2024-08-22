package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JSONSchemaValidator {

    @Test
    public void testGet (){

        baseURI = "https://reqres.in/api/users?page=2";

        given()
                .get(baseURI).
        then()
                .assertThat().body(matchesJsonSchemaInClasspath("schema.json"))
                .statusCode(200);
    }
}
