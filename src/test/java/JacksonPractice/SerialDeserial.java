package JacksonPractice;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class SerialDeserial {
    @Test

    public void postRequest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        PostData postparam = new PostData();
        postparam.setId(3);
        postparam.setEmail("steve.rogers@reqres.in");
        postparam.setFirstName("Steve");
        postparam.setLastName("Rogers");
        postparam.setAvatar("https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg");

        objectMapper.writeValue(new File("/Users/easwarimuthu/IdeaProjects/RestAssuredProject/src/test/java/JacksonPractice/Postdata.json"),postparam);
        String usersJsonString = objectMapper.writeValueAsString(postparam);
        System.out.println(usersJsonString);
        given()
                .contentType("application/json").body(usersJsonString)
                .when().post("https://reqres.in/api/users")
                .then().assertThat().statusCode(201);

    }
}
