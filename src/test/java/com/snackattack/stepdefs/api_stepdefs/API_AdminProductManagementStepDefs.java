package com.snackattack.stepdefs.api_stepdefs;

import com.snackattack.pojos.CreateProductPayloadPojo;
import com.snackattack.pojos.CreateProductResponsePojo;
import com.snackattack.utilities.ReusableMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;


import java.util.HashMap;
import java.util.Map;

import static com.snackattack.stepdefs.Hook.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class API_AdminProductManagementStepDefs {

    static CreateProductPayloadPojo payload;
    CreateProductResponsePojo actualData;
    Map<String, Object> putPayload;

    Response response;
    static Integer createdProductId;

    @Given("the API base URL is configured")
    public void theAPIBaseURLIsConfigured() {
        spec.pathParam("first", "products");
    }

    @And("the request payload is set up with required fields")
    public void theRequestPayloadIsSetUpWithRequiredFields() {
        payload =
                new CreateProductPayloadPojo("Test product01", "Test product01", "Test contents", 1, 1, 1, false);

    }

    @When("admin sends a POST request to create a new product")
    public void adminSendsAPOSTRequestToCreateANewProduct() {
        response = given(spec).body(payload).when().post("{first}");
        response.prettyPrint();
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
    }

    @And("the product should be created successfully")
    public void theProductShouldBeCreatedSuccessfully() {
        actualData = response.as(CreateProductResponsePojo.class);
        assertEquals(payload.getName(), actualData.getData().getName());
        assertEquals(payload.getDescription(), actualData.getData().getDescription());
        assertEquals(payload.getPrice(), actualData.getData().getPrice());
        assertEquals(payload.getDiscount(), actualData.getData().getDiscount());
        assertEquals(payload.getOrderQuantity(), actualData.getData().getOrderQuantity());

        //--------olusturdugumuz datayi database den get request ile cekeceğimiz icin buradan id yi almayiz------------

        createdProductId = response.jsonPath().getInt("data.id");
    }

    //-------------- @US006_TC02-----get specific product--------------


    @Given("the API base URL is configured for get request")
    public void theAPIBaseURLIsConfiguredForGetRequest() {
        //http://207.154.209.12:8080/products/byId/{{id}}
        spec.pathParams("first", "products", "second", "byId", "third", createdProductId);

    }

    @When("admin sends a GET request to retrieve the product")
    public void adminSendsAGETRequestToRetrieveTheProduct() {
        response = given(spec).when().get("{first}/{second}/{third}");
        response.prettyPrint();
    }

    @And("the product information should be correct")
    public void theProductInformationShouldBeCorrect() {
        actualData = response.as(CreateProductResponsePojo.class);
        assertEquals(payload.getName(), actualData.getData().getName());
        assertEquals(payload.getDescription(), actualData.getData().getDescription());
        assertEquals(payload.getPrice(), actualData.getData().getPrice());
        assertEquals(payload.getDiscount(), actualData.getData().getDiscount());
        assertEquals(payload.getOrderQuantity(), actualData.getData().getOrderQuantity());
    }

    //-------------- @US006_TC03-----put specific product--------------

    @Given("the API base URL is configured for put request")
    public void theAPIBaseURLIsConfiguredForPutRequest() {
        spec.pathParam("first", "products");
    }

    @And("the update payload is set up with new product details")
    public void theUpdatePayloadIsSetUpWithNewProductDetails() {

        //put request icin body olusturulr
        putPayload = new HashMap<>();
        putPayload.put("id", createdProductId);
        putPayload.put("name", "aeae");
        putPayload.put("description", "a");
        putPayload.put("contents", "a");

    }

    @When("admin sends a PUT request to update the product")
    public void adminSendsAPUTRequestToUpdateTheProduct() {
        response = given(spec).body(putPayload).when().put("{first}");
        response.prettyPrint();
    }

    @And("the product should be updated successfully")
    public void theProductShouldBeUpdatedSuccessfully() {
        actualData = response.as(CreateProductResponsePojo.class);
        assertEquals(putPayload.get("name"), actualData.getData().getName());
        assertEquals(putPayload.get("description"), actualData.getData().getDescription());
        assertEquals(putPayload.get("contents"), actualData.getData().getContents());


    }

    //-------------- @US006_TC04-----delete specific product--------------


    @Given("the API base URL is configured for delete request")
    public void theAPIBaseURLIsConfiguredForDeleteRequest() {
        spec.pathParams("first", "products", "second", createdProductId);

    }

    @When("admin sends a DELETE request to remove the product")
    public void adminSendsADELETERequestToRemoveTheProduct() {
        response = given(spec).when().delete("{first}/{second}");
        response.prettyPrint();
    }

    @And("the product should be deleted successfully")
    public void theProductShouldBeDeletedSuccessfully() {
        Assert.assertTrue(response.asString().contains("Product deleted"));
    }
}
