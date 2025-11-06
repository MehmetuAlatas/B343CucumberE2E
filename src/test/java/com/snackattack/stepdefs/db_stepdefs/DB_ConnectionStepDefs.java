package snackattack.stepdefs.db_stepdefs;

import com.snackattack.utilities.ConfigReader;
import io.cucumber.java.en.Given;

import java.sql.*;

public class DB_ConnectionStepDefs {

    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;

    @Given("Database baglantisi kurulur")
    public void databaseBaglantisiKurulur() throws SQLException {
        connection = DriverManager.getConnection(
                ConfigReader.getProperty("dbUrl"),
                ConfigReader.getProperty("dbUser"),
                ConfigReader.getProperty("dbPassword")
        );
        statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
        );        System.out.println("✅ Veritabanı bağlantısı kuruldu.");


    }
}
