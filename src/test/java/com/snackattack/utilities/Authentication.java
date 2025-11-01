package com.snackattack.utilities;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Authentication {

    public static String generateToken(String email, String password) {

        //set the url
        String url = ConfigReader.getProperty("baseUrl")+"/auth/login";
        //set the payload
        String credentials = "{\n" +
                "  \"email\": \""+email+"\",\n" +
                "  \"password\": \""+password+"\"\n" +
                "}";
        //send request get response
        Response response = given().body(credentials).contentType(ContentType.JSON).when().post(url);
        System.out.println("token ahanda buu"+response.jsonPath().getString("token"));

        //get and return token
        return response.jsonPath().getString("token");
    }




}
