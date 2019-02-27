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
    private int rows = 10;
    private int ageBracket = 1;
    private int year = 1;
    private int gender = 1;
    private int toCity = 1;
    private int fromCity = 1;
    private int movementCity = 1;
    private int movementType = 1;
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

    public int getAgeBracket() {
        return ageBracket;
    }

    public void setAgeBracket(int ageBracket) {
        this.ageBracket = ageBracket;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getToCity() {
        return toCity;
    }

    public void setToCity(int toCity) {
        this.toCity = toCity;
    }

    public int getFromCity() {
        return fromCity;
    }

    public void setFromCity(int fromCity) {
        this.fromCity = fromCity;
    }

    public int getMovementCity() {
        return movementCity;
    }

    public void setMovementCity(int movementCity) {
        this.movementCity = movementCity;
    }

    public int getMovementType() {
        return movementType;
    }

    public void setMovementType(int movementType) {
        this.movementType = movementType;
    }

    public int getChosenMenu() {
        return chosenMenu;
    }

    public void setChosenMenu(int chosenMenu) {
        this.chosenMenu = chosenMenu;
    }

}

