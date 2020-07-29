package RestAssuredBDD;


import io.restassured.response.Response;
import org.testng.annotations.Test;


import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BddTC2 {

    @Test

    public void validations(){

        given()
                .when().get("https://jsonplaceholder.typicode.com/posts/5")
                .then().statusCode(200).log().all();

    }
    @Test
    public void singleValidation(){

        //JSONObject json = new JSONObject();

        given()
                .when().get("https://jsonplaceholder.typicode.com/posts/5")
                .then().statusCode(200). body("title",equalTo("nesciunt quas odio")).log().all();


    }

    @Test
    public void accessToken(){
                 Response response = given()
                .formParam("client_id","Bob")
                .formParam("client_secret","ef78cf403695aa5d2f586b0f21aaee7e")
                .formParam("grant_type","client_credentials")
                .post("http://coop.apps.symfonycasts.com/token");


        //System.out.println(response.jsonPath().prettify());
        String token = response.jsonPath().get("access_token");

        Response res = given()
                .auth()
                .oauth2(token)
                .post("http://coop.apps.symfonycasts.com/api/1215/chickens-feed");
        System.out.println(res.statusCode());
        System.out.println(res.getBody().asString());

    }
    @Test(enabled = false)

    public void multipart(){

        given().header("Content-Type","multipart/form-data")
                .multiPart("file",new File(""))
                .formParam("description","document name")
                .when().post("url")
                .then().assertThat().statusCode(200);
    }
    @Test(enabled = false)

    public void multipartImage(){

        String file = "/Users/Downloads/file.png";

        Response res = given()

                .header("Accept", "application/json")
                .header("Content-type", "multipart/form-data")
                .formParam("token", "08bc73deff88dd3d44bb1bf65b55d4ff")
                .multiPart("asset", "image/png", file).when()
                .post("api/endpoint");

        System.out.println(res.getStatusCode());

        System.out.println(res.jsonPath().prettify());




    }







}
