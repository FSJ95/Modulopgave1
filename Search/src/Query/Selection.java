package Query;

import Session.Config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class Selection {

    public Selection() {

    }

    public String settingValues(String cn1, String cn2, String tableName, int value, Connection conn) {

        String settingName = "";

        try{

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT " + cn1 +
                    " FROM " + tableName + " WHERE " + tableName + "." + cn2 +
                    "=" + value + " ORDER BY " + cn1);
            while (rs.next()){
                settingName = rs.getString(1);
            }
        }
        catch (SQLException e){
            e.getMessage();
        }

        return settingName;


    }

    public String settingOptions(String tableName, Connection conn){

        String optionsPrint = "";

        try{

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName + " ORDER BY 1");

            while (rs.next()){

                String firstRow = rs.getString(1);
                String secondRow = rs.getString(2);

                optionsPrint = (optionsPrint + "(" + firstRow + ")" +
                        " = " + secondRow + "\n");
            }
        }
        catch (SQLException e){
            e.getMessage();
        }

        return optionsPrint;


    }

    public String toFromResults(Config cfg) {


        String toFromPrint = "";

        try{

            Connection conn = cfg.getConnection();

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT Aar.aarstal, Kon.kon_type, Alder.aldersgruppe, fraKommune.kommune_navn, tilKommune.kommune_navn, Flytning.antal FROM Flytning\n" +
                                            "INNER JOIN Aar ON Flytning.aarstal_id = Aar.aarstal_id\n" +
                                            "INNER JOIN Kon ON Flytning.kon_id = Kon.kon_id\n" +
                                            "INNER JOIN Alder ON Flytning.aldersgruppe_id = Alder.aldersgruppe_id\n" +
                                            "INNER JOIN Kommune AS fraKommune ON Flytning.kommune_fra_id = fraKommune.kommune_id\n" +
                                            "INNER JOIN Kommune AS tilKommune ON Flytning.kommune_til_id = tilKommune.kommune_id\n" +
                                            "WHERE Aar.aarstal_id=" + cfg.getYear() + " AND Kon.kon_id=" + cfg.getGender() + " AND Alder.aldersgruppe_id=" + cfg.getAgeBracket() + " AND fraKommune.kommune_id=" + cfg.getFromCity() + " AND tilKommune.kommune_id=" + cfg.getToCity() + "\n" +
                                            "LIMIT " + cfg.getRows());

            while (rs.next()){

                toFromPrint = toFromPrint + (rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) +
                        "  " + rs.getString(4) + "  " + rs.getString(5) + "  " + rs.getString(6));
            }



        }
        catch (SQLException e){
            e.getMessage();
        }

        return toFromPrint;
    }


}
