package JacksonPractice;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SerializationEx {

    @Test

public void postRequest(){

    PostData postparam = new PostData();
    postparam.setId(3);
    postparam.setEmail("steve.rogers@reqres.in");
    postparam.setFirstName("Steve");
    postparam.setLastName("Rogers");
    postparam.setAvatar("https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg");

    given()
            .contentType("application/json").body(postparam)
            .when().post("https://reqres.in/api/users")
            .then().assertThat().statusCode(201);

    }
    @Test

    public void getRequest(){

        PostData postparam = get("https://reqres.in/api/users/3").as(PostData.class);
        System.out.println(postparam.getRecord());
        System.out.println(postparam.getFirstName());
        System.out.println(postparam.getEmail());

    }

}
