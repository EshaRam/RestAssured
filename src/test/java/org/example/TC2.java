package org.example;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class TC2 {

    @Test
    public void headers(){

        RestAssured.baseURI = "https://reqres.in/";
        RequestSpecification request = RestAssured.given();
        Response response = request.request(Method.GET, "/api/users?page=2");

        String responseBody = response.asString();
        System.out.println(responseBody);

        Headers allheaders = response.headers();
        for(Header header: allheaders){
            System.out.println(header.getName() + "-"+ header.getValue());
        }
    }
}
