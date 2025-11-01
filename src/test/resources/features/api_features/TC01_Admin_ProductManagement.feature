@US006
Feature: Product API Test
  As an admin user
  I want to perform CRUD operations on products
  So that I can manage the product inventory


  @api_admin @US006_TC01
  Scenario: TC01 Admin should be able to create a new product
    Given the API base URL is configured
    And the request payload is set up with required fields
    When admin sends a POST request to create a new product
    Then the response status code should be 200
    And the product should be created successfully


  @api_admin @US006_TC02
  Scenario: TC02 Admin should be able to view the created product via GET request
    Given the API base URL is configured for get request
    When admin sends a GET request to retrieve the product
    Then the response status code should be 200
    And the product information should be correct

  @api_admin @US006_TC03
  Scenario: TC03 Admin should be able to update the created product via PUT request
    Given the API base URL is configured for put request
    And the update payload is set up with new product details
    When admin sends a PUT request to update the product
    Then the response status code should be 200
    And the product should be updated successfully

  @api_admin @US006_TC04
  Scenario: TC04 Admin should be able to delete the created product via DELETE request
    Given the API base URL is configured for delete request
    When admin sends a DELETE request to remove the product
    Then the response status code should be 200
    And the product should be deleted successfully

