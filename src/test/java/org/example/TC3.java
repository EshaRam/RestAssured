package org.example;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC3 {

    @Test

    public void postRequest(){

        RestAssured.baseURI = "https://reqres.in/";
        RequestSpecification request = RestAssured.given();

        JSONObject requestparams = new JSONObject();

        requestparams.put("name","xyz");
        requestparams.put("job","watching tv");

        request.header("Content-Type","application/json");
        request.body(requestparams.toJSONString());

        Response response = request.request(Method.POST,"/api/users/2");

        String responsebody = response.asString();
        System.out.println(responsebody);


        int statuscode = response.getStatusCode();
        System.out.println(statuscode);
        Assert.assertEquals(statuscode, 201);
    }
    @Test

    public void putRequest(){

        RestAssured.baseURI = "https://reqres.in/";
        RequestSpecification request = RestAssured.given();

        JSONObject requestparam = new JSONObject();
        requestparam.put("name","pwd");
        requestparam.put("job", "watching tv");

        request.header("Content-Type","application/json");
        request.body(requestparam.toJSONString());

        Response response = request.request(Method.PUT,"/api/users/2");

        String responsebody = response.asString();
        System.out.println(responsebody);

        int statuscode = response.getStatusCode();
        Assert.assertEquals(statuscode,200);

    }

    @Test

    public void patchRequest(){

        RestAssured.baseURI = "https://reqres.in/";
        RequestSpecification request = RestAssured.given();

        JSONObject requestparams = new JSONObject();

        requestparams.put("name","berry");
        requestparams.put("job","farming");

        request.header("Content-Type","application/json");
        request.body(requestparams.toJSONString());

        Response response = request.request(Method.PATCH,"/api/users/2");
        String  responsebody = response.asString();
        System.out.println(responsebody);

        int status = response.getStatusCode();
        Assert.assertEquals(status,200);
    }
    @Test

    public void deleteRequest(){

        RestAssured.baseURI = "https://reqres.in/";
        String endUrl = "/api/users/2";
        RequestSpecification request = RestAssured.given();

        Response response = request.request(Method.DELETE, endUrl);

        int statuscode = response.getStatusCode();
        System.out.println(statuscode);
        Assert.assertEquals(statuscode, 204);
    }
    @Test

    public void headRequest(){

        RestAssured.baseURI = "https://reqres.in/";
        String endUrl = "/api/users/2";
        RequestSpecification request = RestAssured.given();

        Response response = request.request(Method.HEAD);

        String responsebody = response.asString();
        System.out.println(responsebody);

        int statuscode = response.getStatusCode();
        System.out.println(statuscode);
    }
}
