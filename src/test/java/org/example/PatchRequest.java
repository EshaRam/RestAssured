package org.example;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;

public class PatchRequest {

    public void patchRequest() {

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
