package com.snackattack.stepdefs;

import io.cucumber.java.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import com.snackattack.utilities.Authentication;
import com.snackattack.utilities.ConfigReader;

public class Hook {

        /*
    Hooks classimizda @apie2e tagi ile api testlerine özel bir setup method olusturduk
    Bu sayede base url gibi ayri bir yapiya ihtiyac kalmadi, daha sade oldu
     @Before("@apie2e") kullanimi ile her scenariodan önce degil sadece bizim belirttigimiz
     taga sahip olan scenariolar icin özellestirmis olduk
     */

    public static RequestSpecification spec;

    @Before("@api_admin")
    public void adminSetUp() throws Exception {
        System.out.println("hook classtaki admin methodu calisti");
        setupApiTest(ConfigReader.getProperty("adminEmail"), ConfigReader.getProperty("adminPassword"));
    }

    @Before("@api_user")
    public void userApiSetUp() throws Exception {
         setupApiTest(ConfigReader.getProperty("userEmail"), "userPassword");
    }

    @Before("@api_employee")
    public void employeeApiSetUp() throws Exception {
        setupApiTest(ConfigReader.getProperty("employeeEmail"), "employeePassword");
    }


    public static void setupApiTest(String email, String password) throws Exception {
        System.out.println("setupApiTest methodu calisti gardas "+email+" email pasword"+password);
        spec = new RequestSpecBuilder()
                .setBaseUri(ConfigReader.getProperty("baseUrl"))
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer " + Authentication.generateToken(email, password))
                .build();
    }

}