package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class TestsOnLocalAPI {

    //    @Test
    public void get() {

        baseURI = "http://localhost:3000";
        given().
                get("/users").
                then().statusCode(200).log().all();
    }

    //    @Test
    public void post() {

        // Creating a new user
        JSONObject userRequest = new JSONObject();
        userRequest.put("firstName", "Lawrence");
        userRequest.put("lastName", "Waititu");
        userRequest.put("subjectId", 1);

        // Creating a new subject
        JSONObject subjectRequest = new JSONObject();
        subjectRequest.put("name", "Product Manager");

        baseURI = "http://localhost:3000";

        // Posting the new user
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(userRequest.toJSONString()).
        when()
                .post("/users")
                        .
        then()
                .statusCode(201);

        // Posting the new subject
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(subjectRequest.toJSONString()).
        when()
                .post("/subjects")
                        .
        then()
                .statusCode(201);

    }

    //    @Test
    public void put() {

        // Updating user
        JSONObject userRequest = new JSONObject();
        userRequest.put("firstName", "Ryan");
        userRequest.put("lastName", "Rynolds");
        userRequest.put("subjectId", 5);

        // Updating subject
        JSONObject subjectRequest = new JSONObject();
        subjectRequest.put("name", "CTO");

        baseURI = "http://localhost:3000";

        // Posting updated user
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(userRequest.toJSONString()).
        when()
                .put("/users/4")
                        .
        then()
                .statusCode(200);

        // Posting updated subject
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(subjectRequest.toJSONString()).
        when()
                .put("/subjects/3")
                        .
        then()
                .statusCode(200);

    }

//    @Test
    public void patch() {

        // Updating user
        JSONObject userRequest = new JSONObject();
        userRequest.put("firstName", "Stallion");

        // Updating subject
        JSONObject subjectRequest = new JSONObject();
        subjectRequest.put("name", "CTXX");

        baseURI = "http://localhost:3000";

        // Posting updated user
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(userRequest.toJSONString()).
        when()
                .patch("/users/4")
                        .
        then()
                .statusCode(200);

        // Posting updated subject
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(subjectRequest.toJSONString()).
        when()
                .patch("/subjects/3")
                        .
        then()
                .statusCode(200);
    }

    @Test
    public void delete() {

        // Updating user
        JSONObject userRequest = new JSONObject();
        userRequest.put("firstName", "Stallion");

        // Updating subject
        JSONObject subjectRequest = new JSONObject();
        subjectRequest.put("name", "CTXX");

        baseURI = "http://localhost:3000";

        // Deleting updated user
        when()
                .delete("/users/4")
                        .
        then()
                .statusCode(200);

        // Deleting updated subject
        when()
                .delete("/subjects/3")
                        .
        then()
                .statusCode(200);
    }
}
