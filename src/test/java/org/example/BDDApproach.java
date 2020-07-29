package org.example;

import org.junit.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BDDApproach {

    @Test

    public void getRequest(){
        given().when().get("https://api.talentscreen.io/v1/subjects/2").then()
        .assertThat().statusCode(200);
    }




}
