package org.example;


import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetRequest {

    @Test

    public void getRequest() {

        RestAssured.baseURI = "https://reqres.in/";
        String endURL = "/api/users/2";
        RequestSpecification req = RestAssured.given();


        Response res = req.request(Method.GET, endURL);
        int statusCode = res.getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode, 200);

        String jsonPayload = res.asString();
        System.out.println("response payload" + jsonPayload);


        System.out.println("headers" +res.getHeaders());

    }

    @Test

    public void postRequest() {

        RestAssured.baseURI = "https://reqres.in/";
        String endURL = "/api/users/2";
        RequestSpecification req = RestAssured.given();

        req.header("Content-Type", "application/json");
        JSONObject json = new JSONObject();

        json.put("name", "Steve Rogers");
        json.put("job", "Captain America");

        String jsondata = json.toJSONString();
        req.body(jsondata);


        Response res = req.request(Method.POST, endURL);
        int statusCode = res.getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode, 201);

        String jsonPayload = res.asString();
        System.out.println(jsonPayload);


        System.out.println(res.getHeaders());
    }
    @Test

    public void putRequest() {

        RestAssured.baseURI = "https://reqres.in/";
        String endURL = "/api/users/2";
        RequestSpecification req = RestAssured.given();

        req.header("Content-Type", "application/json");
        JSONObject json = new JSONObject();

        json.put("name", "Tony Stark");
        json.put("job", "Ironman");

        String jsondata = json.toJSONString();
        req.body(jsondata);


        Response res = req.request(Method.PUT, endURL);
        int statusCode = res.getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode, 200);

        String jsonPayload = res.asString();
        System.out.println(jsonPayload);


        System.out.println(res.getHeaders());
    }
}