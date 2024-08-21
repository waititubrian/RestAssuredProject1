package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

public class PutPatchAndDeleteExamples {

    @Test
    public void testPut(){

        JSONObject request = new JSONObject();

        request.put("name", "Brian");
        request.put("job", "Testing");

        System.out.println(request.toJSONString());
        baseURI = "https://reqres.in/api/users/2";

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString()).
        when()
                .put(baseURI).
        then()
                .statusCode(200).log().all();

    }

    @Test
    public void testPatch(){

        JSONObject request = new JSONObject();

        request.put("name", "Brian");
        request.put("job", "Testing");

        System.out.println(request.toJSONString());
        baseURI = "https://reqres.in/api/users/2";

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString()).
        when()
                .patch(baseURI).
        then()
                .statusCode(200).log().all();

    }

    @Test
    public void testDelete(){

        baseURI = "https://reqres.in/api/users/2";

        when()
                .delete(baseURI).
        then()
                .statusCode(204).log().all();

    }
}
