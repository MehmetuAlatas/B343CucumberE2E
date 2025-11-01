package com.snackattack.stepdefs.e2e_stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.snackattack.utilities.ConfigReader;
import com.snackattack.utilities.TestData;

import java.sql.*;

import static org.junit.Assert.assertEquals;

public class DB_UserRegisterStepDefs {
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    @Given("the Admin is connected to the Database")
    public void theAdminIsConnectedToTheDatabase() throws SQLException {
        connection = DriverManager.getConnection(
                ConfigReader.getProperty("dbUrl"),
                ConfigReader.getProperty("dbUser"),
                ConfigReader.getProperty("dbPassword")
        );
    }

    @When("the Admin executes a query to retrieve the created user")
    public void theAdminExecutesAQueryToRetrieveTheCreatedUser() throws SQLException {

        statement = connection.createStatement();
        resultSet = statement.executeQuery("select * from t_user where email = '"+ TestData.expectedEmail +"'");

    }

    @Then("the created user should exist in the Database")
    public void theCreatedUserShouldExistInTheDatabase() throws SQLException {
        resultSet.next();

        assertEquals(TestData.expectedFirstName,resultSet.getString("first_name"));
        assertEquals(TestData.expectedLastName,resultSet.getString("last_name"));


        //DB' den gelen phone_number degerini \\D reqexini kullanarak rakam haric her seyi temizleyip sadece rakam kalmasini sagladik
        String actualFormattedPhoneNumber = resultSet.getString("phone_number").replaceAll("\\D", "");

        assertEquals(TestData.expectedPhoneNumber,actualFormattedPhoneNumber);
        assertEquals(TestData.expectedAddress,resultSet.getString("address"));
        assertEquals(TestData.expectedZipCode,resultSet.getString("zip_code"));

        TestData.userId = resultSet.getInt("id");


    }

}
