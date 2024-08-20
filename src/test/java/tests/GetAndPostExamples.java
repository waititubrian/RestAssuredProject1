package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class GetAndPostExamples {

//    @Test
    public void testGet(){

        baseURI = "https://reqres.in/api/users?page=2";

        given().
                get(baseURI).
                then().
                statusCode(200).
                body("data[4].first_name", equalTo("George")).
                body("data.first_name", hasItems("George", "Rachel"));
    }

    @Test
    public void testPost(){

        //Map is a Key Value collection [Map<K,V> map = new HashMap<K,V>();]
        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("name", "Brian");
//        map.put("job", "QA");
//
//        System.out.println(map);

        JSONObject request = new JSONObject();

        request.put("name", "Brian");
        request.put("job", "QA");

        System.out.println(request.toJSONString());
        baseURI = "https://reqres.in/api/users";

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
            when().
                post(baseURI).
            then().
                statusCode(201).log().all();

    }
}
