package RestAssuredBDD;

import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matcher;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class HamcrestEx {

    @Test

    public void test1(){

        String response =

      given()
              .when().get("https://jsonplaceholder.typicode.com/posts/6")
              .then().assertThat().body("userId",equalTo(1))
              .body("title",containsString("eum")).extract().response().asString();

        System.out.println(response);
    }
    @Test
    public void test2(){

        given()
                .when().get("https://reqres.in/api/users?page=2")
                .then().assertThat().body("data.first_name",hasItems("Tobias","Byron","Lindsay"))
                .body("data",hasSize(6))
                .extract().response().asString();
    }
    @Test

    public void test3() {

        String res=
        given()
                .when().get("https://reqres.in/api/users?page=2")
                .then().assertThat().body("data.first_name",anyOf(startsWith("Lin"))).extract().response().asString();

    }
}
