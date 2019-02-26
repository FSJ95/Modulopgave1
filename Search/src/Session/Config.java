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
    private String ageBracket = "";
    private String type = "til/fra flytning";
    private int year = 0;
    private String gender = "";
    private String toCity = "";
    private String fromCity = "";
    private String movementCity = "";
    private String movementType = "";
    private int chosenMenu = 1;

    // Konstruktor.
    public Config() {

    }

    // Konstruktor med connection input.
    public Config(String sqlHost, String sqlUsername, String sqlPassword) {
        this.sqlHost = sqlHost;
        this.sqlUsername = sqlUsername;
        this.sqlPassword = sqlPassword;
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

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String ageBracket() {
        return ageBracket;
    }

    public void ageBracket(String ageBracket) {
        this.ageBracket = ageBracket;
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

    public String getMovementCity() {
        return movementCity;
    }

    public void setMovementCity(String movementCity) {
        this.movementCity = movementCity;
    }

    public String getMovementType() {
        return movementType;
    }

    public void setMovementType(String movementType) {
        this.movementType = movementType;
    }

    public int getChosenMenu() {
        return chosenMenu;
    }

    public void setChosenMenu(int chosenMenu) {
        this.chosenMenu = chosenMenu;
    }

}

