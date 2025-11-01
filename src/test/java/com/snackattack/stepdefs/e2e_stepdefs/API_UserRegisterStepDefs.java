package com.snackattack.stepdefs.e2e_stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import com.snackattack.pojos.UserPojo;
import com.snackattack.utilities.TestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static com.snackattack.stepdefs.Hook.spec;

public class API_UserRegisterStepDefs {
    Response response;
    UserPojo expectedData ;

    @Given("The admin sends a GET request to retrieve the created user")
    public void theAdminSendsAGETRequestToRetrieveTheCreatedUser() {
        //https://tp-java-backend-car-rental-30cf76ecf533.herokuapp.com/user/21/auth
        //set the url
        spec.pathParams("first", "user", "second", TestData.userId, "third", "auth");

        //set the expected data
        //send request get response
        response = given(spec).when().get("{first}/{second}/{third}");
        response.prettyPrint();
    }

    @Then("The response should contain the created user details")
    public void theResponseShouldContainTheCreatedUserDetails() {
        //do assertion
        Map<String, Object> actualData = response.as(HashMap.class);

        assertEquals(TestData.expectedFirstName, actualData.get("firstName"));
        assertEquals(TestData.expectedLastName, actualData.get("lastName"));

        //DB' den gelen phone_number degerini \\D reqexini kullanarak rakam haric her seyi temizleyip sadece rakam kalmasini sagladik
        String actualFormattedPhoneNumber = actualData.get("phoneNumber").toString().replaceAll("\\D", "");

        assertEquals(TestData.expectedPhoneNumber, actualFormattedPhoneNumber);
        assertEquals(TestData.expectedAddress, actualData.get("address"));
        assertEquals(TestData.expectedZipCode, actualData.get("zipCode"));

    }

    @Given("The admin sends a DELETE request to remove the created user")
    public void theAdminSendsADELETERequestToRemoveTheCreatedUser() {
          //https://tp-java-backend-car-rental-30cf76ecf533.herokuapp.com/user/21/auth
        //set the url
        spec.pathParams("first", "user", "second", TestData.userId, "third", "auth");

        //set the expected data
        //send request get response
        response = given(spec).when().delete("{first}/{second}/{third}");
        response.prettyPrint();
    }

    @Then("The response should confirm that the user has been deleted")
    public void theResponseShouldConfirmThatTheUserHasBeenDeleted() {
        assertEquals(200,response.statusCode());
        assertTrue(response.asString().contains("User Successfully Deleted"));
    }

    @Given("The admin sends a GET request to retrieve the created user with pojo")
    public void theAdminSendsAGETRequestToRetrieveTheCreatedUserWithPojo() {
         //https://tp-java-backend-car-rental-30cf76ecf533.herokuapp.com/user/21/auth
        //set the url
        spec.pathParams("first", "user", "second", TestData.userId, "third", "auth");

        //set the expected data
        expectedData = new UserPojo(TestData.expectedFirstName,TestData.expectedLastName,TestData.expectedEmail,TestData.expectedPhoneNumber,TestData.expectedAddress,TestData.expectedZipCode);

        //send request get response
        response = given(spec).when().get("{first}/{second}/{third}");
        response.prettyPrint();
    }

    @Then("The response should contain the created user details user with pojo")
    public void theResponseShouldContainTheCreatedUserDetailsUserWithPojo() {
        UserPojo actualData = response.as(UserPojo.class);
        assertEquals(expectedData.getFirstName(),actualData.getFirstName());
        assertEquals(expectedData.getLastName(),actualData.getLastName());
        assertEquals(expectedData.getAddress(),actualData.getAddress());
        assertEquals(expectedData.getZipCode(),actualData.getZipCode());


    }
}
