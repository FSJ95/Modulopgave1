package UI;

import Session.Config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;


public class Menu {

    private boolean quit = false;
    Config cfg = new Config();


    public void mainMenu() {

        while (!quit) {

            if (cfg.getChosenMenu() == 1) {
                clearScreen();
                showToFromMenu();


                switch (Input.getIntRangeFromConsole(0, 9)) {
                    case 1:
                        // CHANGE MENU
                        changeMenu();
                        break;
                    case 2:
                        // CHANGE LIMIT
                        clearScreen();
                        chooseLimit();
                        break;
                    case 3:
                        // CHANGE YEAR
                        clearScreen();
                        chooseYear();
                        break;
                    case 4:
                        // CHOSE GENDER
                        System.out.println("Nothing here yet :)");
                        Input.pressToContinue();
                        break;
                    case 5:
                        // CHOSE AGE GROUP
                        System.out.println("Nothing here yet :)");
                        Input.pressToContinue();
                        break;
                    case 6:
                        // CHOSE FROM - CITY
                        System.out.println("Nothing here yet :)");
                        Input.pressToContinue();
                        break;
                    case 7:
                        // CHOSE TO - CITY
                        System.out.println("Nothing here yet :)");
                        Input.pressToContinue();
                        break;
                    case 8:
                        // SHOW TABLES FROM SETTINGS
                        System.out.println("Nothing here yet :)");
                        Input.pressToContinue();
                        break;
                    case 9:
                        // SHOW ALL SETTINGS
                        clearScreen();
                        showSettings();
                        Input.pressToContinue();
                        break;
                    case 0:
                        // QUIT PROGRAM
                        quit = true;

                }

            } else if (cfg.getChosenMenu() == 2) {
                clearScreen();
                showMovementMenu();

                switch (Input.getIntRangeFromConsole(0, 9)) {
                    case 1:
                        // CHANGE MENU
                        changeMenu();
                        break;
                    case 2:
                        // CHANGE LIMIT
                        clearScreen();
                        chooseLimit();
                        break;
                    case 3:
                        // CHANGE YEAR
                        clearScreen();
                        chooseYear();
                        break;
                    case 4:
                        // CHOSE GENDER
                        System.out.println("Nothing here yet :)");
                        Input.pressToContinue();
                        break;
                    case 5:
                        // CITY
                        System.out.println("Nothing here yet :)");
                        Input.pressToContinue();
                        break;
                    case 6:
                        // MOVEMENT TYPE
                        System.out.println("Nothing here yet :)");
                        Input.pressToContinue();
                        break;
                    case 8:
                        // SHOW TABLES FROM SETTINGS
                        System.out.println("Nothing here yet :)");
                        Input.pressToContinue();
                        break;
                    case 9:
                        // SHOW ALL SETTINGS
                        clearScreen();
                        showSettings();
                        Input.pressToContinue();
                        break;
                    case 0:
                        // QUIT PROGRAM
                        quit = true;
                }


            }
        }
    }


    private void showToFromMenu() {
        System.out.println(
                        "\nSEARCH TOOL (TO/FROM CITYS)\n" +
                        "-------------------\n" +
                        "1. Change menu \n" +
                        "-------------------\n" +
                        "2. Number of results. \n" +
                        "3. Year. \n" +
                        "4. Gender.  \n" +
                        "5. Age group.  \n" +
                        "6. City moving from.  \n" +
                        "7. City moving to.  \n" +
                        "-------------------\n" +
                        "8. Show results.\n" +
                        "9. Show settings.\n" +
                        "-------------------\n" +
                        "0. Exit program. \n");
    }

    private void showMovementMenu() {
        System.out.println(
                        "\nSEARCH TOOL (MOVEMENT TYPE)\n" +
                        "-------------------\n" +
                        "1. Change menu \n" +
                        "-------------------\n" +
                        "2. Number of results. \n" +
                        "3. Year. \n" +
                        "4. Gender.  \n" +
                        "5. City.  \n" +
                        "6. Movement type.  \n" +
                        "-------------------\n" +
                        "8. Show results.\n" +
                        "9. Show settings.\n" +
                        "-------------------\n" +
                        "0. Exit program. \n");
    }

    public void changeMenu(){
        if (cfg.getChosenMenu()==1){
            cfg.setChosenMenu(2);
        } else {
            cfg.setChosenMenu(1);
        }

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void chooseLimit(){
        System.out.println("How many rows do you want?");
        cfg.setRows(Input.getIntFromConsole());
    }
    public void chooseYear(){
        System.out.println("Vælg Årstal");
        cfg.setYear(Input.getIntFromConsole());
    }
    private void dbSearch(){

        try{

            Connection sqlCon = cfg.getConnection();
            Statement stmt = sqlCon.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Aar.aarstal, Flytning.antal, til.kommune_navn AS tilKommune, fra.kommune_navn AS fraKommune, Kon.kon_type, Alder.aldersgruppe FROM Flytning INNER JOIN Kommune AS til ON Flytning.kommune_til_id = til.kommune_id INNER JOIN Kommune AS fra ON Flytning.kommune_fra_id = fra.kommune_id INNER JOIN Kon ON Flytning.kon_id = Kon.kon_id INNER JOIN Alder ON Flytning.aldersgruppe_id = Alder.aldersgruppe_id INNER JOIN Aar ON Flytning.aarstal_id = Aar.aarstal_id LIMIT 100");
            while (rs.next()){
                System.out.println("---------------------------------------------");

                System.out.println("Antal: " + rs.getInt("antal")+
                        " År: "+rs.getInt("aarstal")+
                        " fra Kommune: "+rs.getString("fraKommune")+
                        " til Kommune: "+rs.getString("tilKommune")+
                        " Køn: "+rs.getString("kon_type")+
                        " Aldersgruppe: "+rs.getString("aldersgruppe")
                        );

                //System.out.println("Antal" + rs.getInt("antal"));
                System.out.println("---------------------------------------------");
            }
        }
        catch (SQLException e){
            e.getMessage();
        }


    }
    private void showSettings() {
        System.out.println(
                        "\n     Settings   \n" +
                        "-------------------");

        // List of settings here
        System.out.println("Number of results:\t" + cfg.getRows() + " (0 = ALL)");
        System.out.println("Year:\t\t\t" + cfg.getYear());

        System.out.println(
                        "-------------------");


    }



}
