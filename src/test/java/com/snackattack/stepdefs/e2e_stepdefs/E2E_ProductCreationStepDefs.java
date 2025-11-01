package com.snackattack.stepdefs.e2e_stepdefs;

import com.snackattack.pojos.CreateProductPayloadPojo;
import com.snackattack.pojos.CreateProductResponsePojo;
import com.snackattack.stepdefs.Hook;
import com.snackattack.utilities.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import java.sql.*;
import java.util.Map;

import static com.snackattack.stepdefs.Hook.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class E2E_ProductCreationStepDefs {

    Connection connection;
    Statement statement;
    ResultSet resultSet;
    static Integer createdProductId;


    static CreateProductPayloadPojo payload;
    CreateProductResponsePojo actualData;
    Map<String, Object> putPayload;

    Response response;

    @Given("the API base URL is configured for end-to-end test")
    public void theAPIBaseURLIsConfiguredForEndToEndTest() {
        spec.pathParam("first", "products");
    }

    @And("the request payload is prepared for end-to-end workflow")
    public void theRequestPayloadIsPreparedForEndToEndWorkflow() {
        payload =
                new CreateProductPayloadPojo("Test product01", "Test product01", "Test contents", 1, 1, 1, false);

    }

    @When("admin sends POST request to create product in end-to-end flow")
    public void adminSendsPOSTRequestToCreateProductInEndToEndFlow() {
        response = given(spec).body(payload).when().post("{first}");
        response.prettyPrint();
    }

    @Then("response status code should be {int} in end-to-end test")
    public void responseStatusCodeShouldBeInEndToEndTest(int expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);

    }

    @And("product should be created successfully in end-to-end flow")
    public void productShouldBeCreatedSuccessfullyInEndToEndFlow() {
        actualData = response.as(CreateProductResponsePojo.class);
        assertEquals(payload.getName(), actualData.getData().getName());
        assertEquals(payload.getDescription(), actualData.getData().getDescription());
        assertEquals(payload.getPrice(), actualData.getData().getPrice());
        assertEquals(payload.getDiscount(), actualData.getData().getDiscount());
        assertEquals(payload.getOrderQuantity(), actualData.getData().getOrderQuantity());

        //--------olusturdugumuz datayi database den get request ile cekeceğimiz icin buradan id yi almayiz------------

        createdProductId = response.jsonPath().getInt("data.id");
    }

    @Given("database connection is established for end-to-end validation")
    public void databaseConnectionIsEstablishedForEndToEndValidation() throws SQLException {
        connection = DriverManager.getConnection(
                ConfigReader.getProperty("dbUrl"),
                ConfigReader.getProperty("dbUser"),
                ConfigReader.getProperty("dbPassword")
        );
    }

    @When("admin queries the created product in end-to-end workflow")
    public void adminQueriesTheCreatedProductInEndToEndWorkflow() throws SQLException {
        statement = connection.createStatement();//SELECT * FROM snack_attack_db.product where id = 285;
        resultSet = statement.executeQuery("SELECT * FROM snack_attack_db.product where id = " + createdProductId+";");

    }

    @Then("product should exist in database for end-to-end test")
    public void productShouldExistInDatabaseForEndToEndTest() throws SQLException {
        resultSet.next();

        assertEquals(payload.getName(), resultSet.getString("name"));
        assertEquals(payload.getDescription(), resultSet.getString("description"));
        assertEquals(payload.getContents(), resultSet.getString("contents"));
        assertEquals(payload.getPrice(), resultSet.getInt("price"));
        assertEquals(payload.getOrderQuantity(), resultSet.getInt("order_quantity"));
        assertEquals(payload.getDiscount(), resultSet.getInt("discount"));

    }


    @Given("API is configured for delete operation in end-to-end test")
    public void apiIsConfiguredForDeleteOperationInEndToEndTest() {
        spec.pathParams("first", "products", "second", createdProductId);

    }

    @When("admin sends DELETE request in end-to-end workflow")
    public void adminSendsDELETERequestInEndToEndWorkflow() {
        response = given(spec).when().delete("{first}/{second}");
        response.prettyPrint();
    }

    @And("product should be deleted successfully in end-to-end flow")
    public void productShouldBeDeletedSuccessfullyInEndToEndFlow() {
        Assert.assertTrue(response.asString().contains("Product deleted"));

    }
}
