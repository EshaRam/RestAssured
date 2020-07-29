package RestAssuredBDD;

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BDDpractice {

    @Test

    public void requests(){

        given()
                .when().get("https://reqres.in/api/users/2")
                .then().log().all();

    }
    @Test
    public void postRequest(){

        JSONObject postparam = new JSONObject();
            postparam.put("name","Steve");

       String res =

        given().contentType("application/json").body(postparam.toJSONString())
                .when().post("https://reqres.in/api/users/2")
                .then().assertThat().statusCode(201).extract().body().asString();
        System.out.println(res);
    }
    @Test
    public void options(){

        given()
                .when().options("https://reqres.in/api/users/2")
                .then().log().all();
    }
    @Test

    public void head(){

        given()
                .when().head("https://reqres.in/api/users/2")
                .then().log().all();
    }
}
