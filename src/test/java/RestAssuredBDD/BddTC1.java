package RestAssuredBDD;

import io.restassured.RestAssured;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;



import static io.restassured.RestAssured.given;


public class BddTC1 {



    @Test

    public void getRequest(){

        given().when().get("https://reqres.in/api/users/2").then()
                .statusCode(200).assertThat().header("Transfer-Encoding","chunked").extract().response().toString();


    }


    @Test

    public void postRequest(){

        JSONObject json = new JSONObject();
        json.put("first_name","Tony");
        json.put("last_name","Stark");

        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.basePath = "/api/users";

        System.out.println(json.toString());

        given().contentType("application/json").body(json.toJSONString())
                .when().post()
               .then().statusCode(201).extract().body().jsonPath().prettify();


    }
    @Test
    public void putRequest(){

        JSONObject requestparams = new JSONObject();
        requestparams.put("name","Thor");
        requestparams.put("job","Asgardian");

        RestAssured.baseURI= "https://reqres.in";
        RestAssured.basePath = "/api/users/2";
        String response =
        given().contentType("application/json").body(requestparams.toJSONString())
                .when().put()
                .then().statusCode(200).extract().response().asString();
        System.out.println(response);
    }
    @Test

    public void validateBody(){

            given().get("https://reqres.in/api/users?page=2")
                    .then()
                    .statusCode(200)
                    .body("data.id[1]",equalTo(8))
                    .body("data.first_name", hasItems("Michael","Lindsay")).
                    log().all();

        }
    }


