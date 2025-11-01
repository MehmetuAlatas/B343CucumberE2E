@e2e
Feature: Product End-to-End Test
  As an admin user
  I want to perform product CRUD operations end-to-end
  So that I can verify API and Database integration

  @api_admin
  Scenario: TC01 Admin creates a product via API in end-to-end flow
    Given the API base URL is configured for end-to-end test
    And the request payload is prepared for end-to-end workflow
    When admin sends POST request to create product in end-to-end flow
    Then response status code should be 200 in end-to-end test
    And product should be created successfully in end-to-end flow

  @database
  Scenario: TC02 Admin validates the created product exists in Database
    Given database connection is established for end-to-end validation
    When admin queries the created product in end-to-end workflow
    Then product should exist in database for end-to-end test

  @api_admin
  Scenario: TC03 Admin deletes the product via API in end-to-end flow
    Given API is configured for delete operation in end-to-end test
    When admin sends DELETE request in end-to-end workflow
    Then response status code should be 200 in end-to-end test
    And product should be deleted successfully in end-to-end flow