import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITests {

    @Test
    void test1(){
        // If you make a static import of the Rest Assured library there will be no need to use Rest Assured before get
//        Response users = RestAssured.get("https://reqres.in/api/users?page=2");
        Response users = get("https://reqres.in/api/users?page=2");

        System.out.println("Users: " + users.asString());
        System.out.println("Status Code: " + users.getStatusCode());
        System.out.println("Body: " + users.getBody().asString());
        System.out.println("Time taken: " + users.getTime());
        System.out.println("Header" + users.getHeader("content-type"));

        // If you want to do some assertions
        int statusCode = users.statusCode();
        Assert.assertEquals(statusCode, 200);

    }
    @Test
    void test2(){

        given().get("https://reqres.in/api/users?page=2").then().statusCode(200);
    }
}
