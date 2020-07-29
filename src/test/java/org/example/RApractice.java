package org.example;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RApractice {

    @Test

    public void getRequest(){

       RestAssured.baseURI = "https://reqres.in/";
        RequestSpecification request = RestAssured.given();
        Response response = request.request(Method.GET,"/api/users?page=2");

        String res = response.asString();
        System.out.println(res);

        int statuscode = response.getStatusCode();
        Assert.assertEquals(statuscode,200);

    }

    @Test

    public void postRequest(){

        RestAssured.baseURI = "https://reqres.in/";
        RequestSpecification request = RestAssured.given();

        JSONObject postparam = new JSONObject();
        postparam.put("first_name","Tony");
        postparam.put("last_name","Stark");

        request.header("Content-Type","application/json");
        request.body(postparam.toJSONString());
        Response response = request.request(Method.POST,"/api/users?page=2");

        String res = response.asString();
        System.out.println(res);
    }
}
