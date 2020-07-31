package org.example;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class JacksonEx {

    //@Test
   /* public void postAPITest() throws JsonGenerationException, JsonMappingException, IOException, IOException {


        HashMap<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("Content-Type", "application/json");

        //jackson API:
        ObjectMapper mapper = new ObjectMapper();
        Users users = new Users("morpheus", "leader"); //expected users obejct

        //object to json file:
        mapper.writeValue(new File("/Users/NaveenKhunteta/Documents/APIAutomationHTTPClient/APIAutomationUsingHTTPClient/src/main/java/com/qa/data/users.json"), users);

        //java object to json in String:
        String usersJsonString = mapper.writeValueAsString(users);
        System.out.println(usersJsonString);

        //closebaleHttpResponse = restClient.post(url, usersJsonString, headerMap); //call the API

        //validate response from API:
        //1. status code:
        int statusCode = closebaleHttpResponse.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode, testBase.RESPONSE_STATUS_CODE_201);

        //2. JsonString:
        String responseString = EntityUtils.toString(closebaleHttpResponse.getEntity(), "UTF-8");

        JSONObject responseJson = new JSONObject(responseString);
        System.out.println("The response from API is:"+ responseJson);

        //json to java object:
        Users usersResObj = mapper.readValue(responseString, Users.class); //actual users object
        System.out.println(usersResObj);

        Assert.assertTrue(users.getName().equals(usersResObj.getName()));

        Assert.assertTrue(users.getJob().equals(usersResObj.getJob()));

        System.out.println(usersResObj.getId());
        System.out.println(usersResObj.getCreatedAt());

    }*/



}
