package RestAssuredBDD;

import io.restassured.RestAssured;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class BDDPractice2 {

    @Test

    public void get(){

        given()
                .when().get("https://reqres.in/api/users/2")
                .then().log().all();
    }
    @Test

    public void post(){

        JSONObject postparam = new JSONObject();
        postparam.put("name","Thor");

        String res =

        given().contentType("application/json").body(postparam.toJSONString())
                .when().post("https://reqres.in/api/users/2")
                .then().extract().response().asString();

        System.out.println(res);
    }
}
