package Session;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Config {

    private Connection conn = null;
    private String sqlHost = "jdbc:mysql://94.231.103.32:3306/zitcom_ga_db";
    private String sqlUsername = "zitcom_ga";
    private String sqlPassword = "fo76jatosata";

    // Konstruktor.
    public Config() {

    }

    // Konstruktor med input.
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
}

