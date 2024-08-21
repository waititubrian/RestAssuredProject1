package tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsExamples {

    @Test
    public void test_1(){
       Response response = get("https://reqres.in/api/users?page=2");

        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));

        //Assertions
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);

    }

    @Test
    public void test_2(){

        given()
                .get("https://reqres.in/api/users?page=2").
        then()
                .statusCode(200).
                body("data[1].id", equalTo(8))
                .log().all();
    }

}
