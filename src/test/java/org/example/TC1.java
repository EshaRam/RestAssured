package org.example;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC1 {

    @Test

    public void getRequest(){

        RestAssured.baseURI = "https://reqres.in/";
        RequestSpecification request = RestAssured.given() ;
        Response response = request.request(Method.GET, "/api/users?page=2");
        String responsebody = response.getBody().asString();
        System.out.println(responsebody);

        int statuscode = response.getStatusCode();
        Assert.assertEquals(statuscode, 200);
        System.out.println(statuscode);

        String ctresponse = response.header("Content-Type");
        System.out.println(ctresponse);

        String teresponse = response.header("Transfer-Encoding");
        System.out.println(teresponse);
        Assert.assertEquals(teresponse,"chunked");


    }

}
