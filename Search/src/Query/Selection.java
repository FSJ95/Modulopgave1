package Query;

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

}
