package Session;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Config {


    // Connection settings.
    private Connection conn = null;
    private String sqlHost = "jdbc:mysql://94.231.103.32:3306/zitcom_ga_db?useSSL=false";
    private String sqlUsername = "zitcom_ga";
    private String sqlPassword = "fo76jatosata";

    // Search settings.
    private int rows = 0;
    private String agebracket = "";
    private String type = "til/fra flytning";
    private int year = 0;
    private String gender = "";
    private String toCity = "";
    private String fromCity = "";

    // Konstruktor.
    public Config() {

    }

    // Konstruktor med connection input.
    public Config(String sqlHost, String sqlUsername, String sqlPassword) {
        this.sqlHost = sqlHost;
        this.sqlUsername = sqlUsername;
        this.sqlPassword = sqlPassword;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getAgebracket() {
        return agebracket;
    }

    public void setAgebracket(String agebracket) {
        this.agebracket = agebracket;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    // Metode der returnerer connection.
    public Connection getConnection() {
        try {

            conn = DriverManager.getConnection(sqlHost, sqlUsername, sqlPassword);

        } catch (SQLException e) {

            System.out.println("Exception: " + e);

        }

        return conn;

    }
}

