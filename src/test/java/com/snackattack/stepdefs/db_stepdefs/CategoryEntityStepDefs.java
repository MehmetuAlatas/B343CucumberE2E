package com.snackattack.stepdefs.db_stepdefs;

import io.cucumber.java.en.*;
import org.junit.Assert;
import java.sql.*;

public class CategoryEntityStepDefs {

    Connection connection;
    Statement statement;
    ResultSet resultSet;

    @Given("Database'e baglan")
    public void database_e_baglan() throws SQLException {
        String dbUrl = "jdbc:postgresql://64.227.123.49:5432/snack_attack_db";
        String dbUser = "postgres";
        String dbPassword = "changeme";

        connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
        );
        System.out.println("✅ Veritabanı bağlantısı kuruldu.");
    }

    @When("category_entity tablosundaki tüm kayıtları al")
    public void category_entity_tablosundaki_tum_kayitlari_al() throws SQLException {
        String query = "SELECT * FROM category_entity;";
        resultSet = statement.executeQuery(query);
        System.out.println("📦 Sorgu çalıştı: " + query);
    }

    @Then("name sutunu boş olmamalıdır")
    public void name_sutunu_bos_olmamalidir() throws SQLException {
        resultSet.beforeFirst();
        boolean bosVarMi = false;

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            if (name == null || name.trim().isEmpty()) {
                System.out.println("⚠️ Boş kategori bulundu! ID: " + resultSet.getInt("id"));
                bosVarMi = true;
            } else {
                System.out.println("✅ Kategori adı: " + name);
            }
        }

        Assert.assertFalse("Bazı kategori adları boş!", bosVarMi);

        resultSet.close();
        statement.close();
        connection.close();
        System.out.println("🔒 Database bağlantısı kapatıldı.");
    }
}
